package UI;

import Domain.Car;
import Domain.Transaction;
import Service.CarService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {

    private CarService carService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(CarService carService, TransactionService transactionService){
        this.carService = carService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Car CRUD");
        System.out.println("2. Transaction CRUD");
        System.out.println("x. EXIT");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runCarCrud();
                    break;
                case "2":
                    runTransactionCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runTransactionCrud() {
        while (true) {
            System.out.println("1. Add a transaction");
            System.out.println("2. Update a transaction");
            System.out.println("3. Remove a transaction");
            System.out.println("4. View all transactions");
            System.out.println("x. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddTransaction();
                    break;
                case "2":
                    handleUpdatetransaction();
                    break;
                case "3":
                    handleRemoveTransaction();
                    break;
                case "4":
                    handleViewTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleUpdatetransaction() {
        try {
            System.out.println("Enter id to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter car id: ");
            int carId = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the distance: ");
            int clientCard = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the piecesum: ");
            Double pieceSum = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the operationsum: ");
            Double operationSum = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the date: ");
            String date = scanner.nextLine();
            System.out.println("Enter the hour: ");
            String hour = scanner.nextLine();


            transactionService.update(id, carId, clientCard, pieceSum,operationSum,date, hour);
            System.out.println("Transaction updated!");
        } catch (RuntimeException ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewTransactions() {
        for (Transaction transaction : transactionService.showAllTransactions()) {
            System.out.println(transaction);
        }
    }

    private void handleRemoveTransaction() {
        try {
            System.out.println("Enter the id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            transactionService.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddTransaction() {
        
        try {
            System.out.println("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter CarId: ");
            int carId = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter client card: ");
            int clientCard = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the piecesum: ");
            double pieceSum = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the operation sum: ");
            double operationSum = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter date: ");
            String date = scanner.nextLine();
            System.out.println("Enter the hour: ");
            String hour = scanner.next();

            transactionService.add(id, carId, clientCard, pieceSum, operationSum, date, hour);
            System.out.println(String.format("Transaction added succesfully!"));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void showMenu1(){
        System.out.println("1. Add car info");
        System.out.println("2. Update car info");
        System.out.println("3. Remove car info");
        System.out.println("4. View all cars");
        System.out.println("x. Back");
    }

    private void runCarCrud() {

            while (true) {
            showMenu1();
            String option = scanner.nextLine();
            switch (option){

                case "1":
                    handleAddCar();
                    break;
                case "2":
                    handleUpdateCar();
                    break;
                case "3":
                    handleRemoveCar();
                    break;
                case "4":
                    handleViewCar();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void handleViewCar() {
        for (Car car : carService.showCars()) {
            System.out.println(car);
        }
    }

    private void handleRemoveCar() {
        try {
            System.out.println("Enter the id to remove:");
            int id = Integer.parseInt(scanner.nextLine());
            carService.remove(id);

            System.out.println("Car info removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddCar() {
        try{
            System.out.println("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter acquisition date: ");
            int acquisitionDate = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the distance: ");
            int distance = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the model: ");
            String model = scanner.nextLine();
            System.out.println("Enter the warranty (true/false): ");
            boolean warranty = Boolean.parseBoolean(scanner.nextLine());


            carService.add(id, acquisitionDate, distance, model, warranty);
            System.out.println("Car added!");
        } catch (RuntimeException ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void handleUpdateCar() {
        try {
            System.out.println("Enter id to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter acquisition date: ");
            int acquisitionDate = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the distance: ");
            int distance = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the model: ");
            String model = scanner.nextLine();
            System.out.println("Enter the warranty (true/false): ");
            boolean warranty = Boolean.parseBoolean(scanner.nextLine());


            carService.update(id, acquisitionDate, distance, model, warranty);
            System.out.println("Car updated!");
        } catch (RuntimeException ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}
