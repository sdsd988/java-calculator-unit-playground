
public class StringCalculator {

    public int sum(String calculatorInput) {
        validateInput(calculatorInput);
        String[] inputSplitToken = splitCalculatorInput(calculatorInput);
        validateToken(inputSplitToken);
        return summarizeToken(inputSplitToken);
    }


    private String[] splitCalculatorInput(String calculatorInput) {

        if (calculatorInput.startsWith("//")) {
            return customDelimiterSplit(calculatorInput);
        } else {
            return defaultDelimiterSplit(calculatorInput);
        }
    }

    private String[] defaultDelimiterSplit(String calculatorInput) {

        String defaultDelimiter = ",|:";  // 기본 구분자

        return calculatorInput.split(defaultDelimiter);
    }

    private String[] customDelimiterSplit(String calculatorInput) {
        int delimiterEndIndex = calculatorInput.indexOf("\n");
        String customDelimiter = calculatorInput.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
        customDelimiter = escapeSpecialRegexChars(customDelimiter);   // 정규식 메타 문자 이스케이프 처리
        String substrings = calculatorInput.substring(delimiterEndIndex + 1);// 숫자 부분 추출
        return substrings.split(customDelimiter);
    }

    private int summarizeToken(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private void validateToken(String[] tokens) {
        for (String token : tokens) {
            token = token.trim();
            if (!token.matches("-?\\d+")) {
                throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다: " + token);
            }
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다: " + number);
            }

        }
    }
    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 값은 입력될 수 없습니다.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백값은 입력될 수 없습니다.");
        }
    }
    // 정규식 메타 문자를 이스케이프하는 메소드
    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1");
    }

}
