package com.app.util;

import java.util.Scanner;

public class InputValidator {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static int getValidOption(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Invalid option. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
	
	public static double getValidAmount() {
        while (true) {
            try {
                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    return amount;
                }
                System.out.println("Amount must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }
    }
}
