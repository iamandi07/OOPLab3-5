package Domain;

import java.util.Objects;

public class Transaction {

    private int id, carId, clientCard;
    private Double pieceSum, operationSum;
    private String date, hour;

    public Transaction(int id, int carId, int clientCard, double pieceSum, double operationSum, String date, String hour) {
        this.id = id;
        this.carId = carId;
        this.clientCard = clientCard;
        this.pieceSum = pieceSum;
        this.operationSum = operationSum;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientCard() {
        return clientCard;
    }

    public void setClientCard(int clientCard) {
        this.clientCard = clientCard;
    }

    public Double getPieceSum() {
        return pieceSum;
    }

    public void setPieceSum(Double pieceSum) {
        this.pieceSum = pieceSum;
    }

    public Double getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(Double operationSum) {
        this.operationSum = operationSum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", carId=" + carId +
                ", clientCard=" + clientCard +
                ", pieceSum=" + pieceSum +
                ", operationSum=" + operationSum +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                carId == that.carId &&
                clientCard == that.clientCard &&
                pieceSum == that.pieceSum &&
                operationSum == that.operationSum &&
                Objects.equals(date, that.date) &&
                Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, clientCard, pieceSum, operationSum, date, hour);
    }
}
