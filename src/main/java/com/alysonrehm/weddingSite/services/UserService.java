package com.alysonrehm.weddingSite.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.alysonrehm.weddingSite.models.LoginUser;
import com.alysonrehm.weddingSite.models.User;
import com.alysonrehm.weddingSite.respositories.UserRepo;


@Service
public class UserService {

	 @Autowired
	    private UserRepo userRepo;
	    
	    //FIND BY ID
	    public User findById(Long id) {
	    	Optional<User>potentialUser = userRepo.findById(id);
	    	if(potentialUser.isPresent()) {
	    	return potentialUser.get();
	    	}
	    	return null;
	    }
	   
	    //REGISTER
	    public User register(User newUser, BindingResult result) {        
	        // Reject if email is taken (present in database)
	    	Optional<User> registerUser = userRepo.findByEmail(newUser.getEmail());
	    	if (registerUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "An Account with this email already exists");
	    	}
	    	
	        // Reject if password doesn't match confirmation
	    	if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
	    	    result.rejectValue("confirm", "Matches", "Passwords must match!");
	    	}

	        // Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	        // Hash and set password, save user to database
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	newUser.setPassword(hashed);
	    	return userRepo.save(newUser);
	    }
	    
	    //LOGIN
	    public User login(LoginUser newLoginUser, BindingResult result) {
	    	// Find user in the DB by email
	        // Reject if NOT present
	    	Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
	    	if(!potentialUser.isPresent()) {
	    		result.rejectValue("email","Matches", "User is not found");
	    		return null;
	    	}
	    	User user = potentialUser.get();    
	    	
	        // Reject if BCrypt password match fails
	  
	    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
	    		result.rejectValue("password", "Matches", "Your password is invalid");
	    	}
	        // Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	        // Otherwise, return the user object
	        return user;
	    }
}
