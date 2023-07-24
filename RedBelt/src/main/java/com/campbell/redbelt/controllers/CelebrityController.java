package com.campbell.redbelt.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.campbell.redbelt.models.Celebrity;
import com.campbell.redbelt.services.CelebrityService;
import com.campbell.redbelt.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class CelebrityController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CelebrityService celebrityService;
	
		@GetMapping("/celebrities/new")
		public String renderCelebrityForm(Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				// If not logged in, redirect to the login page
				return "redirect:/login";
//				if statement needs to render back to login when null to prevent hacking	
			}
			model.addAttribute("newCelebrity", new Celebrity());
			return "NewCelebrity.jsp";
	}
	
	
		//Create
		// process form
		@PostMapping("/celebrities/new")
		public String processCelebrityForm(
				@Valid @ModelAttribute("newCelebrity") Celebrity newCelebrity, BindingResult result, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				// If not logged in, redirect to the login page
				return "redirect:/login";
//				if statement needs to render back to login when null to prevent hacking	
			}
			if(result.hasErrors()) {
				return "NewCelebrity.jsp";
			} else {
				celebrityService.createCelebrity(newCelebrity);
				return "redirect:/home";
			}
		}
			
		
		// 	Rendering Details for one Celebrity
		//  Celebrity Details
		@GetMapping("/celebrities/{id}")
		public String Details(@PathVariable("id")Long id, Model model) {
			
			model.addAttribute("celebrity", celebrityService.oneCelebrity(id));
			return "Details.jsp";
		}
		
		
		// EDIT =================
		
		// Process the Edit form
		@PutMapping("/celebrities/{id}/edit")
		public String processEdit(@Valid @ModelAttribute("celebrity") Celebrity celebrity,
				BindingResult result) {
			if(result.hasErrors()) {
				return "Edit.jsp";
			} else {
				celebrityService.updateCelebrity(celebrity);
				return "redirect:/home";
			}
		}
		
		@RequestMapping("/celebrities/{id}/edit")
	    public String showEditForm(@PathVariable("id")Long id, Model model) {
	        // Create the 'celebrity' object and add it to the model
	        Celebrity celebrity = celebrityService.oneCelebrity(id);
	        model.addAttribute("celebrity", celebrity);
	        return "Edit.jsp";
	    }
		
//		 Edit
//		 Render the form
//		@GetMapping("/celebrities/{id}/edit")
//		public String renderEdit(@PathVariable("id")Long id, Model model, HttpSession session) {
//			celebrityService.oneCelebrity(id);
//			model.addAttribute("book", celebrityService.oneCelebrity(id));
//			model.addAttribute("editor", userService.getUser((Long)session.getAttribute("userId")));
//			return "Edit.jsp";
//		}
		
		
		
		
		// Delete Book 
		@DeleteMapping("/celebrities/{id}")
		public String processDelete(@PathVariable("id") Long id) {
			celebrityService.deleteCelebrityById(id);
			return "redirect:/home";
		}
}

