package cleancode.minesweeper.tobe2.minsweeper.io;

import cleancode.minesweeper.tobe2.minsweeper.board.GameBoard;
import cleancode.minesweeper.tobe2.minsweeper.exception.GameException;

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
