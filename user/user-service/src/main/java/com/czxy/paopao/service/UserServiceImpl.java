package com.czxy.paopao.service;

import com.czxy.paopao.domain.User;
import org.apache.dubbo.config.annotation.Service;
import javax.annotation.Resource;
import com.czxy.paopao.mapper.UserMapper;


@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
