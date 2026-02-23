public class SendResult {
    public final boolean success;
    public final String error;

    public SendResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
