package hotelBooking;

public class HotelAppMain {
    public static void main(String[] args) {
        BookingService service = new BookingService();

        Room r1 = new Room(101, "Standard", 2000);
        DeluxeRoom r2 = new DeluxeRoom(201, 3500, true);
        SuiteRoom r3 = new SuiteRoom(301, 5000, true);

        service.addRoom(r1);
        service.addRoom(r2);
        service.addRoom(r3);

        service.showRooms();

        service.bookRoom(201);
        service.bookRoom(301);

        service.showRooms();

        service.cancelBooking(201);
        service.showRooms();

        service.dailyReport();
    }
}
