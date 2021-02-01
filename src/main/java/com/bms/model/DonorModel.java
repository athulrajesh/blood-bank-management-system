package com.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DONOR_BMS")
public class DonorModel {
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="B_GROUP")
	private String bg;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="VERIFIED")
	private int verified;
	public int getVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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


	@Column(name="WEIGHT")
	private float weight;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;

	

}
