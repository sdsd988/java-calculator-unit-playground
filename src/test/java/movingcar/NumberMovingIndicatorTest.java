package movingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberMovingIndicatorTest {

    @DisplayName("기본 생성자는 랜덤으로 숫자를 반환한다.")
    @Test
    void defaultTest() {
        //given
        NumberMovingIndicator indicator = new NumberMovingIndicator();
        Car car = new Car("K5", indicator);
        //when
        car.move();
        //then
        Assertions.assertTrue(car.getPosition()==0 || car.getPosition()==1);
    }

    @DisplayName("4이상의 숫자를 입력받으면 True 반환")
    @Test
    void highNumberInputTest() {
        //given
        int moveNumber = 4;
        NumberMovingIndicator indicator = new NumberMovingIndicator(moveNumber);
        //when
        boolean result = indicator.check();
        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("4이하의 숫자를 입력받으면 True 반환")
    @Test
    void rowNumberInputTest() {
        //given
        int moveNumber = 3;
        NumberMovingIndicator indicator = new NumberMovingIndicator(moveNumber);
        Car car = new Car("K5", indicator);
        //when
        boolean result = indicator.check();
        //then
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,10,15})
    @DisplayName("0~9 이외의 숫자는 예외를 반환한다.")
    void randomNumberIllegalArgument(int randomNumber) {
        MovingIndicator randomMoveIndicator = new NumberMovingIndicator(randomNumber);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
                randomMoveIndicator.check());
        assertEquals(exception.getMessage(), "랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
    }


}