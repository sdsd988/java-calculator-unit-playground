package movingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarTest {

    // WHAT, HOW

    @ParameterizedTest
    @DisplayName("4이하의 숫자를 받으면 자동차는 이동하지 않는다.")
    @MethodSource("stopNumberAndStatusTestArguments")
    public void testStopByRandomNumber(int v1, CarStatus v2) {

        //given
        Car car = new Car();
        //when
        CarStatus result = car.drivingCarByRandomNumber(v1);

        //then
        Assertions.assertEquals(result,CarStatus.STOP);
    }

    @ParameterizedTest
    @DisplayName("4이상의 숫자를 받으면 자동차는 이동한다.")
    @MethodSource("drivingNumberAndStatusTestArguments")
    public void testDrivingRandomNumber(int v1, CarStatus v2) {

        //given
        Car car = new Car();
        //when
        CarStatus result = car.drivingCarByRandomNumber(v1);

        //then
        Assertions.assertEquals(result,CarStatus.DRIVING);
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