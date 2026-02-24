public abstract class Exporter {
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("request must not be null");
        }
        try {
            return doExport(req);
        } catch (Exception e) {
            return new ExportResult(e.getMessage());
        }
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
