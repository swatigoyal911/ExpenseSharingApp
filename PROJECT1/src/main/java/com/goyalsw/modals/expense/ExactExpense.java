package main.java.com.goyalsw.modals.expense;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(String userPaid, double amount, List<ExpenseNode> expenseNodes) {
        super(userPaid, amount, expenseNodes);
    }

    @Override
    public boolean isValid() {
        double totalAmount = getAmount();
        double amountOwed = 0;

        for(ExpenseNode node : getExpenseNodes()) {
            amountOwed += node.getAmount();
        }

        return totalAmount == amountOwed;
    }
}
