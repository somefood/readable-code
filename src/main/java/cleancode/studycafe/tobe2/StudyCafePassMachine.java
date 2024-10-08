package cleancode.studycafe.tobe2;

import cleancode.studycafe.tobe2.exception.AppException;
import cleancode.studycafe.tobe2.io.StudyCafeIOHandler;

import cleancode.studycafe.tobe2.model.order.StudyCafePassOrder;
import cleancode.studycafe.tobe2.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe2.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.tobe2.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe2.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe2.model.pass.StudyCafeSeatPasses;
import cleancode.studycafe.tobe2.provider.LockerPassProvider;
import cleancode.studycafe.tobe2.provider.SeatPassProvider;
import java.util.List;
import java.util.Optional;

public class StudyCafePassMachine {
    
    private final StudyCafeIOHandler ioHandler = new StudyCafeIOHandler();
    private final SeatPassProvider seatPassProvider;
    private final LockerPassProvider lockerPassProvider;

    public StudyCafePassMachine(SeatPassProvider seatPassProvider, LockerPassProvider lockerPassProvider) {
        this.seatPassProvider = seatPassProvider;
        this.lockerPassProvider = lockerPassProvider;
    }

    public void run() {
        try {
            ioHandler.showWelcomeMessage();
            ioHandler.showAnnouncement();

            StudyCafeSeatPass selectedPass = getSelectedPass();
            Optional<StudyCafeLockerPass> optionalLockerPass = selectLockerPass(selectedPass);
            StudyCafePassOrder passOrder = StudyCafePassOrder.of(
                selectedPass,
                optionalLockerPass.orElse(null)
            );
            
            ioHandler.showPassOrderSummary(passOrder);
        } catch (AppException e) {
            ioHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeSeatPass getSelectedPass() {
        StudyCafePassType passType = ioHandler.askPassTypeSelecting();
        List<StudyCafeSeatPass> passCandidates = findPassCandidatesBy(passType);
        
        return ioHandler.askPassSelecting(passCandidates);
    }

    private List<StudyCafeSeatPass> findPassCandidatesBy(StudyCafePassType studyCafePassType) {
        StudyCafeSeatPasses allPasses = seatPassProvider.getSeatPasses();
        return allPasses.findPassBy(studyCafePassType);
    }

    private Optional<StudyCafeLockerPass> selectLockerPass(StudyCafeSeatPass selectedPass) {
        // 고정 좌석 타입이 아닌가? (너무 구체적인가)
        // 추상화 레벨을 높여보자 -> 사물함 옵션을 사용할 수 있는 타입이 아닌가?
        if (selectedPass.cannotUseLocker()) {
            return Optional.empty();
        }

        Optional<StudyCafeLockerPass> lockerPassCandidate = findLockerPassCandidateBy(selectedPass);

        if (lockerPassCandidate.isPresent()) {
            StudyCafeLockerPass lockerPass = lockerPassCandidate.get();
            boolean isLockerSelected = ioHandler.askLockerPass(lockerPass);
            
            if (isLockerSelected){
                return Optional.of(lockerPass);
            }
        }
        
        return Optional.empty();
    }

    private Optional<StudyCafeLockerPass> findLockerPassCandidateBy(StudyCafeSeatPass pass) {
        StudyCafeLockerPasses allLockerPasses = lockerPassProvider.getLockerPasses();
        return allLockerPasses.findLockerPassBy(pass);
    }

}
