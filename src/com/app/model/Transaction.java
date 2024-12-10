package com.app.model;

import java.time.LocalDateTime;

public class Transaction {
	private String type;
	private double amount;
	private LocalDateTime dateTime;
	public Transaction() {
		super();
	}
	public Transaction(String type, double amount, LocalDateTime dateTime) {
		super();
		this.type = type;
		this.amount = amount;
		this.dateTime = dateTime;
	}
	public Transaction(String string, double amount2) {
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Transaction [type=" + type + ", amount=" + amount + ", dateTime=" + dateTime + "]";
	}
	
	
}
