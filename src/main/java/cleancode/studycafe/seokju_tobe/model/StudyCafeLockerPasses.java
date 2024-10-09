package cleancode.studycafe.seokju_tobe.model;

import java.util.ArrayList;
import java.util.List;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> passes;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> passes) {
        this.passes = new ArrayList<>(passes);
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> studyCafeLockerPasses) {
        return new StudyCafeLockerPasses(studyCafeLockerPasses);
    }

    public StudyCafeLockerPass getStudyCafeLockerPass(StudyCafePass selectedPass) {
        return passes.stream()
            .filter(option -> option.isEqualPssTypeAndDuration(selectedPass))
            .findFirst()
            .orElse(StudyCafeLockerPass.NONE);
    }
}
