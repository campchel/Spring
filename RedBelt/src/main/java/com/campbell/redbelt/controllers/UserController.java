package com.campbell.redbelt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.campbell.redbelt.models.UserLogin;
import com.campbell.redbelt.models.User;
import com.campbell.redbelt.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



// All Routes pre-pended with "/login".
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String renderLoginReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new UserLogin());
        // require empty User() & empty LoginUser() for 2 form:form
		return "LoginReg.jsp";
	}
	
	
	// process register
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session 
			) {
		User registeredUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new UserLogin());
			return "LoginReg.jsp";
		} else {
			session.setAttribute("userId", registeredUser.getId());
			session.setAttribute("userName", registeredUser.getName());
			return "redirect:/home";
		}
      
	}
	
	
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        // Add once service is implemented:
	         User loggedUser = userService.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "LoginReg.jsp";
	        } else {
	        	session.setAttribute("userId", loggedUser.getId());
				session.setAttribute("userName", loggedUser.getName());
				return "redirect:/home";
	        }
	    
	         
	        // Store their ID from the DB in session
	    
	    }

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
        // clear session using session.invalidate()
		return "redirect:/login";
	}
}
