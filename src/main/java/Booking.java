public interface Booking {
    String book(String roomType, int duration);
    double calculateCost(String roomType, int duration);
}