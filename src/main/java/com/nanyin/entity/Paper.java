package com.nanyin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * Created by NanYin on 2017-08-02 下午7:02.
 * 包名： com.nanyin.entity
 * 类描述：
 */
public class Paper {
//    文章的id
    private int id;

    private String b_name;
//  文章的创建时间
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp b_time;
//  具体内容
    private String content;
//  时间推移--标记的顺序
    private int mark;

    private String image_route;
//  文章的标签
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Timestamp getB_time() {
        return b_time;
    }

    public void setB_time(Timestamp b_time) {
        this.b_time = b_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getImage_route() {
        return image_route;
    }

    public void setImage_route(String image_route) {
        this.image_route = image_route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", b_name='" + b_name + '\'' +
                ", b_time=" + b_time +
                ", content='" + content + '\'' +
                ", mark=" + mark +
                ", image_route='" + image_route + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
