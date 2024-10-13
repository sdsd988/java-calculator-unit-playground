import calculator.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @Test
    @DisplayName("성공 : 기본 구분자(쉼표, 콜론)를 사용하는 경우")
    void testSumWithDefaultDelimiters() {
        Assertions.assertEquals(6, new StringCalculator().sum("1,2,3"));
        Assertions.assertEquals(15, new StringCalculator().sum("4:5:6"));
    }

    @Test
    @DisplayName("성공 : 기본 구분자(쉼표, 콜론)를 함께 사용하는 경우")
    void testSumWithMixDefaultDelimiters() {
        Assertions.assertEquals(24, new StringCalculator().sum("7,8:9"));
    }

    @Test
    @DisplayName("성공 : 커스텀 구분자를 사용하는 경우")
    void testSumWithCustomDelimiter() {
        Assertions.assertEquals(6, new StringCalculator().sum("//;\n1;2;3;"));
    }


    @ParameterizedTest
    @ValueSource(strings = {"//|\n4|5|6","//-\n4-5-6","//*\n4*5*6"})
    @DisplayName("성공 : 커스텀 구분자에 특수문자 사용하는 경우")
    void testSumWithCustomDelimiterWhenSpecialMeaningString(String value) {
        Assertions.assertEquals(15, new StringCalculator().sum(value));
    }

    @Test
    @DisplayName("성공 : 공백 입력에 대한 테스트" )
    void testSumWithBlankInput() {
        Assertions.assertEquals(0 , new StringCalculator().sum(""));
    }

    @Test
    @DisplayName("성공 : 긴 공백 입력에 대한 테스트" )
    void testSumWithLongBlankInput() {
        Assertions.assertEquals(0, new StringCalculator().sum("    "));
    }
    @Test
    @DisplayName("예외 : 숫자 이외의 값이 포함된 경우 예외 발생")
    void testExceptionForNonNumericValues() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("1,a,3");
        });
        Assertions.assertEquals("숫자 이외의 값이 포함되어 있습니다: a", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 디폴트 구분자와 음수 값이 포함된 경우 예외 발생")
    void testExceptionForNegativeNumbers() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("1,-2,3");
        });
        Assertions.assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자와 음수 값 포함된 경우 예외 발생 ")
    void testCustomDelimiterWithNegativeNumbers() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;\n1;-2;3");
        });
        Assertions.assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자와 비숫자값 포함된 경우 예외 발생")
    void testCustomDelimiterWithNotNumbers() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;\n1;a;3");
        });
        Assertions.assertEquals("숫자 이외의 값이 포함되어 있습니다: a", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자가 하나 이상이면 예외 발생 ")
    void testCustomDelimiterLength() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;;\n1;2;*3");
        });
        Assertions.assertEquals("구분자가 잘못되었습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자가 하나 이상이면 예외 발생 ")
    void testCustomDelimiterLength2() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;\n1;2*3");
        });
        Assertions.assertEquals("잘못된 구분자가 토큰에 포함되어있습니다.", exception.getMessage());
    }






}