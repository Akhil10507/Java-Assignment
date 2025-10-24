package VRS;

public class ReturnTransaction {
    private RentalTransaction rentalTransaction;
    private int daysLate;

    public ReturnTransaction(RentalTransaction rentalTransaction, int daysLate) {
        this.rentalTransaction = rentalTransaction;
        this.daysLate = daysLate;
        rentalTransaction.getVehicle().setAvailable(true);
    }

    public double calculatePenalty() {
        return daysLate > 0 ? daysLate * 200 : 0; // ₹200 per late day
    }

    public double getTotalBill() {
        return rentalTransaction.calculateCost() + calculatePenalty();
    }

    @Override
    public String toString() {
        return "Return of " + rentalTransaction.getVehicle().getType() +
               " | Late by " + daysLate + " days | Penalty: ₹" + calculatePenalty() +
               " | Final Bill: ₹" + getTotalBill();
    }
}
