package VRS;

public class Car extends Vehicle {
    private int seatCount;

    public Car(String vehicleId, String brand, String model, double ratePerDay, int seatCount) {
        super(vehicleId, brand, model, ratePerDay);
        this.seatCount = seatCount;
    }

    public int getSeatCount() { return seatCount; }

    @Override
    public String getType() { return "Car"; }
}
