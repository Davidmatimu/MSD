package com.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import com.capstone.model.Customer;

@Component
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();

	private static Integer customerCount = 0;

	static {
		customers.add(new Customer(++customerCount, "Adam", "dog"));
		customers.add(new Customer(++customerCount, "Eve", "cat"));
	}

	public List<Customer> findAll() {

		return customers;
	}

	public Customer getUserById(int id) {

		Predicate<? super Customer> predicate = Customer -> Customer.getId().equals(id);

		return customers.stream().filter(predicate).findFirst().get();
	}

	public void deleteUserById(int id) {

		Predicate<? super Customer> predicate = Customer -> Customer.getId().equals(id);
		
		customers.removeIf(predicate);

	}

	public Customer save(Customer customer) {

		customer.setId(++customerCount);

		customers.add(customer);

		return customer;
	}

}