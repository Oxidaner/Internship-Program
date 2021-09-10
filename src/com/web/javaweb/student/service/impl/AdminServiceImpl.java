package com.web.javaweb.student.service.impl;

import com.web.javaweb.student.dao.AdminDao;
import com.web.javaweb.student.dao.impl.AdminDaoImpl;
import com.web.javaweb.student.javabean.entity.AdminDO;
import com.web.javaweb.student.service.AdminService;

import java.sql.SQLException;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 19:43
 * @Description: com.web.javaweb.student.service.impl
 * @version: 1.0
 */
public class AdminServiceImpl implements AdminService {
    /*implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用 */

    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public AdminDO validateLogin(String userName) {
        return adminDao.validateLogin(userName);
    }
}
