package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * 1.抽取注册驱动
 * 2.抽取一个方法获取连接对象
 * 3.抽取一个方法释放资源
 */

public class JDBCUtils
{
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只需要读取一次就可以拿到这些值，使用静态代码块
     */
    static
    {
        //读取资源文件，获取值

        try
        {
            //1.创建Properties集合类
            Properties prop = new Properties();

            //获取src路径下的文件的方式----->ClassLoader
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //URL：统一资源定位符，定位一个文件的绝对路径
            URL resource = classLoader.getResource("jdbc.properties");
            //如果路径中有文件夹或者文件的名称中含有空格，调用toURI()方法解决
            String path = resource.toURI().getPath();
            //System.out.println(path);

            //2.加载文件
            prop.load(new FileReader(path));

            //3.获取数据，复制
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            //4.注册驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException | URISyntaxException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection)
    {
        if (statement != null)
        {
            try
            {
                statement.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
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

    }

    /**
     * 释放资源
     *
     * @param statement
     * @param connection
     * @param resultSet
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet)
    {
        if (statement != null)
        {
            try
            {
                statement.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
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

}
