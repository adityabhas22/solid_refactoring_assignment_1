public class Demo09 {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");

        Rubric rubric = new Rubric();
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        EvaluationPipeline pipeline = new EvaluationPipeline(
                new PlagiarismChecker(),
                new CodeGrader(rubric),
                new ReportWriter()
        );
        pipeline.evaluate(sub);
    }
}
