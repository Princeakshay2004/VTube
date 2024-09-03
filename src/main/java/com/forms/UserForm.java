package com.forms;

import org.springframework.web.multipart.MultipartFile;

public class UserForm {
	
	
	private String name;
	private String email;
	private String password;
	private String gender;
	private MultipartFile profile;
	private String number;
	public UserForm(String name, String email, String password, String gender, MultipartFile profile, String number) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.profile = profile;
		this.number = number;
	}
	public UserForm() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public MultipartFile getProfile() {
		return profile;
	}
	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "UserForm [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", profile=" + profile + ", number=" + number + "]";
	}
	
	
	
	
	

}
