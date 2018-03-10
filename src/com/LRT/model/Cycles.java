package com.LRT.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "cycles")
@Entity
public class Cycles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cycleid")
	private int cycleId;

	@Size(min = 1, message = "is Required")
	@Column(name = "cycleCondition")
	private String cycleCondition;

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public String getCondition() {
		return cycleCondition;
	}

	public void setCondition(String condition) {
		this.cycleCondition = condition;
	}

	@Override
	public String toString() {
		return "Cycles [cycleId=" + cycleId + ", condition=" + cycleCondition + "]";
	}

}
