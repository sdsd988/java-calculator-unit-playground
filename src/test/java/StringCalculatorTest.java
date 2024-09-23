import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    // 무엇을 테스트 해야 하나
    // 1. 성공 테스트 - 기본, 커스텀 구분자
    // 2. 예외 테스트 - 기본, 커스텀 구분자 음수, 문자열
    @Test
    @DisplayName("성공 : 기본 구분자(쉼표, 콜론)를 사용하는 경우")
    void testSumWithDefaultDelimiters() {
        assertEquals(6, new StringCalculator().sum("1,2,3"));
        assertEquals(15, new StringCalculator().sum("4:5:6"));
        assertEquals(24, new StringCalculator().sum("7,8:9"));
    }

    @Test
    @DisplayName("성공 : 커스텀 구분자를 사용하는 경우")
    void testSumWithCustomDelimiter() {
        assertEquals(6, new StringCalculator().sum("//;\n1;2;3;"));
    }

    @Test
    @DisplayName("성공 : 커스텀 구분자에 특수문자 사용하는 경우")
    void testSumWithCustomDelimiterWhenSpecialMeaningString() {
        assertEquals(15, new StringCalculator().sum("//|\n4|5|6"));
        assertEquals(15, new StringCalculator().sum("//-\n4-5-6"));
        assertEquals(15, new StringCalculator().sum("//*\n4*5*6"));

    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyInputTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator().sum(input));
    }

    @Test
    @DisplayName("성공 : 긴 공백 입력에 대한 테스트" )
    void testSumWithBlankInput() {
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator().sum("    "));
    }
    @Test
    @DisplayName("예외 : 숫자 이외의 값이 포함된 경우 예외 발생 확인")
    void testExceptionForNonNumericValues() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("1,a,3");
        });
        assertEquals("숫자 이외의 값이 포함되어 있습니다: a", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 디폴트 구분자와 음수 값이 포함된 경우 예외 발생 확인")
    void testExceptionForNegativeNumbers() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자와 음수 값 포함된 경우 예외 발생 확인")
    void testCustomDelimiterWithNegativeNumbers() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;\n1;-2;3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    @DisplayName("예외 : 커스텀 구분자와 비숫자값 포함된 경우 예외 발생 확인")
    void testCustomDelimiterWithNotNumbers() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new StringCalculator().sum("//;\n1;a;3");
        });
        assertEquals("숫자 이외의 값이 포함되어 있습니다: a", exception.getMessage());
    }
}