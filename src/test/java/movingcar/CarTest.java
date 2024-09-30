package movingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void createCar() {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("4이하의 숫자를 받으면 자동차는 이동하지 않는다.")
    @MethodSource("stopNumberAndStatusTestArguments")
    public void testStopByRandomNumber(int inputRandomInt, CarStatus ExpectedcarStatus) {
        CarStatus result = car.drivingCarByRandomNumber(inputRandomInt);
        assertEquals(result, ExpectedcarStatus);
    }

    @ParameterizedTest
    @DisplayName("4이상의 숫자를 받으면 자동차는 이동한다.")
    @MethodSource("drivingNumberAndStatusTestArguments")
    public void testDrivingRandomNumber(int inputRandomInt, CarStatus ExpectedcarStatus) {
        CarStatus result = car.drivingCarByRandomNumber(inputRandomInt);
        assertEquals(result, ExpectedcarStatus);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,10,15})
    @DisplayName("랜덤 인자는 0~9 사이의 숫자만 가능합니다.")
    void randomNumberIllegalArgument(int value) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> car.drivingCarByRandomNumber(value));
        assertEquals(exception.getMessage(), "랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
    }



    private static Stream<Arguments> stopNumberAndStatusTestArguments() {
        return Stream.of(
                Arguments.arguments(0, CarStatus.STOP),
                Arguments.arguments(1, CarStatus.STOP),
                Arguments.arguments(2, CarStatus.STOP),
                Arguments.arguments(3, CarStatus.STOP)
        );
    }

    private static Stream<Arguments> drivingNumberAndStatusTestArguments() {
        return Stream.of(
                Arguments.arguments(4, CarStatus.DRIVING),
                Arguments.arguments(5, CarStatus.DRIVING),
                Arguments.arguments(6, CarStatus.DRIVING),
                Arguments.arguments(7, CarStatus.DRIVING),
                Arguments.arguments(8, CarStatus.DRIVING),
                Arguments.arguments(9, CarStatus.DRIVING)
        );
    }
}