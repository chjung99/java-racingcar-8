package racingcar.model;

public class GameConfig {
    public final int totalTurn;
    public static final int MAX_TOTAL_TURN = 1_000;

    public GameConfig(int totalTurn) {
        this.totalTurn = totalTurn;
    }
}
