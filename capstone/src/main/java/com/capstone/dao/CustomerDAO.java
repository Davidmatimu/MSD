package com.capstone.dao;

import com.capstone.model.Customer;

public interface CustomerDAO {

	void insertCustomer(Customer customer);

	boolean updateCustomer(Customer customer);

	boolean deleteCustomer(Customer customer);

}
