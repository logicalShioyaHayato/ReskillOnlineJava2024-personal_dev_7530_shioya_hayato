package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/users/new")
	public String newUser() {
		session.invalidate();
		return "newUser";
	}
	
	@PostMapping("/users/add")
	public String addUser(
		@RequestParam("name") String name,
		Model model) {

		
		return "login";

	}

	
	@GetMapping("/login")
	public String userIndex() {
	session.invalidate();
	return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		return"redirect:/sns";
	}
}
