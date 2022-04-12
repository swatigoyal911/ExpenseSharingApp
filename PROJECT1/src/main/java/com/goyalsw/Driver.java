package main.java.com.goyalsw;

import main.java.com.goyalsw.modals.User;
import main.java.com.goyalsw.service.ExpenseService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();

        expenseService.addUser(new User("1", "abc", "abcAgmail.com", "87987347"));
        expenseService.addUser(new User("2", "xyz", "abcAgmail.com", "87987347"));
        expenseService.addUser(new User("3", "kh", "abcAgmail.com", "87987347"));

        Scanner scanner = new Scanner((System.in));

    }
}
