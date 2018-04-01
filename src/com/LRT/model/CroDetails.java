package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "crodetails")
@Entity
public class CroDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crodetailsid")
	private int croDetailsId;

	@Column(name = "username")
	private String userName;

	@Column(name = "storename")
	private String storeName;

	public int getCroDetailsId() {
		return croDetailsId;
	}

	public void setCroDetailsId(int croDetailsId) {
		this.croDetailsId = croDetailsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
