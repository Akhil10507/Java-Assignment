package hotelBooking;

import java.util.*;

public class BookingService {
    private List<Room> rooms = new ArrayList<>();
    private double totalRevenue = 0;

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public void showRooms() {
        System.out.println("\n-- Room List --");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public void bookRoom(int roomNo) {
        for (Room r : rooms) {
            if (r.getRoomNo() == roomNo && r.checkAvailability()) {
                r.book();
                double bill = r.computeBill();
                totalRevenue += bill;
                System.out.println("Bill Amount: " + bill);
                return;
            }
        }
        System.out.println("Room not available!");
    }

    public void cancelBooking(int roomNo) {
        for (Room r : rooms) {
            if (r.getRoomNo() == roomNo) {
                r.cancel();
                return;
            }
        }
    }

    public void dailyReport() {
        System.out.println("\n--- Daily Report ---");
        int occupied = 0;
        for (Room r : rooms) {
            if (r.getStatus()) occupied++;
        }
        System.out.println("Total Rooms: " + Room.totalRooms);
        System.out.println("Occupied Rooms: " + occupied);
        System.out.println("Revenue Collected: " + totalRevenue);
    }
}
