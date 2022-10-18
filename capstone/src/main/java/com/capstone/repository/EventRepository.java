package com.capstone.repository;

import org.springframework.data.repository.CrudRepository;
import com.capstone.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}