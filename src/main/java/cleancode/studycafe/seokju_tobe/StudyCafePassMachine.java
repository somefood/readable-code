package cleancode.studycafe.seokju_tobe;

import cleancode.studycafe.seokju_tobe.exception.AppException;
import cleancode.studycafe.seokju_tobe.io.InputHandler;
import cleancode.studycafe.seokju_tobe.io.OutputHandler;
import cleancode.studycafe.seokju_tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.seokju_tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePassType;
import cleancode.studycafe.seokju_tobe.model.StudyCafePasses;
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
            if (canUseLocker(lockerPass)) {
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

    private boolean canUseLocker(StudyCafeLockerPass lockerPass) {
        return lockerPass != StudyCafeLockerPass.NONE;
    }

    private StudyCafePass findSelectedPass(StudyCafePassType passType) {
        StudyCafePasses studyCafePasses = STUDY_CAFE_FILE_HANDLER.readStudyCafePasses();
        final StudyCafePasses findPasses = studyCafePasses.findBy(passType);
        outputHandler.showPassListForSelection(findPasses);
        return inputHandler.getSelectPass(findPasses);
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
