public class SecretaryTool implements MinutesKeeping {
    private final MinutesBook book;
    public SecretaryTool(MinutesBook book) { this.book = book; }

    @Override public void addMinutes(String text) { book.add(text); }
    @Override public int count() { return book.count(); }
}
