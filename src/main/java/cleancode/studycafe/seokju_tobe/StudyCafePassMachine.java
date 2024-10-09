package cleancode.studycafe.seokju_tobe;

import cleancode.studycafe.seokju_tobe.exception.AppException;
import cleancode.studycafe.seokju_tobe.io.InputHandler;
import cleancode.studycafe.seokju_tobe.io.OutputHandler;
import cleancode.studycafe.seokju_tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.seokju_tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePassType;
import java.util.List;

public class StudyCafePassMachine {

    private static final StudyCafeFileHandler STUDY_CAFE_FILE_HANDLER = new StudyCafeFileHandler();

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            final StudyCafePass selectedPass = findSelectedPass(studyCafePassType);

            List<StudyCafeLockerPass> lockerPasses = STUDY_CAFE_FILE_HANDLER.readLockerPasses();
            final StudyCafeLockerPass lockerPass = getStudyCafeLockerPass(lockerPasses, selectedPass);

            boolean lockerSelection = false;
            if (lockerPass != StudyCafeLockerPass.NONE) {
                outputHandler.askLockerPass(lockerPass);
                lockerSelection = inputHandler.getLockerSelection();
            }

            if (lockerSelection) {
                outputHandler.showPassOrderSummary(selectedPass, lockerPass);
            } else {
                outputHandler.showPassOrderSummary(selectedPass, null);
            }
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePass findSelectedPass(StudyCafePassType passType) {
        List<StudyCafePass> studyCafePasses = STUDY_CAFE_FILE_HANDLER.readStudyCafePasses();
        List<StudyCafePass> hourlyPasses = studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == passType)
            .toList();
        outputHandler.showPassListForSelection(hourlyPasses);
        return inputHandler.getSelectPass(hourlyPasses);
    }

    private StudyCafeLockerPass getStudyCafeLockerPass(List<StudyCafeLockerPass> lockerPasses,
                                                       StudyCafePass selectedPass) {
        return lockerPasses.stream()
            .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                            && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(StudyCafeLockerPass.NONE);
    }

}
