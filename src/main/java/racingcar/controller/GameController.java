package racingcar.controller;

import racingcar.model.GameConfig;
import racingcar.repository.GameRepository;
import racingcar.repository.InMemoryGameRepository;
import racingcar.service.GameService;
import racingcar.util.InputParser;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    private final GameRepository gameRepository = new InMemoryGameRepository();
    private final GameService gameService = new GameService(gameRepository);

    public void run() {
        GameConfig gameConfig = initGame(getCarNames(), getGameCount());
        playGame(gameConfig);
        closeGame();
    }

    private List<String> getCarNames() {
        String inputCarNames = inputView.readCarNames();
        inputValidator.validateCarNames(inputCarNames);

        return inputParser.parseCarNames(inputCarNames);
    }

    private int getGameCount() {
        String inputGameCount = inputView.readGameCount();
        inputValidator.validateGameCount(inputGameCount);

        return inputParser.parseGameCount(inputGameCount);
    }

    private GameConfig initGame(List<String> carNames, int gameCount) {
        GameConfig gameConfig = new GameConfig(gameCount);
        gameService.initGame(carNames);

        return gameConfig;
    }

    private void playGame(GameConfig gameConfig) {
        for (int i = 0; i < gameConfig.totalTurn; i++) {
            gameService.playGame();
            resultView.printTurnResult(gameService.getPlayers());
        }
    }

    private void closeGame() {
        resultView.printWinners(gameService.findWinners());
    }

}
