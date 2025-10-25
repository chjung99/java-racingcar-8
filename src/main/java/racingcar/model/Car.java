package racingcar.model;

public class Car {
    private final String name;
    private final String owner;
    private int location;

    public Car(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.location = 0;
    }

    public void moveForward(int count) {
        this.location += count;
    }

    public void stop() {
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getLocation() {
        return location;
    }
}
