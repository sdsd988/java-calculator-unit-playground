public class StringCalculator {

    private final DefaultDelimiterSplit defaultDelimiterSplit= new DefaultDelimiterSplit();
    private final CustomDelimiterSplit customDelimiterSplit = new CustomDelimiterSplit();

    public int sum(String calculatorInput) {
        validateInput(calculatorInput);
        String[] inputSplitToken = splitCalculatorInput(calculatorInput);
        validateToken(inputSplitToken);
        return summarizeToken(inputSplitToken);
    }

    // todo 리팩토링 (Custom, Default 따라 적절한 DelimiterSplit 주입되서 Interface 활용할 수 있게)
    private String[] splitCalculatorInput(String calculatorInput) {
        if (customDelimiterSplit.isCustomDelimiter(calculatorInput)) {
            return customDelimiterSplit.InputStringSplitByDelimiter(calculatorInput);
        }
        return defaultDelimiterSplit.InputStringSplitByDelimiter(calculatorInput);
    }

    private int summarizeToken(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
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
