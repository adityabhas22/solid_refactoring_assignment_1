import java.util.*;

public class RoomPricing {
    private final Map<Integer, Money> prices = new HashMap<>();

    public void register(int roomType, Money price) {
        prices.put(roomType, price);
    }

    public Money basePrice(int roomType) {
        return prices.getOrDefault(roomType, new Money(16000.0));
    }
}
