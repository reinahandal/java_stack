package com.reinahandal.events.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinahandal.events.models.Comment;
import com.reinahandal.events.models.Event;
import com.reinahandal.events.models.State;
import com.reinahandal.events.models.User;
import com.reinahandal.events.repositories.CommentRepository;
import com.reinahandal.events.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	CommentRepository commentRepo;
	
	// creates event
	public Event createEvent(Event e) {
		return eventRepo.save(e);
	}
	
	// updates event
	public Event updateEvent(Event e) {
		return eventRepo.save(e);
	}
	
	// deletes event 
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
    // returns all events
    public ArrayList<Event> allEvents() {
        return (ArrayList<Event>) eventRepo.findAll();
    }
    
    // retrieves a event
    public Event findEvent(Long id) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
    
    // join event
    public Event joinEvent(User u, Event e) {
    	List<User> attendees = e.getAttendees();
    	if(!attendees.contains(u)) {
    		attendees.add(u);
    		e.setAttendees(attendees);
    		return eventRepo.save(e);	
    	} else {
    		return eventRepo.save(e);	   		
    	}
    }

    // leave event
    public Event leaveEvent(User u, Event e) {
    	List<User> attendees = e.getAttendees();
    	attendees.remove(u);
    	e.setAttendees(attendees);
    	return eventRepo.save(e);
    }
    
    // creates new comment
    public Comment addComment(Comment c) {
    	return commentRepo.save(c);
    }
    
    // events in my state
    public List<Event> findEventsInMyState(State s){
    	return eventRepo.findAllByState(s);
    }
    
    // events in other states
    public List<Event> findEventsInOtherStates(State s){
    	return eventRepo.findAllByStateIsNot(s);
    }
    // find event by search
    public List<Event> findEventsByName(String name){
    	return eventRepo.findAllByNameContainsIgnoreCase(name);
    }
}
