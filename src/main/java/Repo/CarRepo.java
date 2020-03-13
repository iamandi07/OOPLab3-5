package Repo;

import Domain.Car;
import Domain.CarValidator;
import Domain.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepo {

    private Map<Integer, Car> cars = new HashMap<>();
    private CarValidator validator;

    public CarRepo(CarValidator validator) {
        this.validator = validator;
    }

    public Car findbyId(int id) {
        return cars.get(id);
    }

    public void add(Car car) {
        if (cars.containsKey(car.getId())) {
            throw new RuntimeException("The reg number with that ID already exists!");
        }

        validator.validate(car);
        cars.put(car.getId(), car);
    }

    public Car read(int id){
        return cars.get(id);
    }

    public List<Car> read() {
        List<Car> results = new ArrayList<>();
        for (Car car : cars.values()) {
            Car toAdd = new Car(
                    car.getId(),
                    car.getAcquisitionDate(),
                    car.getDistance(),
                    car.getModel(),
                    car.isWarranty()
            );
            results.add(toAdd);
        }
        return results;
        //return new ArrayList<>(storage.values());
    }

    public List<Car> getAll() {
        return new ArrayList<>(cars.values());
    }


    public void update(Car car) {
        if (!cars.containsKey(car.getId())) {
            throw new RuntimeException("The entry ID does not exist!");
        }
        validator.validate(car);
        cars.put(car.getId(), car);
    }

    public void remove(int id){
        if (!cars.containsKey(id)) {
            throw new RuntimeException("There are no entities with the same id");
        }
        cars.remove(id);
    }

    public Map<Integer, Car> getCar() {
        return cars;

    }
}
