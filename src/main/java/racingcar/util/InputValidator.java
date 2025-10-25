package racingcar.util;

import racingcar.model.GameConfig;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void validateCarNames(String inputCarNames) {

        String[] arrayOfCarName = inputCarNames.split(",");
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : arrayOfCarName) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다: " + carName);
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다");
            }
            if (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름: " + carName + "에 공백이 포함되어 있습니다");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름: " + carName + "이 5자를 초과했습니다");
            }
        }

    }

    public void validateGameCount(String inputGameCount) {
        try {
            int gameCount = Integer.parseInt(inputGameCount);

            if (gameCount <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 1이상이어야 합니다");
            }
            if (gameCount > GameConfig.MAX_TOTAL_TURN) {
                throw new IllegalArgumentException("시도할 횟수가 최대 가능 횟수를 초과했습니다");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다");
        }
    }
}
