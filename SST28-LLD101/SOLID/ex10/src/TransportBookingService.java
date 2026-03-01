public class TransportBookingService {
    private final DistanceCalculating distance;
    private final DriverAllocating allocator;
    private final FareCalculating fareCalc;
    private final PaymentCharging payment;

    public TransportBookingService(DistanceCalculating distance, DriverAllocating allocator,
                                   FareCalculating fareCalc, PaymentCharging payment) {
        this.distance = distance;
        this.allocator = allocator;
        this.fareCalc = fareCalc;
        this.payment = payment;
    }

    public void book(TripRequest req) {
        double km = distance.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = allocator.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = fareCalc.calculate(km);

        String txn = payment.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
