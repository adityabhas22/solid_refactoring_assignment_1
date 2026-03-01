public class PaymentGateway implements PaymentCharging {
    @Override public String charge(String studentId, double amount) {
        return "TXN-9001";
    }
}
