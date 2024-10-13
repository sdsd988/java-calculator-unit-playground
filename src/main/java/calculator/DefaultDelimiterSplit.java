package calculator;

public class DefaultDelimiterSplit implements DelimiterSplit {
    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public boolean supports() {
        return true;
    }

    @Override
    public String[] inputStringSplitByDelimiter(String calculatorInput) {
        return calculatorInput.split(DEFAULT_DELIMITER);
    }
}
