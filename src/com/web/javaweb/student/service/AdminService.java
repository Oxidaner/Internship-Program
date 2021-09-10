package com.web.javaweb.student.service;


import com.web.javaweb.student.javabean.entity.AdminDO;


/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 19:31
 * @Description: com.web.javaweb.student.servlet
 * @version: 1.0
 */
public interface AdminService {
    AdminDO validateLogin(String userName);

}
