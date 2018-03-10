package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "subscriptions")
@Entity
public class Subscriptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscriptionid")
	private int subscriptionId;

	@OneToOne()
	@JoinColumn(name = "userid")
	private UserDetails userId;

	@NotNull(message = "is Required")
	@Column(name = "amount")
	private int amount;

	@Size(min = 1, message = "is Required")
	@Column(name = "subscriptiontype")
	private String subscriptionType;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Override
	public String toString() {
		return "Subscriptions [subscriptionId=" + subscriptionId + ", userId=" + userId + ", amount=" + amount
				+ ", subscriptionType=" + subscriptionType + "]";
	}

}
