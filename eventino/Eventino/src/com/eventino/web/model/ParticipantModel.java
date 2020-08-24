package com.eventino.web.model;

import java.util.Date;

public class ParticipantModel {
	
	private int participant_id;
	private String profile_picture; 
	private String nationality;
	private Date birthdate;
	private String surname;
	private String participant_name;
	private String gender;
	private String job_title;
	private String foreign_languages;
	private String certificates;
	private int corporation_id;
	private String participant_type;
	
	
	public ParticipantModel() {
		super();
	}
	public ParticipantModel(String profile_picture, String nationality, Date birthdate, String surname,
			String participant_name, String gender, String job_title, String foreign_languages, String certificates,
			int corporation_id, String participant_type) {
		super();
		this.profile_picture = profile_picture;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.surname = surname;
		this.participant_name = participant_name;
		this.gender = gender;
		this.job_title = job_title;
		this.foreign_languages = foreign_languages;
		this.certificates = certificates;
		this.corporation_id = corporation_id;
		this.participant_type = participant_type;
	}
	public ParticipantModel(int participant_id, String profile_picture, String nationality, Date birthdate,
			String surname, String participant_name, String gender, String job_title, String foreign_languages,
			String certificates, String participant_type) {
		super();
		this.participant_id = participant_id;
		this.profile_picture = profile_picture;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.surname = surname;
		this.participant_name = participant_name;
		this.gender = gender;
		this.job_title = job_title;
		this.foreign_languages = foreign_languages;
		this.certificates = certificates;
		this.participant_type = participant_type;
	}
	public ParticipantModel(String profile_picture, String nationality, Date birthdate, String surname,
			String participant_name, String gender, String job_title, String foreign_languages, String certificates,
			String participant_type) {
		super();
		this.profile_picture = profile_picture;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.surname = surname;
		this.participant_name = participant_name;
		this.gender = gender;
		this.job_title = job_title;
		this.foreign_languages = foreign_languages;
		this.certificates = certificates;
		this.participant_type = participant_type;
	}
	public ParticipantModel(int participant_id, String profile_picture, String nationality, Date birthdate,
			String surname, String participant_name, String gender, String job_title, String foreign_languages,
			String certificates, int corporation_id, String participant_type) {
		super();
		this.participant_id = participant_id;
		this.profile_picture = profile_picture;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.surname = surname;
		this.participant_name = participant_name;
		this.gender = gender;
		this.job_title = job_title;
		this.foreign_languages = foreign_languages;
		this.certificates = certificates;
		this.corporation_id = corporation_id;
		this.participant_type = participant_type;
	}
	@Override
	public String toString() {
		return "ParticipantModel [participant_id=" + participant_id + ", profile_picture=" + profile_picture
				+ ", nationality=" + nationality + ", birthdate=" + birthdate + ", surname=" + surname
				+ ", participant_name=" + participant_name + ", gender=" + gender + ", job_title=" + job_title
				+ ", foreign_languages=" + foreign_languages + ", certificates=" + certificates + ", corporation_id="
				+ corporation_id + ", participant_type=" + participant_type + "]";
	}
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getForeign_languages() {
		return foreign_languages;
	}
	public void setForeign_languages(String foreign_languages) {
		this.foreign_languages = foreign_languages;
	}
	public String getCertificates() {
		return certificates;
	}
	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}
	public int getCorporation_id() {
		return corporation_id;
	}
	public void setCorporation_id(int corporation_id) {
		this.corporation_id = corporation_id;
	}
	public String getParticipant_type() {
		return participant_type;
	}
	public void setParticipant_type(String participant_type) {
		this.participant_type = participant_type;
	}
	
	
}
