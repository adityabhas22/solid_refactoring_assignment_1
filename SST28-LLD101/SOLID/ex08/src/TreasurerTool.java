public class TreasurerTool implements Budgeting {
    private final BudgetLedger ledger; //Holds the balance of the club's budget
    public TreasurerTool(BudgetLedger ledger) { this.ledger = ledger; }

    @Override public void addIncome(double amt, String note) { ledger.add(amt, note); }
    @Override public void addExpense(double amt, String note) { ledger.add(-amt, note); }
    @Override public int balanceInt() { return ledger.balanceInt(); } //Helps go through interface.
}
