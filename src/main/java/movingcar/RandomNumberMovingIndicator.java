package movingcar;

public class RandomNumberMovingIndicator implements MovingIndicator {

    public static final int MOVE_BENCHMARK = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;
    private int randomNumber;

    public RandomNumberMovingIndicator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean move() {
        validateParam(randomNumber);
        return randomNumber >= MOVE_BENCHMARK;
    }

    public void validateParam(int number) {
        if(checkNumberRange(number)) {
            throw new IllegalArgumentException("랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
        }
    }

    private static boolean checkNumberRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }


}
