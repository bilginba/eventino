package com.eventino.web.model;

public class AdvertiserModel {


	public int advertiser_id;
	public String advertiser_name;
	public String logo;
	public String advertiser_description;
	public String advertiser_type;

	public AdvertiserModel(String advertiser_name, String logo, String advertiser_description, String advertiser_type) {
		super();
		this.advertiser_name = advertiser_name;
		this.logo = logo;
		this.advertiser_description = advertiser_description;
		this.advertiser_type = advertiser_type;
	}

	public AdvertiserModel(int advertiser_id, String advertiser_name, String logo, String advertiser_description,
			String advertiser_type) {
		super();
		this.advertiser_id = advertiser_id;
		this.advertiser_name = advertiser_name;
		this.logo = logo;
		this.advertiser_description = advertiser_description;
		this.advertiser_type = advertiser_type;
	}

	public AdvertiserModel() {
		super();
	}

	@Override
	public String toString() {
		return "AdvertiserModel [advertiser_id=" + advertiser_id + ", advertiser_name=" + advertiser_name + ", logo="
				+ logo + ", advertiser_description=" + advertiser_description + ", advertiser_type=" + advertiser_type
				+ "]";
	}

	public int getAdvertiser_id() {
		return advertiser_id;
	}

	public void setAdvertiser_id(int advertiser_id) {
		this.advertiser_id = advertiser_id;
	}

	public String getAdvertiser_name() {
		return advertiser_name;
	}

	public void setAdvertiser_name(String advertiser_name) {
		this.advertiser_name = advertiser_name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAdvertiser_description() {
		return advertiser_description;
	}

	public void setAdvertiser_description(String advertiser_description) {
		this.advertiser_description = advertiser_description;
	}

	public String getAdvertiser_type() {
		return advertiser_type;
	}

	public void setAdvertiser_type(String advertiser_type) {
		this.advertiser_type = advertiser_type;
	}



}
