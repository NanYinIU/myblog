package com.nanyin.service;

import com.nanyin.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NanYin on 2017-08-01 下午6:54.
 * 包名： com.nanyin.service
 * 类描述：
 */
@Service
public interface UserService {
    User selectByName(String name);

    List<User> validName(String name);
}
