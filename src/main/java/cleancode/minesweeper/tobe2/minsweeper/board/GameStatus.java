package cleancode.minesweeper.tobe2.minsweeper.board;

public enum GameStatus {

    IN_PROGRESS("진행중"),
    WIN("승리"),
    LOSE("패배")
    ;

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }
}
