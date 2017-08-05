package com.nanyin.entity;

/**
 * Created by NanYin on 2017-08-04 下午10:54.
 * 包名： com.nanyin.entity
 * 类描述：
 */
public class Resource {
//    资源id
    int id;
//    资源名称
    String name;
//    资源状态（1,0）
    int status;
//    资源地址
    String address;
//    来源 比如 百度云盘
    String source;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
