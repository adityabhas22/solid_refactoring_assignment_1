public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    public SendResult send(Notification n) {
        if (n == null) {
            return new SendResult(false, "notification must not be null");
        }
        try {
            return doSend(n);
        } catch (Exception e) {
            return new SendResult(false, e.getMessage());
        }
    }

    protected abstract SendResult doSend(Notification n);
}
