package com.nanyin.service.serviceImpl;

import com.nanyin.entity.User;
import com.nanyin.mapper.UserMapper;
import com.nanyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NanYin on 2017-08-01 下午6:55.
 * 包名： com.nanyin.service.serviceImpl
 * 类描述：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<User> validName(String name) {
        return userMapper.validName(name);
    }
}
