package cleancode.minesweeper.tobe2;

import cleancode.minesweeper.tobe2.gamelevel.Advanced;
import cleancode.minesweeper.tobe2.gamelevel.Beginner;
import cleancode.minesweeper.tobe2.gamelevel.GameLevel;
import cleancode.minesweeper.tobe2.gamelevel.Middle;
import cleancode.minesweeper.tobe2.gamelevel.VeryBeginner;
import cleancode.minesweeper.tobe2.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe2.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe2.io.InputHandler;
import cleancode.minesweeper.tobe2.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        final InputHandler inputHandler = new ConsoleInputHandler();
        final OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }
}
