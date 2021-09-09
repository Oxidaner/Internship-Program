package com.web.javaweb.student.util;

import java.sql.*;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/9 - 09 - 09 - 23:03
 * @Description: com.web.javaweb.student.util
 * @version: 1.0
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management?serverTimezone=UTC&useSSL=false";
    //    链接URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    驱动
    private static final String USER_NAME = "root";
    private static final String PWD = "lele321584";

    /*加载驱动*/
    static {
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*获取连接*/
    public static Connection getConn(){
        try {
            return DriverManager.getConnection(URL,USER_NAME,PWD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void closeResultSet(ResultSet resultSet){
        try {
            if(resultSet != null ){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    * 关闭ps
    * */
    public static void closePs(PreparedStatement ps){
        try {
            if(ps != null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*
    * 关闭连接
    * */
    public static void closeConn(Connection Conn){
        try {
            if(Conn != null){
                Conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(DBUtil.getConn());
    }
}
