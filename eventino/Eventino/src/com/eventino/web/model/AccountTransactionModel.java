package com.eventino.web.model;

import java.util.Date;

public class AccountTransactionModel {
	
	private int account_transaction_id;
	private int ticket_id;
	private int user_id;
	private Double amount;
	private Date account_transaction_date;
	private String transaction_type;
	
	
	
	
	public AccountTransactionModel(int account_transaction_id, int ticket_id, int user_id, Double amount,
			Date account_transaction_date, String transaction_type) {
		super();
		this.account_transaction_id = account_transaction_id;
		this.ticket_id = ticket_id;
		this.user_id = user_id;
		this.amount = amount;
		this.account_transaction_date = account_transaction_date;
		this.transaction_type = transaction_type;
	}
	public AccountTransactionModel() {
		super();
	}
	public AccountTransactionModel(Double amount, Date account_transaction_date, String transaction_type) {
		super();
		this.amount = amount;
		this.account_transaction_date = account_transaction_date;
		this.transaction_type = transaction_type;
	}
	public AccountTransactionModel(int ticket_id, int user_id, Double amount, Date account_transaction_date,
			String transaction_type) {
		super();
		this.ticket_id = ticket_id;
		this.user_id = user_id;
		this.amount = amount;
		this.account_transaction_date = account_transaction_date;
		this.transaction_type = transaction_type;
	}
	public AccountTransactionModel(int account_transaction_id, Double amount, Date account_transaction_date,
			String transaction_type) {
		super();
		this.account_transaction_id = account_transaction_id;
		this.amount = amount;
		this.account_transaction_date = account_transaction_date;
		this.transaction_type = transaction_type;
	}
	@Override
	public String toString() {
		return "AccountTransactionModel [account_transaction_id=" + account_transaction_id + ", ticket_id=" + ticket_id
				+ ", user_id=" + user_id + ", amount=" + amount + ", account_transaction_date="
				+ account_transaction_date + ", transaction_type=" + transaction_type + "]";
	}
	public int getAccount_transaction_id() {
		return account_transaction_id;
	}
	public void setAccount_transaction_id(int account_transaction_id) {
		this.account_transaction_id = account_transaction_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getAccount_transaction_date() {
		return account_transaction_date;
	}
	public void setAccount_transaction_date(Date account_transaction_date) {
		this.account_transaction_date = account_transaction_date;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	
	

}
