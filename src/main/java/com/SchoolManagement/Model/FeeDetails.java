package com.SchoolManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FeeDetails {
	
	@Id
    private int admissionNo;
	private double admissionFee;
	private double quater1Fee;
	private double quater2Fee;
	private double quater3Fee;
	
	public FeeDetails(int admissionNo, double admissionFee, double quater1Fee, double quater2Fee, double quater3Fee) {
		super();
		this.admissionNo = admissionNo;
		this.admissionFee = admissionFee;
		this.quater1Fee = quater1Fee;
		this.quater2Fee = quater2Fee;
		this.quater3Fee = quater3Fee;
	}
	
	public FeeDetails() {
		super();
	}
	public int getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(int admissionNo) {
		this.admissionNo = admissionNo;
	}
	public double getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(double admissionFee) {
		this.admissionFee = admissionFee;
	}
	public double getQuater1Fee() {
		return quater1Fee;
	}
	public void setQuater1Fee(double quater1Fee) {
		this.quater1Fee = quater1Fee;
	}
	public double getQuater2Fee() {
		return quater2Fee;
	}
	public void setQuater2Fee(double quater2Fee) {
		this.quater2Fee = quater2Fee;
	}
	public double getQuater3Fee() {
		return quater3Fee;
	}
	public void setQuater3Fee(double quater3Fee) {
		this.quater3Fee = quater3Fee;
	}
	
	
	
} 
