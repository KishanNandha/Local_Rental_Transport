package com.LRT.model.DTO;

//this class is used to hold data of rides(Data Transfer object)
public class RideAllDetails {
	// Start ride details
	private int startRideId;
	private String userName;
	private String startStoreName;
	private String departureDate;
	private String departureTime;
	private String estimatedEndTime;
	private int cycleId;

	// end ride details
	private int endRideId;
	private String endTime;
	private String endStoreName;
	private int totalTime;
	private int totalAmount;
	private String anyDamage;

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

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public int getEndRideId() {
		return endRideId;
	}

	public void setEndRideId(int endRideId) {
		this.endRideId = endRideId;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getAnyDamage() {
		return anyDamage;
	}

	public void setAnyDamage(String anyDamage) {
		this.anyDamage = anyDamage;
	}

	@Override
	public String toString() {
		return "RideAllDetails [startRideId=" + startRideId + ", userName=" + userName + ", startStoreName="
				+ startStoreName + ", departureDate=" + departureDate + ", departureTime=" + departureTime
				+ ", estimatedEndTime=" + estimatedEndTime + ", cycleId=" + cycleId + ", endRideId=" + endRideId
				+ ", endTime=" + endTime + ", endStoreName=" + endStoreName + ", totalTime=" + totalTime
				+ ", totalAmount=" + totalAmount + ", anyDamage=" + anyDamage + "]";
	}

}
