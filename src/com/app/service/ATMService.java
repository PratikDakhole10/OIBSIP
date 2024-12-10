package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.model.User;

public class ATMService {
	private final Map<String, User> userDatabase = new HashMap<>();
    private final Map<String, List<String>> transactionHistory = new HashMap<>();

    public ATMService() {
        // Initialize with a default user
        addUser("user1", "1234", 5000.0);
    }

    public void addUser(String userId, String pin, double initialBalance) {
        if (userDatabase.containsKey(userId)) {
            System.out.println("User ID already exists. Try a different ID.");
            return;
        }
        User newUser = new User(userId, pin, initialBalance);
        userDatabase.put(userId, newUser);
        transactionHistory.put(userId, new ArrayList<>());
        System.out.println("User added successfully!");
    }

    public void checkBalance(User user) {
        System.out.printf("Your current balance is: $%.2f%n", user.getBalance());
    }

    public void withdraw(User user, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive value.");
        } else {
            user.setBalance(user.getBalance() - amount);
            recordTransaction(user.getUserId(), String.format("Withdrawn: $%.2f", amount));
            System.out.println("Withdrawal successful! Your new balance is: $" + user.getBalance());
        }
    }

    public void deposit(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive value.");
        } else {
            user.setBalance(user.getBalance() + amount);
            recordTransaction(user.getUserId(), String.format("Deposited: $%.2f", amount));
            System.out.println("Deposit successful! Your new balance is: $" + user.getBalance());
        }
    }

    public void transfer(User sender, String recipientId, double amount) {
        if (!userDatabase.containsKey(recipientId)) {
            System.out.println("Recipient User ID not found. Transfer failed.");
        } else if (amount > sender.getBalance()) {
            System.out.println("Insufficient balance. Transfer failed.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive value.");
        } else {
            User recipient = userDatabase.get(recipientId);
            sender.setBalance(sender.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);

            recordTransaction(sender.getUserId(), String.format("Transferred $%.2f to %s", amount, recipientId));
            recordTransaction(recipientId, String.format("Received $%.2f from %s", amount, sender.getUserId()));

            System.out.println("Transfer successful! Your new balance is: $" + sender.getBalance());
        }
    }

    public void viewTransactionHistory(String userId) {
        List<String> history = transactionHistory.get(userId);
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : history) {
                System.out.println(transaction);
            }
        }
    }

    private void recordTransaction(String userId, String transaction) {
        transactionHistory.get(userId).add(transaction);
    }
}
