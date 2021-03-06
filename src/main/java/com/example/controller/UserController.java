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

    @ApiOperation(value="查找用户", notes="根据用户的电子邮箱来指定删除对象")
    @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String")
    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam(value = "email") String email){
        return userMapper.findByEmail(email);
    }

    @ApiOperation(value="创建用户", notes="根据姓名和电子邮箱创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "password")
    })
     @GetMapping("/add")
    public int add(@RequestParam(value = "name") String name
            ,@RequestParam(value = "email") String email,@RequestParam(value = "password") String password){
        User u = new User(name,email,password);
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
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @GetMapping("/update")
    public int update(@RequestParam(value = "id") Integer id
            ,@RequestParam(value = "name",required = true) String name
            ,@RequestParam(value = "email",required = true) String email
            ,@RequestParam(value = "password",required = true) String password){
        User u = new User(name,email,password);
        u.setId(id);
        return userMapper.update(u);
    }

    @ApiOperation(value="更新密码", notes="根据电子邮箱、旧密码、新密码来更新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    @GetMapping("/updatePassword")
    public int updatePassword(@RequestParam(value = "email") String email
            ,@RequestParam(value = "oldPassword") String oldPassword
                            ,@RequestParam(value = "newPassword") String newPassword){
        User u = userMapper.findByEmail(email);
        if(u.getPassword().equals(oldPassword)){
            u.setPassword(newPassword);
            return userMapper.updatePassword(u);
        }else{
            return 0;
        }
    }

}
