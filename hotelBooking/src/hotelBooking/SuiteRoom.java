package hotelBooking;

public class SuiteRoom extends Room {
    private boolean extraBed;
    private double luxuryTax;

    public SuiteRoom(int roomNo, double basePrice, boolean extraBed) {
        super(roomNo, "Suite", basePrice);
        this.extraBed = extraBed;
        this.luxuryTax = 0.15;
    }

    @Override
    public double computeBill() {
        double total = basePrice;
        if (extraBed) total += 1000;
        total += (total * luxuryTax);
        return total;
    }
}
