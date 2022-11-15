package com.reinahandal.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.reinahandal.events.models.Comment;
import com.reinahandal.events.models.Event;
import com.reinahandal.events.models.State;
import com.reinahandal.events.models.User;
import com.reinahandal.events.services.EventService;
import com.reinahandal.events.services.UserService;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	//renders home page with form to add event
	@GetMapping("/events")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/";
    	} else {
    		User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
    		State s = thisUser.getState();
    		model.addAttribute("eventsMyState", eventService.findEventsInMyState(s));
    		model.addAttribute("eventsOtherStates", eventService.findEventsInOtherStates(s));
    		return "index.jsp";		
    	}
	}

	// processes form to create new event
	@PostMapping("/events")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
    		User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
    		State s = thisUser.getState();
    		model.addAttribute("eventsMyState", eventService.findEventsInMyState(s));
    		model.addAttribute("eventsOtherStates", eventService.findEventsInOtherStates(s));			
    		return "index.jsp";
		} else {
			eventService.createEvent(event);
			return "redirect:/events";
		}
	}	
	
	// renders form for editing event
	@GetMapping("/events/{id}/edit")
	public String editEvent(HttpSession session, @PathVariable("id") Long eventId, Model model) {
		if((Long) session.getAttribute("userId") != null) {
			if(session.getAttribute("userId") == eventService.findEvent(eventId).getHost().getId()) {
				model.addAttribute("event", eventService.findEvent(eventId));
				return "editevent.jsp";	
			} else {
				return "redirect:/events";
			}
			
		} else {
			return "redirect:/";
		}
	}
	
	// processes form that updates event
	@PutMapping("/events/{id}/edit")
	public String updateEvent(@PathVariable("id") Long eventId, Model model, @Valid @ModelAttribute("event") Event event, BindingResult result) {
		if(result.hasErrors()) {
			return "editevent.jsp";
		} else {
			eventService.updateEvent(event);
			return "redirect:/events/"+eventId;
		}
	}

	// deletes event
	@DeleteMapping("/events/{id}")
	public String destroy(@PathVariable("id") Long eventId, HttpSession session) {
		if((Long) session.getAttribute("userId") == eventService.findEvent(eventId).getHost().getId()) {
			eventService.deleteEvent(eventId);
			return "redirect:/events"; 		
		} else {
			return "redirect:/events/"+eventId;
		}
	}
	
	// renders page with event details and comment wall
	@GetMapping("/events/{eventId}")
	public String showEvent(
			@PathVariable("eventId") Long eventId, 
			Model model, 
			HttpSession session,
			@ModelAttribute("comment") Comment comment) {
    	if (session.getAttribute("userId") != null) {
    		model.addAttribute("event", eventService.findEvent(eventId));
    		User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
    		Event thisEvent = eventService.findEvent(eventId);
    		Boolean isAttending = null;
    		if (thisEvent.getAttendees().contains(thisUser)){
    			isAttending = true;
    		} else {
    			isAttending = false;
    		}
    		model.addAttribute("userIsAttendee", isAttending);
    		return "showevent.jsp";
    	} else {
    		return "redirect:/";
    	}
	}
	
	
	// adds comment to event 
	@PostMapping("/events/{eventId}/comment")
	public String newComment(
			@PathVariable("eventId") Long eventId,
			@Valid @ModelAttribute("comment") Comment comment,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
    		model.addAttribute("event", eventService.findEvent(eventId));
			return "showevent.jsp";
		} else {
			eventService.addComment(comment);
			return "redirect:/events/"+eventId;
		}
	}
	
	// adds user to event as attendee
	@PostMapping("/join/{id}")
	public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
		if((Long) session.getAttribute("userId") != null && (Long) session.getAttribute("userId") != eventService.findEvent(eventId).getHost().getId()) {
			Event thisEvent = eventService.findEvent(eventId);
			User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
			eventService.joinEvent(thisUser, thisEvent);
			return "redirect:/events/"+eventId;
		} else {
			return "redirect:/events/"+eventId;
		}
	}
	
	// removes user from event as attendee
	@PostMapping("/leave/{id}")
	public String leaveEvent(@PathVariable("id") Long eventId, HttpSession session) {
		if((Long) session.getAttribute("userId") != null && (Long) session.getAttribute("userId") != eventService.findEvent(eventId).getHost().getId()) {
			Event thisEvent = eventService.findEvent(eventId);
			User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
			eventService.leaveEvent(thisUser, thisEvent);
			return "redirect:/events/"+eventId;
		} else {
			return "redirect:/events/"+eventId;
		}
	}
		
}
