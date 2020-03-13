import Domain.CarValidator;
import Domain.TransactionValidator;
import Repo.CarRepo;
import Repo.TransactionRepo;
import Service.CarService;
import Service.TransactionService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        CarValidator carValidator = new CarValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        CarRepo carRepo = new CarRepo(carValidator);
        TransactionRepo transactionRepo = new TransactionRepo(transactionValidator);

        CarService carService = new CarService(carRepo);
        TransactionService transactionService = new TransactionService(transactionRepo, carRepo);

        Console console = new Console(carService, transactionService);
        console.run();
    }
}
