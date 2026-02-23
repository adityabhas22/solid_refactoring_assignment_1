import java.util.*;

public class RoomPricing {
    private final Map<Integer, Double> prices = new HashMap<>();

    public void register(int roomType, double price) {
        prices.put(roomType, price);
    }

    public double basePrice(int roomType) {
        return prices.getOrDefault(roomType, 16000.0);
    }
}
