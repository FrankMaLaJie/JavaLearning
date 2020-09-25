package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo3
{
    public static void main(String[] args)
    {
        /*
			2. account表 修改记录
        */
        Statement statement = null;
        Connection connection = null;

        try
        {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            connection = DriverManager.getConnection
                    ("jdbc:mysql:///pratice?serverTimezone=UTC", "root", "123456");
            //3.定义sql语句
            String sql = "update account set balance = 1500 where id = 3";
            //4.获取执行sql语句的对象
            statement = connection.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count>0){
                System.out.println("修改成功");
            }
            else {
                System.out.println("修改失败");
            }
            //7.释放资源
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            if (statement != null){
                try
                {
                    statement.close();
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
            }

            if (connection !=null){
                try
                {
                    connection.close();
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
