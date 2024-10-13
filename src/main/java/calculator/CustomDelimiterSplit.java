package calculator;

public class CustomDelimiterSplit implements DelimiterSplit {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private final DelimiterType delimiterType = DelimiterType.CUSTOM;

    @Override
    public boolean supports() {
        return false;
    }

    @Override
    public String[] inputStringSplitByDelimiter(String calculatorInput) {

        int delimiterEndIndex = calculatorInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = calculatorInput.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
        customDelimiter = escapeSpecialRegexChars(customDelimiter);
        String substrings = calculatorInput.substring(delimiterEndIndex + 1);
        if (substrings.split(customDelimiter).length > (substrings.length() / 2)) {
            throw new RuntimeException("잘못된 구분자가 토큰에 포함되어있습니다.");
        }
        return substrings.split(customDelimiter);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1");
    }

    private boolean isCustomDelimiter(String calculatorInput) {
        if (!calculatorInput.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return false;
        }

        int startIndex = calculatorInput.indexOf("//");
        int endIndex = calculatorInput.indexOf("\n");
        String delimiter = "";

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex + 2) {
            delimiter = calculatorInput.substring(startIndex + 2, endIndex);
        }

        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("구분자가 잘못되었습니다.");
        }

        String expectedPrefix = CUSTOM_DELIMITER_PREFIX + delimiter + CUSTOM_DELIMITER_SUFFIX;
        if (!calculatorInput.startsWith(expectedPrefix)) {
            return false;
        }
        return true;
    }
}
