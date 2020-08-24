package com.eventino.web.model;

public class CommunityModel {
	
	private int community_id;
	private int corporation_id;
	private String community_type;
	

	
	public CommunityModel(int community_id, String community_type) {
		super();
		this.community_id = community_id;
		this.community_type = community_type;
	}
	public CommunityModel(String community_type, int corporation_id) {
		super();
		this.corporation_id = corporation_id;
		this.community_type = community_type;
	}
	public CommunityModel() {
		super();
	}
	public CommunityModel(int community_id, int corporation_id, String community_type) {
		super();
		this.community_id = community_id;
		this.corporation_id = corporation_id;
		this.community_type = community_type;
	}
	@Override
	public String toString() {
		return "CommunityModel [community_id=" + community_id + ", corporation_id=" + corporation_id
				+ ", community_type=" + community_type + "]";
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public int getCorporation_id() {
		return corporation_id;
	}
	public void setCorporation_id(int corporation_id) {
		this.corporation_id = corporation_id;
	}
	public String getCommunity_type() {
		return community_type;
	}
	public void setCommunity_type(String community_type) {
		this.community_type = community_type;
	}
	
	
	
	
	
}
