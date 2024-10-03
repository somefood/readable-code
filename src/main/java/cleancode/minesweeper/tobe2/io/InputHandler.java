package cleancode.minesweeper.tobe2.io;

import cleancode.minesweeper.tobe2.position.CellPosition;

public interface InputHandler {

    String getUserInput();

    CellPosition getCellPositionFromUser();
}
