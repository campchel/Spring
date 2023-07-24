package com.campbell.redbelt.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.campbell.redbelt.models.UserLogin;
import com.campbell.redbelt.models.User;
import com.campbell.redbelt.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	if(optionalUser.isPresent()) {
    		result.reject("not found", "This email is already registered!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "matches", "Password and confrim password must match.");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
        // 2. if the email is present , reject
        // Reject if password doesn't match confirmation
        // if result has errors, return 
        // Hash and set password, save user to database  
      
    }
        
    
    public User login(UserLogin newLogin, BindingResult result) {
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	if(optionalUser.isEmpty()) {
    		result.reject("not found", "This email is not registered.");
    		return null;
    	}
    	User user = optionalUser.get();
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password.");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	return user;
    	
    }
    
    public User getUser(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	return optionalUser.isPresent() ? optionalUser.get() : null;
    	
    }
    
}

