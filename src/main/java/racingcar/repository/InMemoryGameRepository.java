package racingcar.repository;

import racingcar.model.Player;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGameRepository implements GameRepository {
    List<Player> playerList = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    @Override
    public List<Player> getPlayers() {
        return playerList;
    }
}
