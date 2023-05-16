package com.SportyShoesProject.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User {
	@Id
	private String emailId;

	@Column(name="pass_word",length = 20)
	private String pass_word;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="country")
	private String country;

	@Column(name="gender")
	private String gender;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String emailId, String password, String firstName, String lastName, String country, String gender,
			Date dateOfBirth) {
		super();
		this.emailId = emailId;
		this.pass_word = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return pass_word;
	}

	public void setPassword(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + pass_word + ", firstName=" + firstName + ", lastName="
				+ lastName + ", country=" + country + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	}
	

}
