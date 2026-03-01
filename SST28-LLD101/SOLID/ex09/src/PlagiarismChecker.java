public class PlagiarismChecker implements Checking {
    @Override public int check(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}
