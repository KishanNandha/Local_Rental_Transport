package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ridedetails")
@Entity
public class RideDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rideid")
	private int rideId;

	@Column(name = "startrideid")
	private int startRideId;

	@Column(name = "endrideid")
	private int endRideId;

	@Column(name = "username")
	private String username;

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public int getStartRideId() {
		return startRideId;
	}

	public void setStartRideId(int startRideId) {
		this.startRideId = startRideId;
	}

	public int getEndRideId() {
		return endRideId;
	}

	public void setEndRideId(int endRideId) {
		this.endRideId = endRideId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
