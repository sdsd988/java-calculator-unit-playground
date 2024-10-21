package movingcar;

import movingcar.io.ConsoleInputHandler;
import movingcar.io.ConsoleOutputHandler;

import java.util.Arrays;
import java.util.Scanner;

public class CarGame {

    public static void main(String[] args) {

        String[] carNames = ConsoleInputHandler.getCarNameFromUser();
        int count = ConsoleInputHandler.getRacingCountFromUser();

        CarRacing carRacing = new CarRacing(count, carNames);
        carRacing.race();

        ConsoleOutputHandler.getWinners(carRacing.getWinners());


    }


}
