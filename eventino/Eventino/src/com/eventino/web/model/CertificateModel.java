package com.eventino.web.model;

import java.util.Date;

public class CertificateModel {
	
	private int certificate_id;
	private String certificate_title;
	private Date certificate_date;
	private String certificate_description;
	private int event_id;
	
	
	public CertificateModel(String certificate_title, Date certificate_date, String certificate_description) {
		super();
		this.certificate_title = certificate_title;
		this.certificate_date = certificate_date;
		this.certificate_description = certificate_description;
	}
	public CertificateModel(int certificate_id, String certificate_title, Date certificate_date,
			String certificate_description) {
		super();
		this.certificate_id = certificate_id;
		this.certificate_title = certificate_title;
		this.certificate_date = certificate_date;
		this.certificate_description = certificate_description;
	}
	public CertificateModel(String certificate_title, Date certificate_date, String certificate_description,
			int event_id) {
		super();
		this.certificate_title = certificate_title;
		this.certificate_date = certificate_date;
		this.certificate_description = certificate_description;
		this.event_id = event_id;
	}
	public CertificateModel() {
		super();
	}
	public CertificateModel(int certificate_id, String certificate_title, Date certificate_date,
			String certificate_description, int event_id) {
		super();
		this.certificate_id = certificate_id;
		this.certificate_title = certificate_title;
		this.certificate_date = certificate_date;
		this.certificate_description = certificate_description;
		this.event_id = event_id;
	}
	@Override
	public String toString() {
		return "CertificateModel [certificate_id=" + certificate_id + ", certificate_title=" + certificate_title
				+ ", certificate_date=" + certificate_date + ", certificate_description=" + certificate_description
				+ ", event_id=" + event_id + "]";
	}
	public int getCertificate_id() {
		return certificate_id;
	}
	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}
	public String getCertificate_title() {
		return certificate_title;
	}
	public void setCertificate_title(String certificate_title) {
		this.certificate_title = certificate_title;
	}
	public Date getCertificate_date() {
		return certificate_date;
	}
	public void setCertificate_date(Date certificate_date) {
		this.certificate_date = certificate_date;
	}
	public String getCertificate_description() {
		return certificate_description;
	}
	public void setCertificate_description(String certificate_description) {
		this.certificate_description = certificate_description;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	
	

}
