package main.java.com.goyalsw.modals.expense;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(String userPaid, double amount, List<ExpenseNode> expenseNodes) {
        super(userPaid, amount, expenseNodes);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
