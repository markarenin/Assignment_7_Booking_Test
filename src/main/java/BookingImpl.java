import java.util.HashMap;
import java.util.Map;

public class BookingImpl  implements Booking {

    private final Map<String, Double> roomRates;

    public BookingImpl() {
        roomRates = new HashMap<>();
        roomRates.put("standard", 100.0);
        roomRates.put("deluxe", 200.0);
        roomRates.put("suite", 300.0);
    }


    @Override
    public String book(String roomType, int duration) {
        if (!roomRates.containsKey(roomType)) {
            return "Room type not available";
        }

        if (duration <= 0) {
            return "Invalid duration";
        }

        double cost = calculateCost(roomType, duration);
        return "Booking confirmed: " + roomType + " for " + duration + " nights. Total cost: $" + cost;

    }

    @Override
    public double calculateCost(String roomType, int duration) {
        if (!roomRates.containsKey(roomType)) {
            throw new IllegalArgumentException("Invalid room type");
        }

        double rate = roomRates.get(roomType);
        return rate * duration;
    }
}
