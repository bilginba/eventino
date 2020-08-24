package com.eventino.web.model;

import java.util.Date;

public class CharityAccountTransactionModel {
	
	private int charity_account_transaction_id;
	private int ticket_id;
	private Double amount;
	private Date charity_account_transaction_date;
	
	
	public CharityAccountTransactionModel() {
		super();
	}
	public CharityAccountTransactionModel(Double amount, Date charity_account_transaction_date) {
		super();
		this.amount = amount;
		this.charity_account_transaction_date = charity_account_transaction_date;
	}
	public CharityAccountTransactionModel(int charity_account_transaction_id, Double amount,
			Date charity_account_transaction_date) {
		super();
		this.charity_account_transaction_id = charity_account_transaction_id;
		this.amount = amount;
		this.charity_account_transaction_date = charity_account_transaction_date;
	}
	public CharityAccountTransactionModel(Date charity_account_transaction_date,int ticket_id, Double amount) {
		super();
		this.ticket_id = ticket_id;
		this.amount = amount;
		this.charity_account_transaction_date = charity_account_transaction_date;
	}
	public CharityAccountTransactionModel(int charity_account_transaction_id, int ticket_id, Double amount,
			Date charity_account_transaction_date) {
		super();
		this.charity_account_transaction_id = charity_account_transaction_id;
		this.ticket_id = ticket_id;
		this.amount = amount;
		this.charity_account_transaction_date = charity_account_transaction_date;
	}
	@Override
	public String toString() {
		return "CharityAccountTransactionModel [charity_account_transaction_id=" + charity_account_transaction_id
				+ ", ticket_id=" + ticket_id + ", amount=" + amount + ", charity_account_transaction_date="
				+ charity_account_transaction_date + "]";
	}
	public int getCharity_account_transaction_id() {
		return charity_account_transaction_id;
	}
	public void setCharity_account_transaction_id(int charity_account_transaction_id) {
		this.charity_account_transaction_id = charity_account_transaction_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCharity_account_transaction_date() {
		return charity_account_transaction_date;
	}
	public void setCharity_account_transaction_date(Date charity_account_transaction_date) {
		this.charity_account_transaction_date = charity_account_transaction_date;
	}
	
	
	
	

}
