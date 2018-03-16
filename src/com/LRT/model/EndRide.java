package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "endride")
@Entity
public class EndRide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endrideid")
	private int endRideId;

	@NotNull(message = "is required")
	@Column(name = "startrideid")
	private int startRideId;

	@NotNull(message = "is required")
	@Column(name = "endtime")
	private String endTime;

	@Size(min = 1, message = "is Required")
	@Column(name = "endstorename")
	private String endStoreName;


	@Column(name = "totaltime")
	private int totalTime;

	@Column(name = "totalamount")
	private int totalAmount;


	@Column(name = "anydamage")
	private String anyDamage;

	public int getEndRideId() {
		return endRideId;
	}

	public void setEndRideId(int endRideId) {
		this.endRideId = endRideId;
	}

	public String getEndStoreName() {
		return endStoreName;
	}

	public void setEndStoreName(String endStoreName) {
		this.endStoreName = endStoreName;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getStartRideId() {
		return startRideId;
	}

	public void setStartRideId(int startRideId) {
		this.startRideId = startRideId;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public String getAnyDamage() {
		return anyDamage;
	}

	public void setAnyDamage(String anyDamage) {
		this.anyDamage = anyDamage;
	}



}
