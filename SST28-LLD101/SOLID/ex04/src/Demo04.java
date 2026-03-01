import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        RoomPricing roomPricing = new RoomPricing();
        roomPricing.register(LegacyRoomTypes.SINGLE, new Money(14000.0));
        roomPricing.register(LegacyRoomTypes.DOUBLE, new Money(15000.0));
        roomPricing.register(LegacyRoomTypes.TRIPLE, new Money(12000.0));
        roomPricing.register(LegacyRoomTypes.DELUXE, new Money(16000.0));

        AddOnPricing addOnPricing = new AddOnPricing();
        addOnPricing.register(AddOn.MESS, new Money(1000.0));
        addOnPricing.register(AddOn.LAUNDRY, new Money(500.0));
        addOnPricing.register(AddOn.GYM, new Money(300.0));

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(roomPricing, addOnPricing);

        Money monthly = calc.calculateMonthly(req);
        Money deposit = new Money(5000.0);

        ReceiptPrinter.print(req, monthly, deposit);

        FakeBookingRepo repo = new FakeBookingRepo();
        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}
