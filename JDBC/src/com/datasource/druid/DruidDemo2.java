package com.datasource.druid;

import com.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2
{
    public static void main(String[] args)
    {
        /**
         * 完成添加操作：给account表添加一条数据
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            //1.获取连接
            connection = DruidUtils.getConnection();
            //2.定义SQL
            String sql = "insert into account values(null, ?, ?)";
            //3.获取preparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            //4.给?赋值
            preparedStatement.setString(1, "liuliu");
            preparedStatement.setDouble(2, 3000);
            //5.执行SQL语句
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally
        {
            //6.释放资源
            DruidUtils.close(preparedStatement,connection);
        }
    }
}
