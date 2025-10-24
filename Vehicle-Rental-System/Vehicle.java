package VRS;

public abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private boolean available;
    private double ratePerDay;

    public Vehicle(String vehicleId, String brand, String model, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.ratePerDay = ratePerDay;
        this.available = true;
    }

    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }
    public double getRatePerDay() { return ratePerDay; }

    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + brand + " " + model +
               " (ID: " + vehicleId + ", Rate: " + ratePerDay +
               "/day, Available: " + available + ")";
    }
}
