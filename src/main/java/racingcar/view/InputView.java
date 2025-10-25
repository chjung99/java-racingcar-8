package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public void printInputCarNamesPrompt() {
        System.out.println(Message.INPUT_CAR_NAMES);
    }

    public void printInputTryCountPrompt() {
        System.out.println(Message.INPUT_TRY_COUNT);
    }

    public String readCarNames() {
        printInputCarNamesPrompt();

        return readLine();
    }

    public String readGameCount() {
        printInputTryCountPrompt();

        return readLine();
    }
}
