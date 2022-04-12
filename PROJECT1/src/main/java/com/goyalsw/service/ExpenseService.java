package main.java.com.goyalsw.service;

import main.java.com.goyalsw.Factory.ExpenseFactory;
import main.java.com.goyalsw.modals.User;
import main.java.com.goyalsw.modals.expense.Expense;
import main.java.com.goyalsw.modals.expense.ExpenseNode;
import main.java.com.goyalsw.modals.expense.ExpenseType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {
    List<Expense> expenseList;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseService(Map<String, User> userMap, Map<String, Map<String, Double>> balanceSheet) {
        this.userMap = userMap;
        this.balanceSheet = balanceSheet;
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addExpense(ExpenseType expenseType, String userId, double amount, List<ExpenseNode> expenseNodeList) {
        Expense expense = ExpenseFactory.createExpense(expenseType, userId, amount, expenseNodeList);
        expenseList.add(expense);

        for(ExpenseNode node : expenseNodeList) {
            String owedBy = node.getUserId();
            Map<String, Double> balance = balanceSheet.get(userId);

            if(!balance.containsKey(owedBy))
                balance.put(owedBy, 0.0);
            balance.put(owedBy, balance.get(owedBy)+node.getAmount());

            Map<String, Double> balanceOfOwedBy = balanceSheet.get(owedBy);
            if(!balanceOfOwedBy.containsKey(userId))
                balanceOfOwedBy.put(owedBy, 0.0);
            balanceOfOwedBy.put(userId, balanceOfOwedBy.get(userId)-node.getAmount());
        }
    }

    public void showBalanceSheet(String userId){
        boolean isAvailable = false;
        Map<String, Double> balances = balanceSheet.get(userId);

        for(Map.Entry<String, Double> balance : balances.entrySet()) {
            if(balance.getValue()!=0) {
                isAvailable = true;

                String user1 = userMap.get(userId).getName();
                String user2 = userMap.get(balance.getKey()).getName();
                if (balance.getValue() > 0) {
                    System.out.println(user1 + " owes " + user2 + " " + balance.getValue());
                } else {
                    System.out.println(user2 + " owes " + user1 + " " + balance.getValue());
                }
            }

            if(!isAvailable)
                System.out.println("No Balance Avaialable");
        }
    }

    public void showBalanceSheet() {
        for(Map.Entry<String, Map<String, Double>> balances : balanceSheet.entrySet()) {
            String user1 = userMap.get(balances.getKey()).getName();
            for(Map.Entry<String, Double> balance : balances.getValue().entrySet()) {
                String user2 = userMap.get(balance.getKey()).getName();
                if(balance.getValue() > 0)
                    if (balance.getValue() > 0) {
                        System.out.println(balances.getKey() + " owes " + user2 + " " + balance.getValue());
                    } else {
                        System.out.println(user2 + " owes " + balances.getKey() + " " + balance.getValue());
                    }
            }
        }
    }
}
