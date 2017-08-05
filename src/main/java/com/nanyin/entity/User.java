package com.nanyin.entity;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

/**
 * Created by NanYin on 2017-08-01 下午6:48.
 * 包名： com.nanyin.entity
 * 类描述：user实体类
 */
@Component
public class User {
    /*唯一id*/
    private int id;
    /*姓名*/
    private String name;
    /*密码*/
    private String password;
    /*年龄*/
    private int age;
    /*生日*/
    private Data birthday;
    /*email地址*/
    private String email;
    /*居住地*/
    private String city;
    /*职业等*/
    private String work;
    /*等多信息向里面加*/
    private String moredetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMoredetail() {
        return moredetail;
    }

    public void setMoredetail(String moredetail) {
        this.moredetail = moredetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", work='" + work + '\'' +
                ", moredetail='" + moredetail + '\'' +
                '}';
    }
}
