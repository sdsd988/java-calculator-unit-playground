public class DefaultDelimiterSplit implements DelimiterSplit {
    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String[] InputStringSplitByDelimiter(String calculatorInput) {
        return calculatorInput.split(DEFAULT_DELIMITER);
    }
}
