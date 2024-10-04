package cleancode.minesweeper.tobe2;

import cleancode.minesweeper.tobe2.config.GameConfig;
import cleancode.minesweeper.tobe2.gamelevel.Advanced;
import cleancode.minesweeper.tobe2.gamelevel.Beginner;
import cleancode.minesweeper.tobe2.gamelevel.GameLevel;
import cleancode.minesweeper.tobe2.gamelevel.Middle;
import cleancode.minesweeper.tobe2.gamelevel.VeryBeginner;
import cleancode.minesweeper.tobe2.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe2.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        final GameConfig gameConfig = new GameConfig(
            new Beginner(),
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );

        Minesweeper minesweeper = new Minesweeper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }
}
