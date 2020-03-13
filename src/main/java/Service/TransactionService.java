package Service;

import Domain.Car;
import Domain.Transaction;
import Repo.*;

import java.util.List;

public class TransactionService {

    private TransactionRepo transactionRepo;
    private CarRepo repo;
    private Car car;
    private Transaction transaction;

    public TransactionService(TransactionRepo transactionRepo, CarRepo repo) {

        this.transactionRepo = transactionRepo;
        this.repo = repo;
    }

    public void add(int id, int carId, int clientCard, double pieceSum, double operationSum, String date, String hour) {
        Car car = this.repo.read(carId);
        if(car == null){
            throw new RuntimeException("The given car is not exist");
        }

        if(car.getDistance() >= 300000){
            throw new RuntimeException("The distance need to be lower than 300000");
        }
        Transaction transaction = new Transaction(id, carId, clientCard, pieceSum, operationSum, date, hour);
        transactionRepo.add(transaction);
    }


    public void remove(int id){
        transactionRepo.remove(id);
    }

    public void update(int id, int carId, int clientCard, double pieceSum, double operationSum, String date, String hour) {

        Transaction transaction = new Transaction(id, carId, clientCard, pieceSum, operationSum, date, hour);
        transactionRepo.add(transaction);

    }

    public List<Transaction> showAllTransactions(){
        return  transactionRepo.getAll();
    }
}
