package es.cursojava.springboot.springbootvik.ejercicios.customer.beans;

import java.util.Date;

public class Customer{ 
	
	//textbox
	String userName;
	
	//textarea
	String address;
	
	//password
	String password;
	String confirmPassword;
	
	
	boolean receiveNewsletter;
	//checkbox
	String [] favFramework;
	
	//radio button
	String favNumber;
	String sex;
	
	//dropdown box
	String country;
	String javaSkills;
	String numero;
	
	//hidden value
	String secretValue;
	
	Date date;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}
	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}
	public String[] getFavFramework() {
		return favFramework;
	}
	public void setFavFramework(String[] favFramework) {
		this.favFramework = favFramework;
	}
	public String getFavNumber() {
		return favNumber;
	}
	public void setFavNumber(String favNumber) {
		this.favNumber = favNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getJavaSkills() {
		return javaSkills;
	}
	public void setJavaSkills(String javaSkills) {
		this.javaSkills = javaSkills;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", address=" + address
				+ ", sex=" + sex + "]";
	}
	
	
}