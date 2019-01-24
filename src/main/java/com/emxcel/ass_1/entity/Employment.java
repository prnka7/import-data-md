package com.emxcel.ass_1.entity;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employment {
	private String employerName;
	private String designation;
	private Date employmentDate;
	
	public Employment(String employerName, String designation, String employmentDate) throws ParseException {
		super();
		this.employerName = employerName;
		this.designation = designation;
		this.employmentDate= new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(employmentDate).getTime());
	}
	
	public Employment() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}
	@Override
	public String toString() {
		return "employment [employerName=" + employerName + ", designation=" + designation + ", employmentDate="
				+ employmentDate + "]";
	}
	
	
	
}
