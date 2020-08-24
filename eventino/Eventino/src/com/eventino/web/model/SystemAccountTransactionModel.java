package com.eventino.web.model;

import java.util.Date;

public class SystemAccountTransactionModel {
	
	private int system_account_transaction_id;
	private int account_transaction_id;
	private Double amount;
	private Date system_account_transaction_date;
	private String transaction_desc;
	
	
	public SystemAccountTransactionModel(Double amount, Date system_account_transaction_date, String transaction_desc) {
		super();
		this.amount = amount;
		this.system_account_transaction_date = system_account_transaction_date;
		this.transaction_desc = transaction_desc;
	}
	public SystemAccountTransactionModel(int system_account_transaction_id, Double amount,
			Date system_account_transaction_date, String transaction_desc) {
		super();
		this.system_account_transaction_id = system_account_transaction_id;
		this.amount = amount;
		this.system_account_transaction_date = system_account_transaction_date;
		this.transaction_desc = transaction_desc;
	}
	public SystemAccountTransactionModel(String transaction_desc, int account_transaction_id, Double amount,
			Date system_account_transaction_date) {
		super();
		this.account_transaction_id = account_transaction_id;
		this.amount = amount;
		this.system_account_transaction_date = system_account_transaction_date;
		this.transaction_desc = transaction_desc;
	}
	public SystemAccountTransactionModel() {
		super();
	}
	public SystemAccountTransactionModel(int system_account_transaction_id, int account_transaction_id, Double amount,
			Date system_account_transaction_date, String transaction_desc) {
		super();
		this.system_account_transaction_id = system_account_transaction_id;
		this.account_transaction_id = account_transaction_id;
		this.amount = amount;
		this.system_account_transaction_date = system_account_transaction_date;
		this.transaction_desc = transaction_desc;
	}
	@Override
	public String toString() {
		return "SystemAccountTransactionModel [system_account_transaction_id=" + system_account_transaction_id
				+ ", account_transaction_id=" + account_transaction_id + ", amount=" + amount
				+ ", system_account_transaction_date=" + system_account_transaction_date + ", transaction_desc="
				+ transaction_desc + "]";
	}
	public int getSystem_account_transaction_id() {
		return system_account_transaction_id;
	}
	public void setSystem_account_transaction_id(int system_account_transaction_id) {
		this.system_account_transaction_id = system_account_transaction_id;
	}
	public int getAccount_transaction_id() {
		return account_transaction_id;
	}
	public void setAccount_transaction_id(int account_transaction_id) {
		this.account_transaction_id = account_transaction_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getSystem_account_transaction_date() {
		return system_account_transaction_date;
	}
	public void setSystem_account_transaction_date(Date system_account_transaction_date) {
		this.system_account_transaction_date = system_account_transaction_date;
	}
	public String getTransaction_desc() {
		return transaction_desc;
	}
	public void setTransaction_desc(String transaction_desc) {
		this.transaction_desc = transaction_desc;
	}
	
	
	
	
	

}
