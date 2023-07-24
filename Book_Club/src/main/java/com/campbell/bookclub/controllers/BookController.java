package com.campbell.bookclub.controllers;

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

import com.campbell.bookclub.models.Book;
import com.campbell.bookclub.models.User;
import com.campbell.bookclub.models.UserLogin;
import com.campbell.bookclub.services.BookService;
import com.campbell.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class BookController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
		@GetMapping("/books/new")
		public String renderBookForm(Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				// If not logged in, redirect to the login page
				return "redirect:/login";
//				if statement needs to render back to login when null to prevent hacking	
			}
			model.addAttribute("newBook", new Book());
			return "NewBook.jsp";
	}
	

		
		//Create Book
		// process form
		@PostMapping("/books/new")
		public String processBookForm(
				@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
			if(result.hasErrors()) {
				return "NewBook.jsp";
			} else {
				bookService.createBook(newBook);
				return "redirect:/books";
			}
		}
			
		
		// 	Rendering Details for one Book
		//  Book Details
		@GetMapping("/books/{id}")
		public String Details(@PathVariable("id")Long id, Model model) {
			model.addAttribute("book", bookService.oneBook(id));
			return "Details.jsp";
		}
		
		
		// EDIT =================
		
		// Process the Edit form
		@PutMapping("/books/{id}/edit")
		public String processEdit(@Valid @ModelAttribute("book") Book book,
				BindingResult result) {
			if(result.hasErrors()) {
				return "Edit.jsp";
			} else {
				bookService.updateBook(book);
				return "redirect:/books";
//				return "redirect:/books/"+ updatedBook.getId();
			}
		}
		
		
		
//		 Edit
//		 Render the form
		@GetMapping("/books/{id}/edit")
		public String renderEdit(@PathVariable("id")Long id, Model model, HttpSession session) {
			bookService.oneBook(id);
			model.addAttribute("book", bookService.oneBook(id));
			model.addAttribute("editor", userService.getUser((Long)session.getAttribute("userId")));
			return "Edit.jsp";
		}
		
		
		
		
		// Delete Book 
		@DeleteMapping("/books/{id}")
		public String processDelete(@PathVariable("id") Long id) {
			bookService.deleteBookById(id);
			return "redirect:/books";
		}
}
