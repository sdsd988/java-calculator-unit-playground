package movingcar;

public class Car {

    private String carName;
    private int position;
    private MovingIndicator movingIndicator;

    public Car(String carName, MovingIndicator movingIndicator) {
        this.carName = carName;
        this.movingIndicator = movingIndicator;
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        if (movingIndicator.move()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
