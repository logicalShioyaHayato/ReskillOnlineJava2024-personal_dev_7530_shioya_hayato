package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Post;
import com.example.demo.model.Account;
import com.example.demo.repository.PostRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SnsController {
	
	@Autowired
	Account account;
	@Autowired
	PostRepository postRepository;
//	@Autowired
//	PostList postList;
	@Autowired
	HttpSession session;
	
	@GetMapping("/sns")
	public String index(Model model) {
		List<Post> postList = postRepository.findAll();
		model.addAttribute("posts",postList);
		return "sns";
	}
	//登録画面を表示する処理
	@GetMapping("/sns/post")
	public String newPost() {
		return "newPost";
	}
	
@PostMapping("/sns/post")
public String posts(
		@RequestParam("message")String message,Model model) {
	//入力確認
	if(message.length() ==0) {
		model.addAttribute("error","投稿内容を入力してください");
	    return"newPost";
	}
	    
	if(message.length() >140) {
			model.addAttribute("error","ポスト制限は140字以内です");
		    return"newPost";
	}
	//acciunt.javaからゆーざーidとなるidを取得
	Integer userId = account.getId();
	
	//ユーザーidとmessageをエンティティにセット
	Post post = new Post(userId,message);
	
	//エンティティを登録
	postRepository.save(post);
    return "redirect:/sns";
    }


    @PostMapping("/sns/{id}/delete")
    public String deletePost(@PathVariable("id") Integer id ,Model model) {
        postRepository.deleteById(id);
        return "redirect:/sns"; 
    }
    //削除確認画面を登録する処理
	@PostMapping("/sns/{id}/deleteConfirm")
	public String deleteConfirm(
			@PathVariable("id")Integer postId,
            @RequestParam("message")String message,
			Model model) {
		Post post = new Post(postId,account.getId(),message);
		model.addAttribute("post",post);
		return "deleteConfirm";
	}
}

