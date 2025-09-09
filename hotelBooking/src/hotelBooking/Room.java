package hotelBooking;

public class Room {
    protected int roomNo;
    protected String type;
    protected double basePrice;
    protected boolean status;
    public static int totalRooms = 0;

    public Room(int roomNo, String type, double basePrice) {
        this.roomNo = roomNo;
        this.type = type;
        this.basePrice = basePrice;
        this.status = false;
        totalRooms++;
    }

    public boolean checkAvailability() {
        return !status;
    }

    public void book() {
        if (!status) {
            status = true;
            System.out.println("Room " + roomNo + " booked successfully!");
        } else {
            System.out.println("Room " + roomNo + " is already booked.");
        }
    }

    public void cancel() {
        if (status) {
            status = false;
            System.out.println("Booking for Room " + roomNo + " cancelled.");
        } else {
            System.out.println("Room " + roomNo + " is not booked.");
        }
    }

    public double computeBill() {
        return basePrice;
    }

    public int getRoomNo() { return roomNo; }
    public String getType() { return type; }
    public boolean getStatus() { return status; }

    @Override
    public String toString() {
        return "Room No:" + roomNo + " | Type:" + type + " | Price:" + basePrice + " | Status:" + (status?"Booked":"Available");
    }
}
