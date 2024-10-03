package cleancode.minesweeper.tobe2.io;

import cleancode.minesweeper.tobe2.GameBoard;
import cleancode.minesweeper.tobe2.GameException;

public interface OutputHandler {

    void showGameStartComments();

    void showBoard(GameBoard board);

    void showGameWinningComment();

    void showGameLosingComment();

    void showCommentForSelectingCell();

    void showCommentForUserAction();

    void showExceptionMessage(GameException e);

    void showSimpleMessage(String message);
}
