package movingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {


    @Test
    @DisplayName("레이싱 횟수가 0이하면 오류")
    void carRacingFailTest1() {
        //given
        Car car1 = new Car("1번차", new NumberMovingIndicator());
        Car car2 = new Car("2번차", new NumberMovingIndicator());
        Car car3 = new Car("3번차", new NumberMovingIndicator());
        Car car4 = new Car("4번차", new NumberMovingIndicator());
        List<Car> participateList = List.of(car1, car2, car3, car4);
        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CarRacing(-4, participateList) );
        assertEquals(exception.getMessage(), "레이싱 횟수는 0회 이상이어야 합니다.");
    }

    @Test
    @DisplayName("참가하는 자동차가 0이하면 오류")
    void carRacingFailTest2() {
        //given
        List<Car> participateList = List.of();
        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CarRacing(4, participateList) );
        assertEquals(exception.getMessage(), "참가하는 자동차가 1대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("우승자 1명 테스트")
    void carRacingSuccessTest() {
        //given
        Car car1 = new Car("1번차", new NumberMovingIndicator(numberMoreThanMaxBenchmark()));
        Car car2 = new Car("2번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car3 = new Car("3번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car4 = new Car("4번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        List<Car> participateList = List.of(car1, car2, car3, car4);

        //when
        CarRacing carRacing = new CarRacing(3, participateList);
        carRacing.race();
        //then
        assertEquals(1, carRacing.getWinners().size());
    }

    @Test
    @DisplayName("우승자 2명 테스트")
    void carRacingSuccessTest2() {
        //given
        Car car1 = new Car("1번차", new NumberMovingIndicator(numberMoreThanMaxBenchmark()));
        Car car2 = new Car("2번차", new NumberMovingIndicator(numberMoreThanMaxBenchmark()));
        Car car3 = new Car("3번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car4 = new Car("4번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        List<Car> participateList = List.of(car1, car2, car3, car4);
        //when
        CarRacing carRacing = new CarRacing(3, participateList);
        carRacing.race();
        //then
        assertEquals(2, carRacing.getWinners().size());
    }

    @Test
    @DisplayName("우승자 4명 테스트")
    void carRacingSuccessTest3() {
        //given
        Car car1 = new Car("1번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car2 = new Car("2번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car3 = new Car("3번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        Car car4 = new Car("4번차", new NumberMovingIndicator(numberLessThanMaxBenchmark()));
        List<Car> participateList = List.of(car1, car2, car3, car4);
        //when
        CarRacing carRacing = new CarRacing(3, participateList);
        carRacing.race();
        //then
        assertEquals(4, carRacing.getWinners().size());
    }

    @Test
    @DisplayName("racing 횟수에 따라 움직인다.")
    void racingCountTest() {
        //given
        Car car1 = new Car("1번차", new NumberMovingIndicator(numberMoreThanMaxBenchmark()));
        List<Car> participateList = List.of(car1);

        //when
        CarRacing carRacing = new CarRacing(3, participateList);
        carRacing.race();

        //then
        assertEquals(3, carRacing.getWinners().get(0).getPosition());

    }

    private int randomNumber() {
        return new Random().nextInt(10);
    }

    private int numberMoreThanMaxBenchmark() {
        return new Random().nextInt(6)+4;
    }

    private int numberLessThanMaxBenchmark() {
        return new Random().nextInt(3);
    }



}