package Domain;

public class Car {

    private int id, acquisitionDate, distance;
    private String model;
    private boolean warranty;

    public Car(int id, int acquisitionDate, int distance, String model, boolean warranty) {
        this.id = id;
        this.acquisitionDate = acquisitionDate;
        this.distance = distance;
        this.model = model;
        this.warranty = warranty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(int acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", acquisitionDate=" + acquisitionDate +
                ", distance=" + distance +
                ", model='" + model + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}
