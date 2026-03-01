public interface Budgeting {
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);
    int balanceInt(); //Helps go through interface.
}
