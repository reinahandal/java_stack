package com.reinahandal.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.reinahandal.authentication.models.LoginUser;
import com.reinahandal.authentication.models.User;
import com.reinahandal.authentication.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    // method that is implemented when user sends registration form
    public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
        	result.rejectValue("email", "Unique", "This email is already registered");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            // Exit the method and go back to the controller 
            // to handle the response
            return null;
        }
        else {
        	// hash password 
        	// set user password to hashed password
        	// save (create) the new user
        	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        	newUser.setPassword(hashed);
        	return userRepo.save(newUser);
        }
    }
    // method that is implemented when user sends login form
    public User login(LoginUser newLogin, BindingResult result) {
        // why do we do this twice???
    	if(result.hasErrors()) {
            return null;
        }
    	// finds user by email and assigns to Optional wrapper class
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	// if user/email doesnt exist it sends an error
    	if (!potentialUser.isPresent()){
    		result.rejectValue("email", "Unique", "This email is not registered!");
    		return null;
    	}
    	// else it gets user and checks password
    	User user = potentialUser.get();
    	// if hashed password doesnt match hashed password in DB it sends an error
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Password is incorrect!");
    	    return null;
    	}
        if(result.hasErrors()) {
            return null;
        } else {
        	// if there are no errors it returns user instance
        	return user;
        }
    }
    
    public User findUserById(Long userId) {
    	Optional<User> thisUser = userRepo.findById(userId);
    	if (thisUser.isPresent()) {
    		return thisUser.get();
    	}
    	else {
    		return null ;
    	}
    }
}
