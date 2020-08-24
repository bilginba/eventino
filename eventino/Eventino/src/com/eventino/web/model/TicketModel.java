package com.eventino.web.model;

import java.util.Date;

public class TicketModel {
	
	private int ticket_id;
	private Double price;
	private String ticket_type;
	private Date acquisition_date;
	private int event_id;
	private int participant_id;
	
	
	public TicketModel(Double price, String ticket_type, Date acquisition_date) {
		super();
		this.price = price;
		this.ticket_type = ticket_type;
		this.acquisition_date = acquisition_date;
	}
	public TicketModel(int ticket_id, Double price, String ticket_type, Date acquisition_date) {
		super();
		this.ticket_id = ticket_id;
		this.price = price;
		this.ticket_type = ticket_type;
		this.acquisition_date = acquisition_date;
	}
	public TicketModel(Double price, String ticket_type, Date acquisition_date, int event_id, int participant_id) {
		super();
		this.price = price;
		this.ticket_type = ticket_type;
		this.acquisition_date = acquisition_date;
		this.event_id = event_id;
		this.participant_id = participant_id;
	}
	public TicketModel() {
		super();
	}
	public TicketModel(int ticket_id, Double price, String ticket_type, Date acquisition_date, int event_id,
			int participant_id) {
		super();
		this.ticket_id = ticket_id;
		this.price = price;
		this.ticket_type = ticket_type;
		this.acquisition_date = acquisition_date;
		this.event_id = event_id;
		this.participant_id = participant_id;
	}
	@Override
	public String toString() {
		return "TicketModel [ticket_id=" + ticket_id + ", price=" + price + ", ticket_type=" + ticket_type
				+ ", acquisition_date=" + acquisition_date + ", event_id=" + event_id + ", participant_id="
				+ participant_id + "]";
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTicket_type() {
		return ticket_type;
	}
	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	public Date getAcquisition_date() {
		return acquisition_date;
	}
	public void setAcquisition_date(Date acquisition_date) {
		this.acquisition_date = acquisition_date;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	
	
	

}
