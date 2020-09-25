package com.jdbc;

import java.sql.*;

public class JdbcDemo
{
    public static void main(String[] args) throws Exception
    {
        //导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql:///pratice?serverTimezone=UTC", "root", "123456");
        //4.定义sql语句
        String sql = "update account set balance = 2000 where id = 1";
        //5.获取执行sql的对象 Statement
        Statement statement = connection.createStatement();
        //6.执行sql
        int count = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        connection.close();

    }
}
