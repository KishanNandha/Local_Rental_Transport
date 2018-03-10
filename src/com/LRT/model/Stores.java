package com.LRT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "stores")
@Entity
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storeid")
	private int stireId;

	@Size(min = 1, message = "is Required")
	@Column(name = "storename")
	private String storeName;

	@Size(min = 1, message = "is Required")
	@Column(name = "storeaddress")
	private String storeAddress;

	@NotNull(message = "is Required")
	@Column(name = "totalcycles")
	private int totalCycles;

	public int getStireId() {
		return stireId;
	}

	public void setStireId(int stireId) {
		this.stireId = stireId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public int getTotalCycles() {
		return totalCycles;
	}

	public void setTotalCycles(int totalCycles) {
		this.totalCycles = totalCycles;
	}

	@Override
	public String toString() {
		return "Stores [stireId=" + stireId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", totalCycles=" + totalCycles + "]";
	}

}
