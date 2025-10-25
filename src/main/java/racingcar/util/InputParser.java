package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseCarNames(String inputCarNames) {
        String[] arrayOfCarName = inputCarNames.split(",");

        return Arrays.stream(arrayOfCarName).toList();
    }

    public int parseGameCount(String inputGameCount) {
        return Integer.parseInt(inputGameCount);
    }
}
