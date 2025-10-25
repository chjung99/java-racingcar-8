package racingcar.repository;

import racingcar.model.Player;

import java.util.List;

public interface GameRepository {
    void addPlayer(Player player);

    List<Player> getPlayers();
}
