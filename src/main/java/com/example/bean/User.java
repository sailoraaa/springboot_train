package com.example.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;


@ApiModel(description = "用户数据")
public class User {
    @ApiModelProperty(value = "用户ID",example = "123")
    private int id;
    @ApiModelProperty(value = "用户姓名",example = "张三")
    private String name;
    @ApiModelProperty(value = "电子邮箱",example = "111@qq.com")
    private String email;
    @ApiModelProperty(value = "角色",example = "角色")
    private Set<Role> roles;
    @ApiModelProperty(value = "密码",example = "12345678aA")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User(int id, String name, String email, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles=roles;
    }


    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


}

