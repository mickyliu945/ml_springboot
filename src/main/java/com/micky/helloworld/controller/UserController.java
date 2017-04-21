package com.micky.helloworld.controller;

import com.micky.helloworld.mapper.UserMapper;
import com.micky.helloworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    @RequestMapping("/addUser")
    public void addUser(String name, int sex, String nickName) {
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setNickName(nickName);
        userMapper.save(user);
    }

    @RequestMapping("/deleteUser/{name}/{nickName}")
    public void deleteUser(@PathVariable String name, @PathVariable String nickName) {
        userMapper.delete(name, nickName);
    }
}
