public class SendResult {
    public final boolean success;
    public final String error;

    public SendResult(boolean success, String error) {
        if (success && error != null) {
            throw new IllegalArgumentException("success result cannot have an error");
        }
        if (!success && error == null) {
            throw new IllegalArgumentException("failed result must have an error message");
        }
        this.success = success;
        this.error = error;
    }
}
