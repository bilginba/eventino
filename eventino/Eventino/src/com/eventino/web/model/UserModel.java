package com.eventino.web.model;

public class UserModel {
	
	private int id;
	private String username;
	private String pass;
	private String email;
	private String phone_number;
	private String address;
	private String user_type;
	
	
	
	public UserModel() {
		super();
	}
	public UserModel(String username, String pass, String email, String phone_number, String address,
			String user_type) {
		super();
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.user_type = user_type;
	}
	public UserModel(int id, String username, String pass, String email, String phone_number, String address,
			String user_type) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", pass=" + pass + ", email=" + email
				+ ", phone_number=" + phone_number + ", address=" + address + ", user_type=" + user_type + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	
	
}
