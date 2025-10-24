package VRS;

public class Bike extends Vehicle {
    private int engineCC;

    public Bike(String vehicleId, String brand, String model, double ratePerDay, int engineCC) {
        super(vehicleId, brand, model, ratePerDay);
        this.engineCC = engineCC;
    }

    public int getEngineCC() { return engineCC; }

    @Override
    public String getType() { return "Bike"; }
}
