package VRS;

public class PremiumCustomer extends Customer {

    public PremiumCustomer(String customerId, String name) {
        super(customerId, name, "Premium"); // Added customerType
    }

    @Override
    public double getDiscount() { return 0.1; } // 10% discount
}
