package main.java.com.goyalsw.Factory;

import main.java.com.goyalsw.modals.expense.*;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType expenseType, String userId, double amount, List<ExpenseNode> expenseNodeList) {
        switch(expenseType) {
            case EQUAL:
                int size = expenseNodeList.size();
                double amountForEachUser = ((double)Math.round(amount*100/size)/100.0);
                for(ExpenseNode node : expenseNodeList) {
                    node.setAmount(amountForEachUser);
                }
                return new EqualExpense(userId, amount, expenseNodeList);
            case EXACT:
                return new ExactExpense(userId, amount, expenseNodeList);
            case PERCENT:
                for(ExpenseNode node : expenseNodeList) {
                    node.setAmount((amount*node.getPercent())/100.0);
                }
                return new PercentExpense(userId, amount, expenseNodeList);
            default:
                return null;
        }
    }
}
