package movingcar;

public class Car {

    private String carName;

    public CarStatus drivingCarByRandomNumber(int randomNumber) {
        if (validateRandomNumber(randomNumber)) {
            throw new IllegalArgumentException("랜덤 인자는 0~9 사이의 숫자만 가능합니다.");
        }
        if (canDrive(randomNumber)) {
            return driving();
        }
       return stop();
    }

    private static boolean validateRandomNumber(int randomNumber) {
        return randomNumber < 0 || randomNumber > 9;
    }

    private CarStatus stop() {
        System.out.println("자동차 멈춤");
        return CarStatus.STOP;
    }

    private CarStatus driving() {
        System.out.println("자동차 이동");
        return CarStatus.DRIVING;
    }

    private boolean canDrive(int randomNumber) {
        return randomNumber >= 4;
    }
}
