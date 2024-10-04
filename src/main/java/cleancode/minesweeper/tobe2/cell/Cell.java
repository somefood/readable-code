package cleancode.minesweeper.tobe2.cell;

public interface Cell {

    boolean isLandMine();

    boolean hasLandMineCount();
    
    CellSnapshot getSnapshot();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();
}
