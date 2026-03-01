public class ClubConsole {
    private final Budgeting treasurer; 
    private final MinutesKeeping secretary;
    private final EventOrganizing lead;

    public ClubConsole(Budgeting treasurer, MinutesKeeping secretary, EventOrganizing lead) {
        this.treasurer = treasurer;
        this.secretary = secretary;
        this.lead = lead;
    }

    public void run() {
        treasurer.addIncome(5000, "sponsor");
        secretary.addMinutes("Meeting at 5pm");
        lead.createEvent("HackNight", 2000);

        System.out.println("Summary: ledgerBalance=" + treasurer.balanceInt()
                + ", minutes=" + secretary.count()
                + ", events=" + lead.getEventsCount());
    }
}
