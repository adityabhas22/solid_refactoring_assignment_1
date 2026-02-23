import java.util.*;

public class EligibilityEngine {
    private final List<EligibilityRule> rules;
    private final EligibilityStore store;

    public EligibilityEngine(List<EligibilityRule> rules, EligibilityStore store) {
        this.rules = rules;
        this.store = store;
    }

    public void runAndPrint(StudentProfile s) {
        EligibilityEngineResult r = evaluate(s);
        new ReportPrinter().print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        for (EligibilityRule rule : rules) {
            String reason = rule.check(s);
            if (reason != null) {
                return new EligibilityEngineResult("NOT_ELIGIBLE", List.of(reason));
            }
        }
        return new EligibilityEngineResult("ELIGIBLE", List.of());
    }
}
