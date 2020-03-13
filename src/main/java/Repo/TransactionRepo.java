package Repo;

import Domain.Car;
import Domain.Transaction;
import Domain.TransactionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepo {

    private Map<Integer, Transaction> transactions = new HashMap<>();
    private TransactionValidator validator;

    public TransactionRepo(TransactionValidator validator) {
        this.validator = validator;
    }

    public Transaction findbyId(int id) {
        return transactions.get(id);
    }

    public void add(Transaction transaction) {
        if (transactions.containsKey(transaction.getId())) {
            throw new RuntimeException("The reg number with that ID already exists!");
        }

        validator.validate(transaction);
        transactions.put(transaction.getId(), transaction);
    }

    public void remove(int id) {
        if (!transactions.containsKey(id)) {
            throw new RuntimeException("There is no transaction with the given id to remove.");
        }
        transactions.remove(id);
    }

    public void update(Transaction transaction) {
        if (!transactions.containsKey(transaction.getId())) {
            throw new RuntimeException("The entry ID does not exist!");
        }
        validator.validate(transaction);
        transactions.put(transaction.getId(), transaction);
    }

    public Transaction findById(int id) {
        return transactions.get(id);
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(transactions.values());
    }

    public Map<Integer, Transaction> getTransactions() {
        return transactions;

    }

    public Transaction read(int id) {

        return transactions.get(id);
    }



}
