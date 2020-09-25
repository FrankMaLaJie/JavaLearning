package com.malajie.test;

import com.malajie.test.dao.ItemsDao;
import com.malajie.test.dao.impl.ItemsDaoImpl;
import com.malajie.test.domain.Items;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/*
* 要想从数据库中取出数据，必须有四个属性
* 1.数据库驱动
* 2.连接数据库的地址
* 3.数据库用户名称
* 数据库密码
* */


public class ItemsTest
{
    @Test
    public void findAll() throws SQLException, ClassNotFoundException
    {
        ItemsDao id = new ItemsDaoImpl();
        List<Items> list = id.findAll();
        for (Items item:list){
            System.out.println(item.getName());
        }

    }
}
