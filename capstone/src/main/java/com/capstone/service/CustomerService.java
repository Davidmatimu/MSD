package com.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import com.capstone.domain.Customer;

@Component
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();

	private static Integer customerCount = 0;

	static {
		customers.add(new Customer(++customerCount, "Adam", "dog", null));
		customers.add(new Customer(++customerCount, "Eve", "cat", null));
	}

	public List<Customer> findAll() {

		return customers;
	}

	public Customer save(Customer customer) {

		customer.setId(++customerCount);

		customers.add(customer);

		return customer;
	}

}