public class CustomDelimiterSplit implements DelimiterSplit{

    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    @Override
    public String[] InputStringSplitByDelimiter(String calculatorInput) {

        int delimiterEndIndex = calculatorInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = calculatorInput.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
        customDelimiter = escapeSpecialRegexChars(customDelimiter);
        String substrings = calculatorInput.substring(delimiterEndIndex + 1);
        return substrings.split(customDelimiter);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1");
    }

    //todo 구분자 길이가 한개가 아닌 경우 예외 발생?(::,;;,:,)
    public boolean isCustomDelimiter(String calculatorInput) {
        if (!calculatorInput.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return false;
        }

        int startIndex = calculatorInput.indexOf("//");
        int endIndex = calculatorInput.indexOf("\n");

        String delimiter = "";

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex + 2) {
            delimiter = calculatorInput.substring(startIndex + 2, endIndex); // "//" 이후부터 "\\n" 전까지 추출
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
