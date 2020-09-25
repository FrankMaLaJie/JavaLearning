package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2
{
    public static void main(String[] args)
    {
//        1. account表 添加一条记录

        Statement statement = null;
        Connection connection = null;

        try
        {
            //1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 定义sql
            String sql = "insert into account values(null, 'wangwu', 3000)";
            //3.获取Connection对象
            connection = DriverManager.getConnection
                    ("jdbc:mysql:///pratice?serverTimezone=UTC", "root", "123456");
            //4.获取执行sql的对象 Statement
            statement = connection.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);//影响的行数
            //6.处理结果
            System.out.println(count);
            if (count > 0)
            {
                System.out.println("添加成功");
            }
            else
            {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            //7.释放资源
            //避免空指针
            if (statement != null)
            {
                try
                {
                    statement.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            if (connection != null)
            {
                try
                {
                    connection.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
