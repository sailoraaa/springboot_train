package com.example.service.impl;

import com.example.bean.Permissions;
import com.example.bean.Role;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByEmail(getMapByName);
    }

    /**
     * 模拟数据库查询
     *
     * @param email
     * @return
     */
    private User getMapByEmail(String email) {
        User u = userMapper.findByEmail(email);
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions("1", "query");
        Permissions permissions2 = new Permissions("2", "add");

        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role(1, "admin", permissionsSet);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
//        User user = new User(1, "wsl", "123456", roleSet);
        User user = u;
        user.setRoles(roleSet);
        Map<String, User> map = new HashMap<>();
        map.put(user.getEmail(), user);

        /**
        Permissions permissions3 = new Permissions("3", "query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role(2, "user", permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User(2, "zhangsan", "123456", roleSet1);
        user1.setPassword("password123");
        map.put(user1.getName(), user1);
         **/
        return map.get(email);
    }
}