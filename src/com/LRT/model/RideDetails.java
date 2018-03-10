package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "ridedetails")
@Entity
public class RideDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int rideId;

	@OneToOne()
	@JoinColumn(name = "startrideid")
	private StartRide startRideId;

	@OneToOne()
	@JoinColumn(name = "endrideid")
	private EndRide endRideId;

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public StartRide getStartRideId() {
		return startRideId;
	}

	public void setStartRideId(StartRide startRideId) {
		this.startRideId = startRideId;
	}

	public EndRide getEndRideId() {
		return endRideId;
	}

	public void setEndRideId(EndRide endRideId) {
		this.endRideId = endRideId;
	}

	@Override
	public String toString() {
		return "RideDetails [rideId=" + rideId + ", startRideId=" + startRideId + ", endRideId=" + endRideId + "]";
	}

}
