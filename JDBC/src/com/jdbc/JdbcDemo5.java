package com.jdbc;

import com.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        boolean login = new JdbcDemo5().login2(username, password);
        if (login)
        {
            System.out.println("登陆成功！");
        }
        else
        {
            System.out.println("用户或密码输入错误！");
        }


    }

    /**
     * 登陆方法
     */
    public boolean login(String username, String password)
    {
        if (username == null || password == null)
        {
            return false;
        }
        //连接数据库判断是否成功
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2.定义sql语句
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";

            //3.获取执行sql对象
            statement = connection.createStatement();

            //4.执行sql语句
            resultSet = statement.executeQuery(sql);

            //5.只需要判断结果集有没有数据
            return resultSet.next();//如果有下一行，返回true
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtils.close(statement, connection, resultSet);
        }

        return false;
    }

    /**
     * 登陆方法,使用preparedStatement
     */
    public boolean login2(String username, String password)
    {
        if (username == null || password == null)
        {
            return false;
        }
        //连接数据库判断是否成功
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //2.定义sql语句，不能使用字符串拼接，使用?作为占位符
            String sql = "select * from user where username = ? and password = ?";

            //3.获取执行sql对象
            preparedStatement = connection.prepareStatement(sql);

            //4.给?复制
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //5.执行sql语句，不需要传递sql语句
            resultSet = preparedStatement.executeQuery();

            //6.只需要判断结果集有没有数据
            return resultSet.next();//如果有下一行，返回true
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            JDBCUtils.close(preparedStatement, connection, resultSet);
        }

        return false;
    }

}
