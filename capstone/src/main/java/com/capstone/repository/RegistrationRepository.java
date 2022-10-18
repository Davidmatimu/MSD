package com.capstone.repository;

import org.springframework.data.repository.CrudRepository;

import com.capstone.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long>{

}