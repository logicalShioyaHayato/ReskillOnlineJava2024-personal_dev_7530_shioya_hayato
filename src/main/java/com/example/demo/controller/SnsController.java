package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Post;
import com.example.demo.model.PostList;
import com.example.demo.repository.PostRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SnsController {
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	PostList postList;
	@Autowired
	HttpSession session;
	
	@GetMapping("/sns")
	public String index() {
		return "sns";
	}
	
	@GetMapping("/sns/post")
	public String newPost() {
		session.invalidate();
		return "newPost";
	}
	
@PostMapping("/sns/post")
public String posts(
		@RequestParam("title")String title,
		@RequestParam("content")String content) {
	List<Post>allPosts = postList.getPosts();
		allPosts.add(new Post(title,content));
    return "redirect:/sns"; }

    @PostMapping("/sns/{id}/delete")
    public String deletePost(@PathVariable("id") Integer id ,Model model) {
        postRepository.deleteById(id);
        return "redirect:/sns"; 
    }
}

