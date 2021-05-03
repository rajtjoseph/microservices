package com.example.springboot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	private KafkaTemplate<Object,Object> template;
	
	@GetMapping("/customers")
	List<Customer> all() {
		
		return repository.findAll();
	}

	
	
	@PostMapping("/customers")
	  Customer newCustomer(@RequestBody Customer newCustomer) {
		// Produce a message on the topic for this customer 
		this.template.executeInTransaction(t -> t.send("mcglobal-customers",newCustomer));
		repository.save(newCustomer);
		return newCustomer;
	  }
	
	@GetMapping("/customers/{id}")
	  Customer getCustomer(@PathVariable Long id) {
	    return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	    
	}
	
	@PutMapping("customers/{id}")
	Customer updateCustomer(@RequestBody Customer rCustomer, @PathVariable Long id) {
		Customer updatedCustomer = repository.findById(id) //
			      .map(customer -> {
			    	  customer.setCustomerName(rCustomer.getCustomerName());
			    	  customer.setCustomerAddress(rCustomer.getCustomerAddress());
			        return repository.save(customer);
			      })
			      .orElseGet(() -> {
			    	  rCustomer.getCustomerId();
			        return repository.save(rCustomer);
			      });
		  return null;
	}
	
	@DeleteMapping("customers/{id}")
	void deleteCustomer(@PathVariable Long id) {	
			repository.deleteById(id);
	}
	
}
