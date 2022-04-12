package main.java.com.goyalsw.modals.expense;

import java.util.List;

public abstract class Expense {
    private String userPaid;
    private double amount;
    private List<ExpenseNode> expenseNodes;

    public Expense(String userPaid, double amount, List<ExpenseNode> expenseNodes) {
        this.userPaid = userPaid;
        this.amount = amount;
        this.expenseNodes = expenseNodes;
    }

    public String getUserPaid() {
        return userPaid;
    }

    public void setUserPaid(String userPaid) {
        this.userPaid = userPaid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ExpenseNode> getExpenseNodes() {
        return expenseNodes;
    }

    public void setExpenseNodes(List<ExpenseNode> expenseNodes) {
        this.expenseNodes = expenseNodes;
    }

    public abstract boolean isValid();
}
