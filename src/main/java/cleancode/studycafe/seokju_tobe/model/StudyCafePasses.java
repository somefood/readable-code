package cleancode.studycafe.seokju_tobe.model;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePasses {

    private List<StudyCafePass> passes;

    private StudyCafePasses(List<StudyCafePass> passes) {
        this.passes = new ArrayList<>(passes);
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
        return new StudyCafePasses(studyCafePasses);
    }

    public StudyCafePasses findBy(StudyCafePassType studyCafePassType) {
        final List<StudyCafePass> result = passes.stream()
            .filter(pass -> pass.getPassType() == studyCafePassType)
            .toList();

        return of(result);
    }

    public int size() {
        return passes.size();
    }

    public StudyCafePass get(int index) {
        return passes.get(index);
    }
}
