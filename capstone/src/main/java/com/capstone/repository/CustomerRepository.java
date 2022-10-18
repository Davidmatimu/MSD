package com.capstone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
