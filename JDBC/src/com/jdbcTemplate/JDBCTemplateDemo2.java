package com.jdbcTemplate;

import com.domain.Emp;
import com.utils.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo2
{
    //1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    /**
     * 修改1号数据的salary为10000
     */
    @Test
    public void test1()
    {
        //2.定义sql语句
        String sql = "update emp set salary = 10000 where id = ?";
        //3.给?赋值，执行sql
        int count = template.update(sql, 1001);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2()
    {
        String sql = "insert into emp(id, ename, dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /**
     * 删除刚刚添加的记录
     */
    @Test
    public void test3()
    {
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 查询id为1001的记录，并且封装成Map集合
     * 注意：查询的结果集只能是1
     */
    @Test
    public void test4()
    {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    /**
     * 查询所有的记录，并且封装成List集合
     */
    @Test
    public void test5()
    {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list)
        {
            System.out.println(map);
        }
    }

    /**
     * 查询所有的记录，并且封装为Emp对象的List集合
     */
    @Test
    public void test6()
    {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<>()
        {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException
            {
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                return new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
            }
        });
        for (Emp emp : list)
        {
            System.out.println(emp);
        }
    }

    @Test
    public void test6_2()
    {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        for (Emp emp : list)
        {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test7()
    {
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
