package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ha.selector.DataSourceSelectorFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */

public class DruidUtils
{
    //1.定义成员变量 DataSource
    private static DataSource ds;

    /**
     * 加载配置文件
     */
    static
    {
        try
        {
            //2.加载配置文件
            Properties prop = new Properties();
            prop.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //3.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }

    /**
     * 归还连接
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection)
    {
        close(statement, connection, null);
    }

    /**
     * 归还连接
     * @param statement
     * @param connection
     * @param resultSet
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet)
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        if (connection != null)
        {
            try
            {
                connection.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

}
