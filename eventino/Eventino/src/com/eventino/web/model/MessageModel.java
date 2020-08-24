package com.eventino.web.model;

import java.util.Date;

public class MessageModel {
	
	private int message_id;
	private String message_title;
	private Date message_date;
	private String message_desc;
	
	
	
	public MessageModel(String message_title, Date message_date, String message_desc) {
		super();
		this.message_title = message_title;
		this.message_date = message_date;
		this.message_desc = message_desc;
	}
	public MessageModel() {
		super();
	}
	public MessageModel(int message_id, String message_title, Date message_date, String message_desc) {
		super();
		this.message_id = message_id;
		this.message_title = message_title;
		this.message_date = message_date;
		this.message_desc = message_desc;
	}
	@Override
	public String toString() {
		return "MessageModel [message_id=" + message_id + ", message_title=" + message_title + ", message_date="
				+ message_date + ", message_desc=" + message_desc + "]";
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_title() {
		return message_title;
	}
	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	public Date getMessage_date() {
		return message_date;
	}
	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}
	public String getMessage_desc() {
		return message_desc;
	}
	public void setMessage_desc(String message_desc) {
		this.message_desc = message_desc;
	}
	
	
	

}
