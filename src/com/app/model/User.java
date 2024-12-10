package com.app.model;

public class User {
	private String userId;
	private String pin;
	private double balance;
	public User() {
		super();
	}
	public User(String userId, String pin, double balance) {
		super();
		this.userId = userId;
		this.pin = pin;
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pin=" + pin + ", balance=" + balance + "]";
	}
	
	
}
