package cleancode.studycafe.seokju_tobe.io;

import cleancode.studycafe.seokju_tobe.model.StudyCafePass;
import cleancode.studycafe.seokju_tobe.model.StudyCafePassType;
import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();
}
