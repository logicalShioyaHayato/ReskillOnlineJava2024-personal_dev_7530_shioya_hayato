package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SnsController {
	@GetMapping("/sns")
	public String index() {
		return "sns";
	}
	
	@GetMapping("/sns/post")
	public String newPost() {
		return "";
	}
		
	@PostMapping("/sns/post")
	public String addPost() {
		return "";
	}


    @PostMapping("/sns[id]/delet")
    public String delete() {
 	    return "";

}
}