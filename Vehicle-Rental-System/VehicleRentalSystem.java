package VRS;

import java.util.*;

public class VehicleRentalSystem {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<RentalTransaction> rentals = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== VEHICLE RENTAL SYSTEM ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. Display Vehicles");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> addCustomer();
                case 3 -> rentVehicle();
                case 4 -> returnVehicle();
                case 5 -> displayVehicles();
                case 6 -> System.out.println("Exiting System...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addVehicle() {
        System.out.print("Enter Vehicle Type (1-Car, 2-Bike): ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Vehicle ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Rate per Day: ");
        double rate = sc.nextDouble();

        if (type == 1) {
            System.out.print("Enter Seat Count: ");
            int seats = sc.nextInt();
            vehicles.add(new Car(id, brand, model, rate, seats));
        } else {
            System.out.print("Enter Engine CC: ");
            int cc = sc.nextInt();
            vehicles.add(new Bike(id, brand, model, rate, cc));
        }

        System.out.println("Vehicle added successfully!");
    }

    private static void addCustomer() {
        sc.nextLine();
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Premium Customer? (y/n): ");
        char type = sc.next().charAt(0);

        if (type == 'y' || type == 'Y') {
            customers.add(new PremiumCustomer(id, name));
        } else {
            customers.add(new Customer(id, name, "Normal"));
        }

        System.out.println("Customer added successfully!");
    }

    private static void rentVehicle() {
        sc.nextLine();
        System.out.print("Enter Customer ID: ");
        String cid = sc.nextLine();
        Customer cust = findCustomer(cid);
        if (cust == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter Vehicle ID: ");
        String vid = sc.nextLine();
        Vehicle veh = findVehicle(vid);
        if (veh == null || !veh.isAvailable()) {
            System.out.println("Vehicle not available!");
            return;
        }

        System.out.print("Enter Rental Days: ");
        int days = sc.nextInt();

        RentalTransaction rental = new RentalTransaction("R" + (rentals.size() + 1), cust, veh, days);
        rentals.add(rental);
        System.out.println("Rental Successful!");
        System.out.println(rental);
    }

    private static void returnVehicle() {
        sc.nextLine();
        System.out.print("Enter Vehicle ID: ");
        String vid = sc.nextLine();
        RentalTransaction rental = findRentalByVehicle(vid);

        if (rental == null) {
            System.out.println("No rental found for this vehicle!");
            return;
        }

        System.out.print("Enter Days Late: ");
        int late = sc.nextInt();

        ReturnTransaction rt = new ReturnTransaction(rental, late);
        Bill bill = new Bill(rental, rt);
        bill.printBill();
    }

    private static void displayVehicles() {
        if (vehicles.isEmpty()) System.out.println("No vehicles available!");
        else vehicles.forEach(System.out::println);
    }

    private static Vehicle findVehicle(String id) {
        for (Vehicle v : vehicles)
            if (v.getVehicleId().equalsIgnoreCase(id)) return v;
        return null;
    }

    private static Customer findCustomer(String id) {
        for (Customer c : customers)
            if (c.getCustomerId().equalsIgnoreCase(id)) return c;
        return null;
    }

    private static RentalTransaction findRentalByVehicle(String id) {
        for (RentalTransaction r : rentals)
            if (r.getVehicle().getVehicleId().equalsIgnoreCase(id)) return r;
        return null;
    }
}

