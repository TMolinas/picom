package com.hb.bc.picom.database;


import java.sql.Date;

public class User {

	public static int inc = 4;
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String bankDetails;
	private String dateExpirationBank;
	private String cvv;
	private String adress;
	private int idCity;
	private Date dateInscription;
	
	public static int generateId() {
		return inc++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getDateExpirationBank() {
		return dateExpirationBank;
	}

	public void setDateExpirationBank(String dateExpirationBank) {
		this.dateExpirationBank = dateExpirationBank;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getIdCity() {
		return idCity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	public User() {
		
	}
	
	public User(String firstName, String lastName , String email, String password, Date dateInscription, String phone) {
		this.id = inc++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateInscription = dateInscription;
		this.phone = phone;
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", bankDetails=" + bankDetails
				+ ", dateExpirationBank=" + dateExpirationBank + ", cvv=" + cvv + ", adress=" + adress + ", idCity="
				+ idCity + ", dateInscription=" + dateInscription + "]";
	}
	
}


