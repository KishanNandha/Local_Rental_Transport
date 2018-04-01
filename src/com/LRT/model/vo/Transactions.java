package com.LRT.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "transactions")
@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transid")
	private int transId;

	@Column(name = "endrideid")
	private int endRideId;

	@Column(name = "username")
	private String userName;

	@Column(name = "endstorename")
	private String endStoreName;

	@Column(name = "totaltime")
	private int totalTime;

	@Column(name = "totalamount")
	private int totalAmount;

	@Column(name = "date")
	private String date;

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getEndRideId() {
		return endRideId;
	}

	public void setEndRideId(int endRideId) {
		this.endRideId = endRideId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEndStoreName() {
		return endStoreName;
	}

	public void setEndStoreName(String endStoreName) {
		this.endStoreName = endStoreName;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
