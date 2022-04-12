package main.java.com.goyalsw.modals.expense;
//We can create it as abstarct class
public class ExpenseNode {
    private String userId;
    private double amount;
    private double percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ExpenseNode(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
