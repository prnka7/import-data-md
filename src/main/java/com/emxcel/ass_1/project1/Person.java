package com.emxcel.ass_1.project1;

public class Person 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String city;
	private String state;
	private String country;
	private String mobile;
	private String email;
	private Employment employment;
	
	
	public Person(String firstName, String middleName, String lastName,String gender,String mobile,String email,
			 String city, String state,String country,  Employment employment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobile = mobile;
		this.email = email;	
		this.gender=gender;
		this.city = city;
		this.state = state;
		this.country = country;
		this.employment = employment;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Employment getEmployment() {
		return employment;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String string) {
		this.gender = string;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmployment(Employment employment) {
		this.employment = employment;
	}
	@Override
	public String toString() {
		return "person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender="
				+ gender + ", city=" + city + ", state=" + state + ", country=" + country + ", mobile=" + mobile
				+ ", email=" + email + ", employment=" + employment + "]";
	}
	
	

}
