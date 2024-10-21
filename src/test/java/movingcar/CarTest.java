package movingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    @DisplayName("자동차는 이름이 있다")
    void createCar() {
        Car car = new Car("K5");
        String result = car.getName();
        Assertions.assertEquals(result,"K5");
    }

    @ParameterizedTest
    @DisplayName("4이하의 숫자를 받으면 자동차는 이동하지 않음")
    @MethodSource("stopArguments")
    public void testStopByRandomNumber(int randomNumber, int position) {
        MovingIndicator randomMoveIndicator = new NumberMovingIndicator(randomNumber);
        Car car = new Car("K5", randomMoveIndicator);
        car.move();
        assertEquals(position,car.getPosition());
    }

    @ParameterizedTest
    @DisplayName("4이상의 숫자를 받으면 자동차는 이동")
    @MethodSource("moveArguments")
    public void testDrivingRandomNumber(int randomNumber, int position) {
        MovingIndicator randomMoveIndicator = new NumberMovingIndicator(randomNumber);
        Car car = new Car("K5",randomMoveIndicator);
        car.move();
        assertEquals(car.getPosition(),position);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1,10,15})
    @DisplayName("랜덤 인자는 0~9 사이의 숫자만 가능")
    void randomNumberIllegalArgument(int randomNumber) {
        MovingIndicator randomMoveIndicator = new NumberMovingIndicator(randomNumber);
        Car car = new Car("K5",randomMoveIndicator);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                car::move);
        assertEquals(exception.getMessage(), "랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
    }




    private static Stream<Arguments> moveArguments() {
        return Stream.of(
                Arguments.arguments(4, 1),
                Arguments.arguments(5, 1),
                Arguments.arguments(6, 1),
                Arguments.arguments(7, 1),
                Arguments.arguments(8, 1),
                Arguments.arguments(9, 1)
        );
    }

}