package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Integer id);
    User findByEmail(String email);
    List<User> findAll();
//    int add(String name,String email);

    int add(User u);
    int delete(Integer id);
    int update(User u);
    int updatePassword(User u);
}
