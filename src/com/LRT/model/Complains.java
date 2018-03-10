package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "complains")
@Entity
public class Complains {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complainid")
	private int complainId;

	@OneToOne()
	@JoinColumn(name = "userid")
	private UserDetails userId;

	@Size(min = 1, message = "is Required")
	@Column(name = "complaindetails")
	private String complainDetails;

	@Size(min = 1, message = "is Required")
	@Column(name = "status")
	private String status;

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public String getComplainDetails() {
		return complainDetails;
	}

	public void setComplainDetails(String complainDetails) {
		this.complainDetails = complainDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complains [complainId=" + complainId + ", userId=" + userId + ", complainDetails=" + complainDetails
				+ ", status=" + status + "]";
	}

}
