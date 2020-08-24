package com.eventino.web.model;

import java.util.Date;

public class EventModel {

	private int event_id;
	private int advertiser_id;
	private int system_account_transaction_id;
	private int account_transaction_id;
	private String event_address;
	private String event_title;
	private String event_desc;
	private Date event_expire_date;
	private Date event_publish_date;
	private Date event_time;
	private String event_type;
	private String event_photo;
	
	
	public EventModel() {
		super();
	}
	public EventModel(int event_id, int advertiser, int system_account_transaction_id, int account_transaction_id,
			String event_title) {
		super();
		this.event_id = event_id;
		this.advertiser_id = advertiser;
		this.system_account_transaction_id = system_account_transaction_id;
		this.account_transaction_id = account_transaction_id;
		this.event_title = event_title;
	}
	public EventModel(int advertiser, String event_address, String event_title, String event_desc, Date event_expire_date,
			Date event_publish_date, Date event_time, String event_type, String event_photo) {
		super();
		this.advertiser_id = advertiser;
		this.event_address = event_address;
		this.event_title = event_title;
		this.event_desc = event_desc;
		this.event_expire_date = event_expire_date;
		this.event_publish_date = event_publish_date;
		this.event_time = event_time;
		this.event_type = event_type;
		this.event_photo = event_photo;
	}
	public EventModel(int event_id, int advertiser, String event_address, String event_title, String event_desc,
			Date event_expire_date, Date event_publish_date, Date event_time, String event_type, String event_photo) {
		super();
		this.event_id = event_id;
		this.advertiser_id = advertiser;
		this.event_address = event_address;
		this.event_title = event_title;
		this.event_desc = event_desc;
		this.event_expire_date = event_expire_date;
		this.event_publish_date = event_publish_date;
		this.event_time = event_time;
		this.event_type = event_type;
		this.event_photo = event_photo;
	}
	public EventModel(int event_id, int advertiser, int system_account_transaction_id, int account_transaction_id,
			String event_address, String event_title, String event_desc, Date event_expire_date,
			Date event_publish_date, Date event_time, String event_type, String event_photo) {
		super();
		this.event_id = event_id;
		this.advertiser_id = advertiser;
		this.system_account_transaction_id = system_account_transaction_id;
		this.account_transaction_id = account_transaction_id;
		this.event_address = event_address;
		this.event_title = event_title;
		this.event_desc = event_desc;
		this.event_expire_date = event_expire_date;
		this.event_publish_date = event_publish_date;
		this.event_time = event_time;
		this.event_type = event_type;
		this.event_photo = event_photo;
	}
	public EventModel(int advertiser, int system_account_transaction_id, int account_transaction_id, String event_address,
			String event_title, String event_desc, Date event_expire_date, Date event_publish_date, Date event_time,
			String event_type, String event_photo) {
		super();
		this.advertiser_id = advertiser;
		this.system_account_transaction_id = system_account_transaction_id;
		this.account_transaction_id = account_transaction_id;
		this.event_address = event_address;
		this.event_title = event_title;
		this.event_desc = event_desc;
		this.event_expire_date = event_expire_date;
		this.event_publish_date = event_publish_date;
		this.event_time = event_time;
		this.event_type = event_type;
		this.event_photo = event_photo;
	}
	@Override
	public String toString() {
		return "event [event_id=" + event_id + ", advertiser=" + advertiser_id + ", system_account_transaction_id="
				+ system_account_transaction_id + ", account_transaction_id=" + account_transaction_id
				+ ", event_address=" + event_address + ", event_title=" + event_title + ", event_desc=" + event_desc
				+ ", event_expire_date=" + event_expire_date + ", event_publish_date=" + event_publish_date
				+ ", event_time=" + event_time + ", event_type=" + event_type + ", event_photo=" + event_photo + "]";
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getAdvertiser_id() {
		return advertiser_id;
	}
	public void setAdvertiser_id(int advertiser_id) {
		this.advertiser_id = advertiser_id;
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
	public String getEvent_address() {
		return event_address;
	}
	public void setEvent_address(String event_address) {
		this.event_address = event_address;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_desc() {
		return event_desc;
	}
	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}
	public Date getEvent_expire_date() {
		return event_expire_date;
	}
	public void setEvent_expire_date(Date event_expire_date) {
		this.event_expire_date = event_expire_date;
	}
	public Date getEvent_publish_date() {
		return event_publish_date;
	}
	public void setEvent_publish_date(Date event_publish_date) {
		this.event_publish_date = event_publish_date;
	}
	public Date getEvent_time() {
		return event_time;
	}
	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEvent_photo() {
		return event_photo;
	}
	public void setEvent_photo(String event_photo) {
		this.event_photo = event_photo;
	}
	
}
