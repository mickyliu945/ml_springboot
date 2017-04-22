package com.micky.helloworld.controller;

import com.micky.helloworld.mapper.UserMapper;
import com.micky.helloworld.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation(value = "获取所有用户")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "用户性别", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "nickName", value = "用户昵称", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST, RequestMethod.GET})
    public void addUser(String name, int sex, String nickName) {
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setNickName(nickName);
        userMapper.save(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户姓名或昵称删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "nickName", value = "用户昵称", required = true, dataType = "String", paramType = "path")
    })
    @RequestMapping(value = "/deleteUser/{name}/{nickName}", method = {RequestMethod.POST, RequestMethod.GET})
    public void deleteUser(@PathVariable String name, @PathVariable String nickName) {
        userMapper.delete(name, nickName);
    }
}
