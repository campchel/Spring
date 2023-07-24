package com.campbell.redbelt.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class UserLogin {
	
	// LoginUser model won't be stored. It is for databinding in login

   
	
	 // 1. Attributes
    // - required fields:  email, password
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=250, message="Password must be between 8 and 250 characters")
    private String password;

    
    // 2. zero-argument constructors "()"
    // 3. getters/setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
