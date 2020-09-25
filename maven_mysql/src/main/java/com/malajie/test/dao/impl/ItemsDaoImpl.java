package com.malajie.test.dao.impl;

import com.malajie.test.dao.ItemsDao;
import com.malajie.test.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao
{
    public List<Items> findAll() throws SQLException, ClassNotFoundException
    {
        List<Items> list = new ArrayList<Items>();
        //先获取connection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet resultSet = null;

        try
        {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///ds?useUnicode=true&characterEncoding=utf8","root","123456");

            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from users");

            //执行数据库查询操作
            resultSet = pst.executeQuery();

            //把数据库结果集转成java的List集合
            while (resultSet.next())
            {
                Items items = new Items();
                items.setName(resultSet.getString("id"));
                items.setPassword(resultSet.getString("password"));
                list.add(items);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            connection.close();
            pst.close();
            resultSet.close();

        }

        return list;
    }

}
