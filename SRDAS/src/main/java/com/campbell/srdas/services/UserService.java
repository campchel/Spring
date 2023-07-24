package com.campbell.srdas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.campbell.srdas.models.User;
import com.campbell.srdas.repositories.RoleRepository;
import com.campbell.srdas.repositories.UserRepository;

@Service
public class UserService {
	 private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	    
	    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	    
	    
	    // 1
	    public void saveWithUserRole(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(roleRepository.findByName("ROLE_USER"));
	        userRepository.save(user);
	    }
	     
	     // 2 
	    public void saveUserWithAdminRole(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
	        userRepository.save(user);
	    }    
	    
	    // 3
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
	    public List<User> allUsers(){
	    	return userRepository.findAll();
	    }
	    
	    public void updateUser(User user) {
	    	userRepository.save(user);
		}
	    
	    public User upgradeUser(User user) {
			user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
			return userRepository.save(user);
		}
		
		public void deleteUser(User user) {
			userRepository.delete(user);
		}
	    
	    public User findById(Long id) {
	    	Optional<User> potentialUser = userRepository.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	return null;
	    }
}