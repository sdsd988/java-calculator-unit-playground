package movingcar.io;

import movingcar.Car;

import java.util.List;
import java.util.stream.Collectors;


public class ConsoleOutputHandler {

    public static void getWinners(List<Car> cars) {

        String result  = cars.stream()
                .map(Car::getName)  // Car 객체를 이름(String)으로 변환
                .collect(Collectors.joining(", ", "우승자는 ", "입니다"));

        System.out.println(result);
    }
}
