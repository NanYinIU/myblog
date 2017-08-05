package com.nanyin;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

/**
 * Created by NanYin on 2017-08-02 下午9:35.
 * 包名： com.nanyin
 * 类描述：
 */
public class Test {
    @org.junit.Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
    }
    @org.junit.Test
    public void test2(){
        String s = "123";
        String h =  Base64Utils.encodeToString(s.getBytes());
        byte[] x = Base64Utils.encode(s.getBytes());
        String h2 = x.toString();
        System.out.println(x);
        System.out.println(h);
        System.out.println(h2);
        String g = Base64Utils.decodeFromString(s).toString();
        System.out.println(Base64Utils.decode(x));
        System.out.println(g);

    }
@org.junit.Test
    public void test3() throws UnsupportedEncodingException {
        String s = "ggx19950919";

        String a = Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
        System.out.println(a);

        byte[] b = Base64.getDecoder().decode(a);
        System.out.println(new String(b, "utf-8"));
    }
}
