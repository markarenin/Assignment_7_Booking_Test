public class FakeBooking implements Booking {
    @Override
    public String book(String roomType, int duration) {
        return "Booked";
    }

    @Override
    public double calculateCost(String roomType, int duration) {
        return 0;
    }
}