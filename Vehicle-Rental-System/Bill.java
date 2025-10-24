package VRS;

public class Bill {
    private RentalTransaction rentalTransaction;
    private ReturnTransaction returnTransaction;

    public Bill(RentalTransaction rentalTransaction, ReturnTransaction returnTransaction) {
        this.rentalTransaction = rentalTransaction;
        this.returnTransaction = returnTransaction;
    }

    public void printBill() {
        System.out.println("\n========= RENTAL BILL =========");
        System.out.println(rentalTransaction);
        System.out.println(returnTransaction);
        System.out.println("===============================");
    }
}

