package cleancode.minesweeper.tobe2.io;

import cleancode.minesweeper.tobe2.position.CellPosition;
import cleancode.minesweeper.tobe2.user.UserAction;

public interface InputHandler {
    
    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
