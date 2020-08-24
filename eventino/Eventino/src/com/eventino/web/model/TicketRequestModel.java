package com.eventino.web.model;

public class TicketRequestModel {
	
	private int ticket_id;
	private int student_id;
	private int charity_account_transaction_id;
	private int administrator_id;
	private Boolean is_accepted;
	
	
	
	public TicketRequestModel(int charity_account_transaction_id, int administrator_id, Boolean is_accepted) {
		super();
		this.charity_account_transaction_id = charity_account_transaction_id;
		this.administrator_id = administrator_id;
		this.is_accepted = is_accepted;
	}
	public TicketRequestModel(int ticket_id, int student_id, int charity_account_transaction_id, int administrator_id,
			Boolean is_accepted) {
		super();
		this.ticket_id = ticket_id;
		this.student_id = student_id;
		this.charity_account_transaction_id = charity_account_transaction_id;
		this.administrator_id = administrator_id;
		this.is_accepted = is_accepted;
	}
	public TicketRequestModel() {
		super();
	}
	public TicketRequestModel(Boolean is_accepted) {
		super();
		this.is_accepted = is_accepted;
	}
	@Override
	public String toString() {
		return "TicketRequest [ticket_id=" + ticket_id + ", student_id=" + student_id
				+ ", charity_account_transaction_id=" + charity_account_transaction_id + ", administrator_id="
				+ administrator_id + ", is_accepted=" + is_accepted + "]";
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCharity_account_transaction_id() {
		return charity_account_transaction_id;
	}
	public void setCharity_account_transaction_id(int charity_account_transaction_id) {
		this.charity_account_transaction_id = charity_account_transaction_id;
	}
	public int getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(int administrator_id) {
		this.administrator_id = administrator_id;
	}
	public Boolean getIs_accepted() {
		return is_accepted;
	}
	public void setIs_accepted(Boolean is_accepted) {
		this.is_accepted = is_accepted;
	}
	
	
	

}
