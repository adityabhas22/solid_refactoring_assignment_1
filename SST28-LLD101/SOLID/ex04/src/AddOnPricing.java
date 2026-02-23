import java.util.*;

public class AddOnPricing {
    private final Map<AddOn, Double> prices = new HashMap<>();

    public void register(AddOn addOn, double price) {
        prices.put(addOn, price);
    }

    public double totalFor(List<AddOn> addOns) {
        double sum = 0.0;
        for (AddOn a : addOns) sum += prices.getOrDefault(a, 0.0);
        return sum;
    }
}
