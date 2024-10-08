package cleancode.studycafe.seokju_tobe;

import cleancode.studycafe.seokju_tobe.io.ConsoleInputHandler;
import cleancode.studycafe.seokju_tobe.io.ConsoleOutputHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );
        studyCafePassMachine.run();
    }

}
