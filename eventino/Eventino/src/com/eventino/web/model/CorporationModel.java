package com.eventino.web.model;

public class CorporationModel {
	
	private int corporation_id;
	private String sector;
	
	
	
	public CorporationModel(int corporation_id, String sector) {
		super();
		this.corporation_id = corporation_id;
		this.sector = sector;
	}
	public CorporationModel() {
		super();
	}
	public CorporationModel(String sector) {
		super();
		this.sector = sector;
	}
	@Override
	public String toString() {
		return "CorporationModel [corporation_id=" + corporation_id + ", sector=" + sector + "]";
	}
	public int getCorporation_id() {
		return corporation_id;
	}
	public void setCorporation_id(int corporation_id) {
		this.corporation_id = corporation_id;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	

}
