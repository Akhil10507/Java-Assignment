package VRS;

public class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }

    public double getDiscount() { return 0.0; }

    @Override
    public String toString() {
        return "Customer: " + name + " (ID: " + customerId + ")";
    }
}
