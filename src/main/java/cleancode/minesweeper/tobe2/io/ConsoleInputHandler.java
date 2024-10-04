package cleancode.minesweeper.tobe2.io;

import cleancode.minesweeper.tobe2.BoardIndexConverter;
import cleancode.minesweeper.tobe2.position.CellPosition;
import cleancode.minesweeper.tobe2.user.UserAction;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);

    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

    @Override
    public UserAction getUserActionFromUser() {
        final String userInput = SCANNER.nextLine();
        
        if("1".equals(userInput)) {
            return UserAction.OPEN;
        }
        if("2".equals(userInput)) {
            return UserAction.FLAG;
        }
        
        return UserAction.UNKNOWN;
    }

    @Override
    public CellPosition getCellPositionFromUser() {
        final String userInput = SCANNER.nextLine();

        final int colIndex = boardIndexConverter.getSelectedColIndex(userInput);
        final int rowIndex = boardIndexConverter.getSelectedRowIndex(userInput);
        return CellPosition.of(rowIndex, colIndex);
    }
}
