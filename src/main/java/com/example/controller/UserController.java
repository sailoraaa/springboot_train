package com.example.controller;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @ApiOperation(value="查找用户", notes="根据用户的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")
    @GetMapping("/findById")
    public User findById(@RequestParam(value = "id") Integer id){
        return userMapper.findById(id);
    }

    @ApiOperation(value="创建用户", notes="根据姓名和电子邮箱创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String")
    })
     @GetMapping("/add")
    public int add(@RequestParam(value = "name") String name
            ,@RequestParam(value = "email") String email){
        User u = new User(name,email);
        return userMapper.add(u);
    }

    @ApiOperation(value="删除用户", notes="根据用户的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/delete")
    public int delete(@RequestParam(value = "id") Integer id){
        return userMapper.delete(id);
    }

    @ApiOperation(value="更新用户", notes="根据id来更新用户的姓名或电子邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String")
    })
    @GetMapping("/update")
    public int update(@RequestParam(value = "id") Integer id
            ,@RequestParam(value = "name",required = true) String name
            ,@RequestParam(value = "email",required = true) String email){
        User u = new User(name,email);
        u.setId(id);
        return userMapper.update(u);
    }
}
