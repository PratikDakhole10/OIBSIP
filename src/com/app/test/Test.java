package com.app.test;

import java.util.Scanner;

import com.app.model.User;
import com.app.service.ATMService;
import com.app.service.AuthService;
import com.app.util.InputValidator;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATMService atmService = new ATMService();

        System.out.println("Welcome to the ATM System");
        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Add New User");
            System.out.println("3. Quit");

            int option = InputValidator.getValidOption(1, 3);
            switch (option) {
                case 1:
                    login(scanner, atmService);
                    break;
                case 2:
                    addNewUser(scanner, atmService);
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner, ATMService atmService) {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        User user = AuthService.authenticate(userId, pin);
        if (user != null) {
            System.out.println("Login successful!");
            openUserMenu(scanner, atmService, user);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void addNewUser(Scanner scanner, ATMService atmService) {
        System.out.print("Enter new User ID: ");
        String newUserId = scanner.nextLine();
        System.out.print("Enter new PIN: ");
        String newPin = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = InputValidator.getValidAmount();
        atmService.addUser(newUserId, newPin, initialBalance);
        System.out.println("New user added successfully!");
    }

    private static void openUserMenu(Scanner scanner, ATMService atmService, User user) {
        while (true) {
            System.out.println("\n--- ATM Functionalities ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Transaction History");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Logout");

            System.out.print("Choose a function: ");
            int choice = InputValidator.getValidOption(1, 6);

            switch (choice) {
                case 1:
                    atmService.checkBalance(user);
                    break; // Return to menu after showing balance
                case 2:
                    atmService.viewTransactionHistory(user.getUserId());
                    break; // Return to menu after showing transaction history
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = InputValidator.getValidAmount();
                    atmService.withdraw(user, withdrawAmount);
                    break; // Return to menu after withdrawal
                case 4:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = InputValidator.getValidAmount();
                    atmService.deposit(user, depositAmount);
                    break; // Return to menu after deposit
                case 5:
                    System.out.print("Enter target User ID: ");
                    String targetUserId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = InputValidator.getValidAmount();
                    atmService.transfer(user, targetUserId, transferAmount);
                    break; // Return to menu after transfer
                case 6:
                    System.out.println("Logged out successfully!");
                    return; // Exit submenu and return to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Display message after operation completion
            System.out.println("\nReturning to the functionality menu...");
        }
    }
}
