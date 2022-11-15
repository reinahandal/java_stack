package com.reinahandal.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.events.models.Event;
import com.reinahandal.events.models.State;

public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	List<Event> findAllByStateIsNot(State state);
	List<Event> findAllByState(State state);
	List<Event> findAllByNameContainsIgnoreCase(String name);
}
