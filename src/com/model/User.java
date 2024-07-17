package com.model;
//Represents an admin user with properties like name,email,password,mobile number,gender
public class User {
	private String firstname;
	private String lastname;
	private String mobilenumber;
	private String gender;
	private String email;
	private String password;
	private int failedCount;
	private String accountStatus;
	
	public User(String firstname, String lastname, String mobilenumber, String gender, String email, String password, int failedCount, String accountStatus) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.failedCount = failedCount;
		this.accountStatus = accountStatus;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public int getFailedCount() {
		return failedCount;
	}
	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber
				+ ", gender=" + gender + ", email=" + email + ", password=" + password + ", failedCount=" + failedCount
				+ ", accountStatus=" + accountStatus + "]";
	}
}