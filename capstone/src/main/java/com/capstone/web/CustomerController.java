package com.capstone.web;

import java.net.URI;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capstone.model.Customer;
import com.capstone.service.CustomerService;

@ComponentScan("com.capstone.service")
@RestController
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping("/customers")
	public List<Customer> getAllUsers() {

		return service.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer getUserById(@PathVariable int id) {

		return service.getUserById(id);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {

		service.deleteUserById(id);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer savedCustomer = service.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}