package com.example.springboot;

import java.util.ArrayList;

public class Customers {
	private ArrayList<Customer> customers;

	public Customers() {
		customers = new ArrayList<Customer>();
		customers.add(new Customer(1L,"Raj Joseph","1000 Joseph Street, Hosuton TX"));
		customers.add(new Customer(2L,"Danna Ellis", "Ellis Street, Dallas TX"));
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

}
