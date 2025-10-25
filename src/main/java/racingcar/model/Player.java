package racingcar.model;

public class Player {
    private final Car car;
    private final String name;

    public Player(Car car, String name) {
        this.car = car;
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public void moveCar(int count) {
        car.moveForward(count);
    }
}
