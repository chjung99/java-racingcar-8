package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Player;

import java.util.List;

public class ResultView {

    public void printWinners(List<Player> winners) {
        System.out.print(Message.WINNER_TITLE + " : ");
        List<String> nameOfWinners = winners.stream().map(player -> player.getName()).toList();
        System.out.println(String.join(", ", nameOfWinners));
    }

    public void printTurnResult(List<Player> players) {
        System.out.println(Message.RESULT_TITLE);

        for (Player player : players) {
            System.out.print(player.getName() + " : ");
            printCarLocation(player.getCar());
        }

        System.out.println();
    }

    private void printCarLocation(Car car) {
        System.out.println("-".repeat(car.getLocation()));
    }


}
