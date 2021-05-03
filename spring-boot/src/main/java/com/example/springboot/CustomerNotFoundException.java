package com.example.springboot;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(Long id) {
		super("Can not find Customer with id " + id);
	}

}
