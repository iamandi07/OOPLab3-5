package Domain;

public class CarValidator {

    public void validate(Car car){

        if (car.getAcquisitionDate() <= 0) {
            throw new RuntimeException("The acquisition date need to be positive");
        }

        if (car.getDistance() <= 0) {
            throw new RuntimeException("The distance need to be positive");
        }
    }

}
