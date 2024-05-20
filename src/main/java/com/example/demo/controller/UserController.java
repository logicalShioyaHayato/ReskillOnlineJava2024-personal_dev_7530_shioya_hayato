package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping({"/login","/","/logout"})
	public String userIndex() {
	session.invalideta();
	return "login";//test
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		if(email.length() ==0 || password.length() ==0) {
			model.addAttribute("message","入力してください");
		    return"login";
		}
		
		List<User> userList = userRepository.findByEmailAndPassword(email,password);
		if (userList == null || userList.size() == 0) {
			model.addAttribute("message","メールアドレスとパスワードが一致しません");
			return"login";
		}
		User user = userList.get(0);
		account.setId(user.getId());
		account.setName(user.getName());
		return"redirect:/sns";
//master branch
	}
}
