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

@Table(name = "feedbacks")
@Entity
public class Feedbacks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedbackid")
	private int feedbackId;

	@OneToOne()
	@JoinColumn(name = "userid")
	private UserDetails userId;

	@Size(min = 1, message = "is Required")
	@Column(name = "feedbackdetails")
	private String feedbackDetails;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public String getFeedbackDetails() {
		return feedbackDetails;
	}

	public void setFeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}

	@Override
	public String toString() {
		return "Feedbacks [feedbackId=" + feedbackId + ", userId=" + userId + ", feedbackDetails=" + feedbackDetails
				+ "]";
	}

}
