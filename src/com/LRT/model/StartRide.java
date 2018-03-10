package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "startride")
@Entity
public class StartRide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "startrideid")
	private int startRideId;

	@Size(min = 1, message = "is Required")
	@Column(name = "username")
	private String userName;

	@Size(min = 1, message = "is Required")
	@Column(name = "storename")
	private String startStoreName;


	@NotNull(message = "is required")
	@Column(name = "departuredate")
	private String departureDate;

	@Size(min = 1, message = "is Required")
	@Column(name = "departuretime")
	private String departureTime;

	@Size(min = 1, message = "is Required")
	@Column(name = "estimatedendtime")
	private String estimatedEndTime;

	@NotNull(message = "is Required")
	@Column(name = "cycleid")
	private int cycleId;

	public int getStartRideId() {
		return startRideId;
	}

	public void setStartRideId(int startRideId) {
		this.startRideId = startRideId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStartStoreName() {
		return startStoreName;
	}

	public void setStartStoreName(String startStoreName) {
		this.startStoreName = startStoreName;
	}

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getEstimatedEndTime() {
		return estimatedEndTime;
	}

	public void setEstimatedEndTime(String estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}

}
