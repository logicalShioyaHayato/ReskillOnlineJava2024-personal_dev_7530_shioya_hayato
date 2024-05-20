package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope


public class Account {
    private Integer id;
    private String name;
    private String email; // 新しいemailプロパティを追加

    public Account() {
    }

    // 既存のコンストラクタ
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email; // 新しいgetEmailメソッドを追加
    }

    public void setEmail(String email) {
        this.email = email; // 新しいsetEmailメソッドを追加
    }
}
