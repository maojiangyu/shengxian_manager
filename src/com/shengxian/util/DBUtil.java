package com.shengxian.util;

import java.sql.Connection;

public class DBUtil {
    private static final String  dbUrl = "jdbc:mysql://localhost:3306/shengxian?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static final String  dbUserName = "root";
    private static final String  dbPassword = "maofu1220";

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws java.sql.SQLException{
        return java.sql.DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
    }
}
