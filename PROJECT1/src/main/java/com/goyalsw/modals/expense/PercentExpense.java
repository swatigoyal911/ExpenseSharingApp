package main.java.com.goyalsw.modals.expense;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(String userPaid, double amount, List<ExpenseNode> expenseNodes) {
        super(userPaid, amount, expenseNodes);
    }

    @Override
    public boolean isValid() {
        double totalPercent = 0;
        double percentOwed = 0;

        for(ExpenseNode node : getExpenseNodes()) {
            percentOwed += node.getPercent();
        }

        return totalPercent == percentOwed;
    }
}
