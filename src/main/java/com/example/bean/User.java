package com.example.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;


@ApiModel(description = "用户数据")
public class User {
    @ApiModelProperty(value = "用户ID",example = "123")
    private int id;
    @ApiModelProperty(value = "用户姓名",example = "张三")
    private String name;
    @ApiModelProperty(value = "电子邮箱",example = "111@qq.com")
    private String email;

    public User(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

