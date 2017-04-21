package com.micky.helloworld.mapper;

import com.micky.helloworld.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
public interface UserMapper {
    List<User> getAll();

    void save(User user);

    void delete(@Param("name") String name, @Param("nickName") String nickName);
}
