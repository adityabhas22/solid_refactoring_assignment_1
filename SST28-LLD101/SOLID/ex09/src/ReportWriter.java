public class ReportWriter implements ReportWriting {
    @Override public String write(Submission s, int plag, int code) {
        return "report-" + s.roll + ".txt";
    }
}
