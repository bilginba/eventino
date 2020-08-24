package com.eventino.web.model;

public class StudentModel {
	
	private int student_id;
	private String student_certificate;
	private String university_name;
	
	
	public StudentModel() {
		super();
	}
	public StudentModel(String student_certificate, String university_name) {
		super();
		this.student_certificate = student_certificate;
		this.university_name = university_name;
	}
	public StudentModel(int student_id, String student_certificate, String university_name) {
		super();
		this.student_id = student_id;
		this.student_certificate = student_certificate;
		this.university_name = university_name;
	}
	@Override
	public String toString() {
		return "StudentModel [student_id=" + student_id + ", student_certificate=" + student_certificate
				+ ", university_name=" + university_name + "]";
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_certificate() {
		return student_certificate;
	}
	public void setStudent_certificate(String student_certificate) {
		this.student_certificate = student_certificate;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	
	

}
