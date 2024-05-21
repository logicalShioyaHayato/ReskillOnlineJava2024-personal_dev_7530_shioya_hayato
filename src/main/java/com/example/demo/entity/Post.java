package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(name = "user_id")
private Integer userId;
private String message;

public Integer getId() {
	return id;
}
public Integer getUserId() {
	return userId;
}
public String getMessage() {
	return message;
}
public Post() {
	
}

public Post(Integer id,Integer userid, String message ) {
	this.id =id;
	this.userId = userid;
	this.message = message;

}
}
