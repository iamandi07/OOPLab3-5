package Domain;

public class TransactionValidator {

    public void validate(Transaction transaction){

        if (transaction.getPieceSum() < 0) {
            throw new RuntimeException("The acquisition date need to be positive");
        }

        if (transaction.getOperationSum() < 0) {
            throw new RuntimeException("The acquisition date need to be positive");
        }

    }
}
