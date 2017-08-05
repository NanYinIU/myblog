package com.nanyin.mapper;

import com.nanyin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by NanYin on 2017-08-01 下午6:56.
 * 包名： com.nanyin.mapper
 * 类描述：mybatis mapper
 */
@Component
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Cacheable
    @Select("SELECT * FROM user Where name = #{name}")
    User selectByName(@Param("name")String name);

    @Cacheable
    @Select("SELECT * FROM user Where name = #{name}")
    List<User> validName(String name);

}
