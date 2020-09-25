package com.jdbc;

import com.domain.Emp;
import com.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcDemo4
{
    public static void main(String[] args)
    {
        /*
         * 定义一个方法查询emp表的数据，并且封装成对象，装载集合，返回
         * 定义emp类
         * 定义方法 public List<emp> findAll(){}
         * 实现方法 select * from emp;
         * */
        List<Emp> empList = findAll2();
        System.out.println(empList);


    }

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public static List<Emp> findAll()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = null;

        try
        {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            connection = DriverManager.getConnection
                    ("jdbc:mysql:///pratice?serverTimezone=UTC", "root", "123456");
            //3.定义sql语句
            String sql = "select * from emp";
            //4.获取执行sql语句的对象
            statement = connection.createStatement();
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<>();
            while (resultSet.next())
            {
                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                //装载集合
                emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                list.add(emp);
            }
            //7.释放资源
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } finally
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

        return list;
    }

    public static List<Emp> findAll2()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = null;

        try
        {
            connection = JDBCUtils.getConnection();
            //3.定义sql语句
            String sql = "select * from emp";
            //4.获取执行sql语句的对象
            statement = connection.createStatement();
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<>();
            while (resultSet.next())
            {
                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                //装载集合
                emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                list.add(emp);
            }
            //7.释放资源
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(statement, connection, resultSet);
        }

        return list;
    }


}
