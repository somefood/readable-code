package cleancode.studycafe.seokju_tobe.io;

import cleancode.studycafe.seokju_tobe.model.StudyCafePass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePassType;
import cleancode.studycafe.seokju_tobe.model.StudyCafePasses;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(StudyCafePasses passes);

    boolean getLockerSelection();
}
