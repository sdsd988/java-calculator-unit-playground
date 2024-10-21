package movingcar.io;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMITER = ",";


    public static String[] getCarNameFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요. (자동차 이름은 쉼표(,)를 기준으로 구분합니다.)");

        final String nameInput = SCANNER.nextLine();

        final String[] names = nameInput.split(DELIMITER);
        validateNames(names);

        return names;
    }

    public static int getRacingCountFromUser() {
        System.out.println("자동차가 이동할 횟수를 입력하세요.");
        return SCANNER.nextInt();
    }

    private static void validateNames(String[] names) {
        if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }


}
