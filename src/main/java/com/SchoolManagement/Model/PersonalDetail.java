package com.SchoolManagement.Model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class PersonalDetail {
  
  @Id
  private int admissionNo;
  private String guardianName;
  private String email;
  private LocalDate dob;
  private String aadhar;
  private String gender;
  private LocalDate date;
  @Lob
  @Column(length = Integer.MAX_VALUE,nullable = true)
  private byte[] image;
  
  

public PersonalDetail() {
	super();
}


public PersonalDetail(int admissionNo, String guardianName, String email, LocalDate dob, String aadhar, String gender,
		LocalDate date, byte[] image) {
	super();
	this.admissionNo = admissionNo;
	this.guardianName = guardianName;
	this.email = email;
	this.dob = dob;
	this.aadhar = aadhar;
	this.gender = gender;
	this.date = date;
	this.image = image;
}


public int getAdmissionNo() {
	return admissionNo;
}


public void setAdmissionNo(int admissionNo) {
	this.admissionNo = admissionNo;
}


public String getGuardianName() {
	return guardianName;
}


public void setGuardianName(String guardianName) {
	this.guardianName = guardianName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public LocalDate getDob() {
	return dob;
}


public void setDob(LocalDate dob) {
	this.dob = dob;
}


public String getAadhar() {
	return aadhar;
}


public void setAadhar(String aadhar) {
	this.aadhar = aadhar;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public LocalDate getDate() {
	return date;
}


public void setDate(LocalDate date) {
	this.date = date;
}


public byte[] getImage() {
	return image;
}


public void setImage(byte[] image) {
	this.image = image;
}



   
} 