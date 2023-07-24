package com.campbell.dojosandninjas.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.campbell.dojosandninjas.models.Dojo;
import com.campbell.dojosandninjas.models.Ninja;
import com.campbell.dojosandninjas.services.DojoService;
import com.campbell.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
	
	//Create Dojo
	//Render form
	@GetMapping("/dojos/new")
	public String renderDojoForm(@ModelAttribute("newDojo") Dojo newDojo) {
		return "CreateDojo.jsp";
	}
	
	//Create Dojo
	// process form
	@PostMapping("/dojos/create")
	public String processDojoForm(
			@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateDojo.jsp";
		} else {
			dojoService.createDojo(newDojo);
			return "CreateDojo.jsp";
		}
	}
//	
	
	
	
	// Rendering form to Create Ninja
	@GetMapping("/ninjas/new")
	public String renderCreateNinjaForm(Model model) {
		model.addAttribute("newNinja", new Ninja());
		
		// to pick dojo (dont need this after log-reg)
		model.addAttribute("dojoList", dojoService.allDojos());
		return "CreateNinja.jsp";
	}
	
	
	//  Create Ninja   - Post data to database
	@PostMapping("/ninjas/create")
	public String processNinjaForm(
			@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateNinja.jsp";
		} else {
			Ninja ninja = ninjaService.createNinja(newNinja);
			
			return "redirect:/dojos/"+ ninja.getOwner().getId();
		}
	}
	
	// Rendering Details for one Dojo
	@GetMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		return "DojoDetails.jsp";
	}
	
}
		
