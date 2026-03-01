public class HostelFeeCalculator {
    private final RoomPricing roomPricing;
    private final AddOnPricing addOnPricing;

    public HostelFeeCalculator(RoomPricing roomPricing, AddOnPricing addOnPricing) {
        this.roomPricing = roomPricing;
        this.addOnPricing = addOnPricing;
    }

    public Money calculateMonthly(BookingRequest req) {
        Money base = roomPricing.basePrice(req.roomType);
        Money addOns = addOnPricing.totalFor(req.addOns);
        return base.plus(addOns);
    }
}
