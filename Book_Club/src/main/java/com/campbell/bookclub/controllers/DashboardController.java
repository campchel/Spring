package com.campbell.bookclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.campbell.bookclub.models.Book;
import com.campbell.bookclub.models.User;
import com.campbell.bookclub.models.UserLogin;
import com.campbell.bookclub.services.BookService;
import com.campbell.bookclub.services.UserService;
import jakarta.servlet.http.HttpSession;


@Controller
public class DashboardController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books") 
	public String Dashboard(Model model, HttpSession session) {
		// Getting User Id
		if(session.getAttribute("userId") == null) {
			// If not logged in, redirect to the login page
			return "redirect:/login";
		} 
//		if statement needs to render back to login when null to prevent hacking
		model.addAttribute("loggedInUser", userService.getUser((Long)session.getAttribute("userId")));
		model.addAttribute("bookList", bookService.allBooks());
			return "Dashboard.jsp";
	}
//The userService "string" model attribute is used to pass in a name on a jsp
}
