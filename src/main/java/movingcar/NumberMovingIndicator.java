package movingcar;

import java.util.Random;

public class NumberMovingIndicator implements MovingIndicator {

    private static final int MOVE_BENCHMARK = 4;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private int randomNumber;

    public NumberMovingIndicator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public NumberMovingIndicator() {
        this.randomNumber = randomNumber();
    }

    @Override
    public boolean check() {
        validateNumber(randomNumber);
        return randomNumber >= MOVE_BENCHMARK;
    }

    public void validateNumber(int number) {
        if(checkNumberRange(number)) {
            throw new IllegalArgumentException("랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
        }
    }

    private boolean checkNumberRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }

    private int randomNumber() {
        return new Random().nextInt(10);
    }


}
