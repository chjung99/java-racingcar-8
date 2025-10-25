package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Player;
import racingcar.repository.GameRepository;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public void initGame(List<String> carNames) {

        for (String name : carNames) {
            String carName = name;
            String playerName = name;

            Car car = new Car(carName, playerName);
            Player player = new Player(car, playerName);

            repository.addPlayer(player);
        }
    }

    public List<Player> getPlayers() {
        return repository.getPlayers();
    }

    public void playGame() {
        for (Player player : repository.getPlayers()) {
            if (pickNumberInRange(0, 9) >= 4) {
                player.moveCar(1);
            }
        }
    }

    public List<Player> findWinners() {
        int maxLocation = repository.getPlayers().stream()
                .mapToInt(player -> player.getCar().getLocation()).max().orElse(0);

        return repository.getPlayers().stream().
                filter(player -> player.getCar().getLocation() == maxLocation).toList();
    }

}
