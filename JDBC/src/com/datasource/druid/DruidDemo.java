package com.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo
{
    public static void main(String[] args) throws Exception
    {
        //1.加载配置文件
        Properties prop = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);

        //2.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        //3.获取连接
        Connection connection = ds.getConnection();
    }
}
