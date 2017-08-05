package com.nanyin;

import com.nanyin.entity.User;
import com.nanyin.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by NanYin on 2017-07-31 下午12:58.
 * 包名： com.nanyin
 * 类描述：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        User user = new User();

        System.out.println("第一次查询");
        User u = userMapper.selectByName("nanyin");
        System.out.println("第二次查询");
        User u1 = userMapper.selectByName("nanyin");
        Assert.assertEquals(23, u.getAge());
    }
}
