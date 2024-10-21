package movingcar;

public class Car {

    private String name;
    private int position;
    private MovingIndicator movingIndicator;

    public Car(String name, MovingIndicator movingIndicator) {
        this.name = name;
        this.movingIndicator = movingIndicator;
    }

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (movingIndicator.check()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean doesMatch(int position) {
        return this.position == position;
    }

    public void showPosition() {
        System.out.println(name + ":" + "-".repeat(position));

    }
}
