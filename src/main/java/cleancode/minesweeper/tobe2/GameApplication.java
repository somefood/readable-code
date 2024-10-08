package cleancode.minesweeper.tobe2;

import cleancode.minesweeper.tobe2.minsweeper.Minesweeper;
import cleancode.minesweeper.tobe2.minsweeper.config.GameConfig;
import cleancode.minesweeper.tobe2.minsweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe2.minsweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe2.minsweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe2.minsweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        final GameConfig gameConfig = new GameConfig(
            new Advanced(),
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );

        Minesweeper minesweeper = new Minesweeper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }
}
