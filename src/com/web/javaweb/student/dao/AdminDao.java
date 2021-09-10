package com.web.javaweb.student.dao;

import com.web.javaweb.student.javabean.entity.AdminDO;

import java.sql.SQLException;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 19:50
 * @Description: com.web.javaweb.student.dao
 * @version: 1.0
 */
public interface AdminDao {
    AdminDO validateLogin(String userName)  ;


}
