package cleancode.minesweeper.tobe2.minsweeper.io;

import cleancode.minesweeper.tobe2.minsweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe2.minsweeper.user.UserAction;

public interface InputHandler {
    
    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
