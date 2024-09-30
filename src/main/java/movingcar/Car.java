package movingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private String carName;

    public CarStatus drivingCarByRandomNumber(int randomNumber) {
        if (canDrive(randomNumber)) {
            return driving();
        }
       return stop();
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
