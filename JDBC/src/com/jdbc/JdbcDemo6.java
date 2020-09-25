package com.jdbc;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo6
{
    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;

        try
        {
            //1.获取连接
            connection = JDBCUtils.getConnection();

            //开启事务
            connection.setAutoCommit(false);

            //2.定义sql语句，不能使用字符串拼接，使用?作为占位符
            //2.1   张三-500
            //2.2   李四-500
            String sqlAdd = "update account set balance = balance + ? where id = ?";
            String sqlSub = "update account set balance = balance - ? where id = ?";

            //3.获取执行sql对象
            preparedStatement1 = connection.prepareStatement(sqlAdd);
            preparedStatement2 = connection.prepareStatement(sqlSub);

            //4.给?赋值
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,1);

            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);

            //5.执行sql语句
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            //提交事物
            connection.commit();

        } catch (Exception e)
        {
            //捕捉异常的同时让事务回滚
            try
            {
                if (connection != null)
                {
                    connection.rollback();
                }
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(preparedStatement1, connection);
            JDBCUtils.close(preparedStatement2,null);
        }
    }
}
