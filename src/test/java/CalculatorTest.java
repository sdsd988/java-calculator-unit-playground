import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("덧셈 성공 테스트")
    @Test
    void plusSuccessTest() {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.plus(1, 2);

        //then
        assertEquals(result, 3);
    }

    @DisplayName("뺄셈 성공 테스트")
    @Test
    void minusSuccessTest() {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.minus(2, 1);

        //then
        assertEquals(result, 1);
    }

    @DisplayName("곱셈 성공 테스트")
    @Test
    void multiplySuccessTest() {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.multiply(2, 1);

        //then
        assertEquals(result, 2);
    }

    @DisplayName("나눗셈 성공 테스트")
    @Test
    void divideSuccessTest() {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.divide(2, 1);

        //then
        assertEquals(result, 2);
    }

    @DisplayName("나눗셈 예외 테스트 (0으로 나누는 경우)")
    @Test
    void divideFailTest() {

        //given
        Calculator calculator = new Calculator();

        //expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(2, 0));
        assertEquals(exception.getMessage(),"0 으로 나눌 수 없습니다.");
    }


}
