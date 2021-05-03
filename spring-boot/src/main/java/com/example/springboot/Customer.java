package com.example.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	// Id is necessary for each table to be identified as unique identifier
	@Id
	@Column(name="CUSTOMERID")
	private Long customerId;
	@Column(name="CUSTOMERNAME")
	private String customerName;
	@Column(name="CUSTOMERADDRESS")
	private String customerAddress;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Long i, String n, String a) {
		customerId = i;
		customerName = n;
		customerAddress = a;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer{" + "id=" + this.customerId + ", name='" +
				this.customerName + "', address='" + this.customerAddress + "'}";
	}
	

}
