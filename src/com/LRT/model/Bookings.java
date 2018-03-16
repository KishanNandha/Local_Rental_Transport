package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "bookings")
@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingId;

	@Size(min = 1, message = "is Required")
	@Column(name = "username")
	private String userName;

	@Size(min = 1, message = "is Required")
	@Column(name = "storename")
	private String startStoreName;


	@Size(min = 1, message = "is Required")
	@Column(name = "departuredate")
	private String departureDate;

	@Size(min = 1, message = "is Required")
	@Column(name = "departuretime")
	private String departureTime;

	@Size(min = 1, message = "is Required")
	@Column(name = "estimatedendtime")
	private String estimatedEndTime;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getStartStoreName() {
		return startStoreName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setStartStoreName(String startStoreName) {
		this.startStoreName = startStoreName;
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

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", userName=" + userName + ", startStoreName=" + startStoreName
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", estimatedEndTime="
				+ estimatedEndTime + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Bookings booking = (Bookings) obj;
		if (booking.departureDate.equals(this.departureDate)) {
			if (booking.departureTime.equals(this.departureTime)
					|| booking.estimatedEndTime.equals(this.estimatedEndTime)) {
				return true;
			} else {
				return false;
			}
		}
		else {
			return false;
		}

	}
	

}
