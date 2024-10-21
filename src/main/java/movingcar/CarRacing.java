package movingcar;

import java.util.Arrays;
import java.util.List;


public class CarRacing {

    private int racingCount;
    private List<Car> carList;

    public CarRacing(int racingCount, List<Car> cars) {
        validate(racingCount, cars.size());
        this.racingCount = racingCount;
        this.carList = cars;
    }

    public CarRacing(int racingCount, String[] carNames) {
        this(racingCount, toCar(carNames));
    }

    private static List<Car> toCar(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, new NumberMovingIndicator()))
                .toList();
    }

    private void validate(int count, long size) {
        if (count <= 0) {
            throw new IllegalArgumentException("레이싱 횟수는 0회 이상이어야 합니다.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("참가하는 자동차가 1대 이상이어야 합니다.");
        }
    }

    public void race() {
        for (int i = 1; i <= racingCount; i++) {
            moveCars();
            showPosition();
        }
    }

    private void showPosition() {
        for (Car car : carList) {
            car.showPosition();
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        return carList.stream()
                .filter(car -> car.doesMatch(winnerPosition))
                .toList();
    }

    private int getWinnerPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }


}
