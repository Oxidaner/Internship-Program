package com.web.javaweb.student.dao.impl;

import com.web.javaweb.student.dao.AdminDao;
import com.web.javaweb.student.javabean.entity.AdminDO;
import com.web.javaweb.student.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 19:52
 * @Description: com.web.javaweb.student.dao.impl
 * @version: 1.0
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public AdminDO validateLogin(String userName) {
    /*进行数据库操作*/
    /*获取连接*/
        Connection conn = DBUtil.getConn();
        if (conn == null){
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from admin where user_name = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setObject(1,userName);
            //打印最终执行的sql语句
            System.out.println("validateLogin执行的sql:"+ ps.toString());
            rs = ps.executeQuery();
            if(rs.next()){
                int id =  rs.getInt("id");
                String pwd = rs.getString("pwd");
                AdminDO adminDO = new AdminDO();
                adminDO.setId(id);
                adminDO.setUser_name(userName);
                adminDO.setPwd(pwd);
                return adminDO;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConn(conn);
        }
        return null;
    }
}
