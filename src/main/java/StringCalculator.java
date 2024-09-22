public class StringCalculator {

    public int sum(String input) {

        validateInput(input);
        
        String delimiter = ",|:";  // 기본 구분자
        String numbers = input;

        // 커스텀 구분자가 있을 경우 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
            delimiter = escapeSpecialRegexChars(delimiter);   // 정규식 메타 문자 이스케이프 처리
            numbers = input.substring(delimiterEndIndex + 1);  // 숫자 부분 추출
        }

        // 지정된 구분자로 문자열 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            if (!token.matches("-?\\d+")) {
                throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다: " + token);
            }
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }
        return sum;
    }

    private static void validateInput(String input) {
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
