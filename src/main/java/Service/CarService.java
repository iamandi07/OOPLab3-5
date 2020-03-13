package Service;

import Domain.Car;
import Repo.CarRepo;

import java.util.*;

public class CarService {

    private CarRepo repo;

    public CarService(CarRepo repo) {
        this.repo = repo;
    }

    public void add(int id, int acquisitionDate, int distance, String model, boolean warranty) {

        Car car = new Car (id, acquisitionDate, distance, model, warranty);
        repo.add(car);
    }

    public void remove (int id) {
        repo.remove(id);
    }

    public List<Car> showCars(){
        return repo.getAll();
    }

    public void update(int id, int acquisitionDate, int distance, String model, boolean warranty) {
        Car car = new Car(id, acquisitionDate, distance, model, warranty);
        repo.update(car);
    }
    public CarRepo getRepo() {return repo;}

}

