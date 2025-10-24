package VRS;

public class RentalTransaction {
    private String rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;

    public RentalTransaction(String rentalId, Customer customer, Vehicle vehicle, int rentalDays) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        vehicle.setAvailable(false);
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getRentalDays() { return rentalDays; }

    public double calculateCost() {
        double cost = vehicle.getRatePerDay() * rentalDays;
        cost -= cost * customer.getDiscount();
        return cost;
    }

    @Override
    public String toString() {
        return "Rental ID: " + rentalId + ", " + customer + ", " + vehicle +
               ", Duration: " + rentalDays + " days, Total Cost: ₹" + calculateCost();
    }
}
