package cleancode.minesweeper.tobe2;

import cleancode.minesweeper.tobe2.gamelevel.Advanced;
import cleancode.minesweeper.tobe2.gamelevel.Beginner;
import cleancode.minesweeper.tobe2.gamelevel.GameLevel;
import cleancode.minesweeper.tobe2.gamelevel.Middle;
import cleancode.minesweeper.tobe2.gamelevel.VeryBeginner;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        Minesweeper minesweeper = new Minesweeper(gameLevel);
        minesweeper.run();
    }
}
