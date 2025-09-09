package hotelBooking;

public class DeluxeRoom extends Room {
    private boolean breakfast;
    private double serviceCharge;

    public DeluxeRoom(int roomNo, double basePrice, boolean breakfast) {
        super(roomNo, "Deluxe", basePrice);
        this.breakfast = breakfast;
        this.serviceCharge = 500;
    }

    public void book(boolean withBreakfast) {
        this.breakfast = withBreakfast;
        super.book();
    }

    @Override
    public double computeBill() {
        double total = basePrice + serviceCharge;
        if (breakfast) {
            total += 200;
        }
        return total;
    }
}
