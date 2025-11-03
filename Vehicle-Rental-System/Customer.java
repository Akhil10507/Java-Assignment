package VRS;

public class Customer {
    private String customerId;
    private String name;
    private String customerType; // New variable

    public Customer(String customerId, String name, String customerType) {
        this.customerId = customerId;
        this.name = name;
        this.customerType = customerType;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getCustomerType() { return customerType; }

    public double getDiscount() { return 0.0; }

    @Override
    public String toString() {
        return "Customer: " + name + " (ID: " + customerId + ", Type: " + customerType + ")";
    }
}
