package cleancode.studycafe.seokju_tobe.io;

import cleancode.studycafe.seokju_tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePasses;
import java.util.List;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(StudyCafePasses passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);
}
