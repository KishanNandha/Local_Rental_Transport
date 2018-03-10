package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Table(name = "userdetails")
@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userID;

	@Size(min = 1, message = "is Required")
	@Column(name = "username")
	private String userName;

	@Size(min = 1, message = "is Required")
	@Column(name = "fname")
	private String fName;

	@Size(min = 1, message = "is Required")
	@Column(name = "lname")
	private String lName;

	@Size(min = 1, message = "is Required")
	@Email(message = "Enter proper email")
	@Column(name = "email")
	private String email;

	@NotNull(message = "is Required")
	@Column(name = "phone")
	private Long phone;

	@Size(min = 1, message = "is Required")
	@Column(name = "dob")
	private String dob;

	@Range(min = 10, message = "age must be greater than 10")
	@NotNull(message = "is Required")
	@Column(name = "age")
	private int age;

	@Size(min = 1, message = "is Required")
	@Column(name = "useraddress")
	private String userAddress;

	@Size(min = 1, message = "is Required")
	@Column(name = "gender")
	private String gender;

	@Digits(integer = 12, fraction = 0)
	@NotNull(message = "is Required")
	@Column(name = "aadhaarno")
	private Long aadhaarNo;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(Long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	@Override
	public String toString() {
		return "UserDetails [userID=" + userID + ", userName=" + userName + ", fName=" + fName + ", lName=" + lName
				+ ", email=" + email + ", phone=" + phone + ", dob=" + dob + ", age=" + age + ", userAddress="
				+ userAddress + ", gender=" + gender + ", aadhaarNo=" + aadhaarNo + "]";
	}

}
