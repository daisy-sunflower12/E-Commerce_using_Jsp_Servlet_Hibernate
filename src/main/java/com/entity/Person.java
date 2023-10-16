package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person98")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "u_id")
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private int mobile;
	private double balance;
	private String password;
	public boolean isValid;

	@OneToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;

	@OneToMany(mappedBy = "person")
	private List<Product> products;

	public Person() {
		super();

	}

	public Person(int id, String firstName, String lastName, String dob, String email, int mobile, double balance,
			String password, boolean isValid, UserRole userRole, List<Product> products) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.balance = balance;
		this.password = password;
		this.isValid = isValid;
		this.userRole = userRole;
		this.products = products;
		//this.purchases = purchases;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public boolean isValid() {
//		return isValid;
//	}
//
//	public void setValid(boolean isValid) {
//		this.isValid = isValid;
//	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

//	public List<Purchase> getPurchases() {
//		return purchases;
//	}
//
//	public void setPurchases(List<Purchase> purchases) {
//		this.purchases = purchases;
//	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + ", mobile=" + mobile + ", balance=" + balance + ", password=" + password + ", isValid="
				+ isValid + ", userRole=" + userRole + "]";
	}

}
