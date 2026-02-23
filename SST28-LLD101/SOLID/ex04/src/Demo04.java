import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        RoomPricing roomPricing = new RoomPricing();
        roomPricing.register(LegacyRoomTypes.SINGLE, 14000.0);
        roomPricing.register(LegacyRoomTypes.DOUBLE, 15000.0);
        roomPricing.register(LegacyRoomTypes.TRIPLE, 12000.0);
        roomPricing.register(LegacyRoomTypes.DELUXE, 16000.0);

        AddOnPricing addOnPricing = new AddOnPricing();
        addOnPricing.register(AddOn.MESS, 1000.0);
        addOnPricing.register(AddOn.LAUNDRY, 500.0);
        addOnPricing.register(AddOn.GYM, 300.0);

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), roomPricing, addOnPricing);
        calc.process(req);
    }
}
