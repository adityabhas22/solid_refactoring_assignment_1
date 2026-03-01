import java.util.*;

public class AddOnPricing {
    private final Map<AddOn, Money> prices = new HashMap<>();

    public void register(AddOn addOn, Money price) {
        prices.put(addOn, price);
    }

    public Money totalFor(List<AddOn> addOns) {
        Money sum = new Money(0.0);
        for (AddOn a : addOns) sum = sum.plus(prices.getOrDefault(a, new Money(0.0)));
        return sum;
    }
}
