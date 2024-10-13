package calculator;

import java.util.List;

public class StringCalculator {

    private static final List<DelimiterSplit> delimiterSplits = List.of(
            new DefaultDelimiterSplit(),
            new CustomDelimiterSplit()
    );

    public int sum(String calculatorInput) {
        validateInput(calculatorInput);
        String[] inputSplitToken = splitCalculatorInput(calculatorInput);
        validateToken(inputSplitToken);
        return summarizeToken(inputSplitToken);
    }

    private String[] splitCalculatorInput(String calculatorInput) {
        for (DelimiterSplit delimiterSplit : delimiterSplits) {
            if (delimiterSplit.supports()) {
                return delimiterSplit.inputStringSplitByDelimiter(calculatorInput);
            }
        }
        throw new RuntimeException("지원되는 스플리터가 없습니다.");
    }

    private int summarizeToken(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (isNotEmpty(token)) {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }

    private boolean isNotEmpty(String token) {
        return !token.trim().isEmpty();
    }

    private void validateToken(String[] tokens) {
        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) {
                continue;
            }
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
    }

}
