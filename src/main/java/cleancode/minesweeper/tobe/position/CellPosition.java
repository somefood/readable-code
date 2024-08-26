package cleancode.minesweeper.tobe.position;

import java.util.Objects;

public class CellPosition {

    private final int rowIndex;
    private final int colIndex;

    private CellPosition(int rowIndex, int colIndex) {
        if (rowIndex < 0 || colIndex < 0) {
            throw new IllegalArgumentException("올바르지 않은 좌표입니다.");
        }
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public static CellPosition of(int rowIndex, int colIndex) {
        return new CellPosition(rowIndex, colIndex);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CellPosition that = (CellPosition) object;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }
}
