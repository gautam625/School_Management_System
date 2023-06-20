package com.SchoolManagement.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MarksDetails {

	@Id
	private int admissionNo;
	private double quarterly;
	private double halfYearly;
	private double annual;
	
	
	public MarksDetails(int admissionNo, double quarterly, double halfYearly, double annual) {
		super();
		this.admissionNo = admissionNo;
		this.quarterly = quarterly;
		this.halfYearly = halfYearly;
		this.annual = annual;
	}
	
	
	public MarksDetails() {
		super();
	}
	public int getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(int admissionNo) {
		this.admissionNo = admissionNo;
	}
	public double getQuarterly() {
		return quarterly;
	}
	public void setQuarterly(double quarterly) {
		this.quarterly = quarterly;
	}
	public double getHalfYearly() {
		return halfYearly;
	}
	public void setHalfYearly(double halfYearly) {
		this.halfYearly = halfYearly;
	}
	public double getAnnual() {
		return annual;
	}
	public void setAnnual(double annual) {
		this.annual = annual;
	}

	
}
