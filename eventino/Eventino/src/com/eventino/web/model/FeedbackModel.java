package com.eventino.web.model;

import java.util.Date;

public class FeedbackModel {

	private int feedback_id;
	private String feedback_title;
	private Date feedback_date;
	private String feedback_desc;
	
	
	
	public FeedbackModel(String feedback_title, Date feedback_date, String feedback_desc) {
		super();
		this.feedback_title = feedback_title;
		this.feedback_date = feedback_date;
		this.feedback_desc = feedback_desc;
	}
	public FeedbackModel() {
		super();
	}
	public FeedbackModel(int feedback_id, String feedback_title, Date feedback_date, String feedback_desc) {
		super();
		this.feedback_id = feedback_id;
		this.feedback_title = feedback_title;
		this.feedback_date = feedback_date;
		this.feedback_desc = feedback_desc;
	}
	@Override
	public String toString() {
		return "FeedbackModel [feedback_id=" + feedback_id + ", feedback_title=" + feedback_title + ", feedback_date="
				+ feedback_date + ", feedback_desc=" + feedback_desc + "]";
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getFeedback_title() {
		return feedback_title;
	}
	public void setFeedback_title(String feedback_title) {
		this.feedback_title = feedback_title;
	}
	public Date getFeedback_date() {
		return feedback_date;
	}
	public void setFeedback_date(Date feedback_date) {
		this.feedback_date = feedback_date;
	}
	public String getFeedback_desc() {
		return feedback_desc;
	}
	public void setFeedback_desc(String feedback_desc) {
		this.feedback_desc = feedback_desc;
	}
	
	
	

}
