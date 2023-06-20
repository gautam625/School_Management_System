package com.SchoolManagement.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
    private int admissionNo;
	
	@NotBlank(message = "Name Can Not be Empty......!!")
	@Size(min = 3 ,max = 20,message = "Name Must be Grater Then 3 Character and less then 20 Character..........!!")
	private String name;
	
    @NotBlank(message = "Class Can Not be Empty......!!")
	private String standard;
 
    @NotBlank(message = "Address Can Not be Empty......!!")
	private String place;
    
    @NotBlank(message = "Mobile Number Can Not be Empty......!!")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number must be 10 Digit..........!!")
	private String mobile;
	
	
	public Student(int admissionNo, String name, String standard, String place, String mobile) {
		super();
		this.admissionNo = admissionNo;
		this.name = name;
		this.standard = standard;
		this.place = place;
		this.mobile = mobile;
	}
	
	
	public Student() {
		super();
	}


	public int getAdmissionNo() {
		return admissionNo;
	}


	public void setAdmissionNo(int admissionNo) {
		this.admissionNo = admissionNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


}