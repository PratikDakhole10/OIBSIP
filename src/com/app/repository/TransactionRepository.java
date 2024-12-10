package com.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.model.Transaction;

public class TransactionRepository {
	private static TransactionRepository instance;
	private final Map<String,List<Transaction>> transactions;
	
	private TransactionRepository() {
		transactions= new HashMap<>();
	}
	
	public static TransactionRepository getInstance() {
		if(instance==null) {
			instance = new TransactionRepository();
		}
		return instance;
	}
	
	public void addTransaction(String userId, Transaction transaction) {
		transactions.computeIfAbsent(userId, k-> new ArrayList<>()).add(transaction);
	}
	
	public List<Transaction> getTransactions(String userId){
		return transactions.getOrDefault(userId, new ArrayList<>());
	}
}
