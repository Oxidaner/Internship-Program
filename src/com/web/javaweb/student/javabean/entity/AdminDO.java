package com.web.javaweb.student.javabean.entity;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 19:34
 * @Description: com.web.javaweb.student.javabean.entity
 * @version: 1.0
 */
public class AdminDO {
    /*对应Admin表*/
    private int id;
    private String user_name;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
