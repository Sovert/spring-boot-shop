package com.qch.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Size(max = 100, message = "用户名的字符长度不能超过 {max}")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(max = 100, message = "密码的字符长度不能超过 {max}")
    @Column(nullable = false)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
