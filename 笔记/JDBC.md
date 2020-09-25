# JDBC

## 概述

- Java DataBase Connectivity  Java 数据库连接， Java语言操作数据库
- 官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动jar包。可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类。
- 步骤：
  - 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
  - 复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
  - 右键-->Add As Library
  - 注册驱动
  - 获取数据库连接对象 Connection
  - 定义sql
  - 获取执行sql语句的对象 Statement（preparedStatement）
    - 给sql语句中的`?`赋值
  - 执行sql，接受返回结果
  - 处理结果
  - 释放资源

```java
public static void main(String[] args) throws Exception
{
    //1.导入驱动jar包
    //2.注册驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
    //3.获取数据库连接对象
    Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/pratice?serverTimezone=UTC", "root", "123456");
    //4.定义sql语句
    String sql = "update account set balance = 500 where id = 1";
    //5.获取执行sql的对象 Statement
    Statement statement = connection.createStatement();
    //6.执行sql
    int count = statement.executeUpdate(sql);
    //7.处理结果
    System.out.println(count);
    //8.释放资源
    statement.close();
    connection.close();
}
```



### 详细解答各个对象

#### DriverManager

驱动管理对象

- 功能
  1. 注册驱动：告诉程序该使用哪一个数据库驱动jar
     - `Class.forName("com.mysql.cj.jdbc.Driver");`（mysql5之后的驱动jar包可以省略）
  2. 获取数据库连接：
     - 方法：`static Connection getConnection(String url, String user, String password) `
     - `url`：指定连接的路径，`jdbc:mysql://ip地址(域名):端口号/数据库名称?serverTimezone=UTC`
     - 如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：`jdbc:mysql:///数据库名称`

#### Connection

数据库连接对象

- 功能
  1. 获取执行sql 的对象：
     - `Statement createStatement();`
     - `PreparedStatement prepareStatement(String sql) `
  2. 管理事务：
     - 开启事务：`setAutoCommit(boolean autoCommit)`：调用该方法设置参数为false，即开启事务
     - 提交事务：`commit()`
     - 回滚事务：`rollback()`

#### Statement

执行sql的对象

- 可以执行任意的sql
  - `boolean execute(String sql)`
- 执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
  - `int executeUpdate(String sql)`
    - 返回值：影响的行数，可以判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
- 执行DQL（select）语句
  - `ResultSet executeQuery(String sql)`

```java
public static void main(String[] args)
{ 
    //1. account表 添加一条记录

    Statement statement = null;
    Connection connection = null;

    try
    {
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 定义sql
        String sql = "insert into account values(null, 'wangwu', 3000)";
        //3.获取Connection对象
        connection = DriverManager.getConnection
            ("jdbc:mysql:///pratice?serverTimezone=UTC", "root", "123456");
        //4.获取执行sql的对象 Statement
        statement = connection.createStatement();
        //5.执行sql
        int count = statement.executeUpdate(sql);//影响的行数
        //6.处理结果
        System.out.println(count);
        if (count > 0)
        {
            System.out.println("添加成功");
        }
        else
        {
            System.out.println("添加失败");
        }
    } catch (ClassNotFoundException | SQLException e)
    {
        e.printStackTrace();
    } finally
    {
        //7.释放资源
        //避免空指针
        if (statement != null)
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (connection != null)
        {
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
```



#### ResultSet

结果集对象，封装查询结果

- `boolean next();`
  - 标向下移动一行，判断当前行是否是最后一行末尾（是否有数据），如果是，则返回false（游标已经在最后一行），如果不是则返回true（可以继续使用`next()`）
- `getXxx(参数):获取数据`
  - `Xxx`：代表数据类型   如： `int getInt()` ,	`String getString()`
  - 参数：
    - int：代表列的编号，从1开始   如： `getString(1)`
    - String：代表列名称。 如：`getDouble("balance")`
- 使用步骤：
  1. 游标向下移动一行
  2. 判断是否有数据
  3. 获取数据

```java
	ResultSet rs = null;
	...
	//5.执行sql
	rs = statement.executeQuery(sql);//影响的行数
	//循环判断游标是否是最后一行末尾。
    while(rs.next()){
        //获取数据
        int id = rs.getInt(1);
        String name = rs.getString("name");
        double balance = rs.getDouble(3);

        System.out.println(id + "---" + name + "---" + balance);
    }
```

- 练习

```java
/*
 * 定义一个方法查询emp表的数据，并且封装成对象，装载集合，返回
* 定义emp类
* 定义方法 public List<emp> findAll(){}
* 实现方法 select * from emp;
* */

/**
* 查询所有emp对象
*
* @return
*/
public static List<Emp> findAll()
{
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
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
        rs = statement.executeQuery(sql);
        //6.遍历结果集，封装对象，装载集合
        Emp emp = null;
        list = new ArrayList<>();
        while (rs.next())
        {
            //获取数据
            int id = rs.getInt("id");
            String ename = rs.getString("ename");
            int job_id = rs.getInt("job_id");
            int mgr = rs.getInt("mgr");
            Date joindate = rs.getDate("joindate");
            double salary = rs.getDouble("salary");
            double bonus = rs.getDouble("bonus");
            int dept_id = rs.getInt("dept_id");

            //装载集合
            emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
            list.add(emp);
        }
        //7.释放资源
    } catch (ClassNotFoundException | SQLException e)
    {
        e.printStackTrace();
    }finally
    {
        if (statement != null){
            try
            {
                statement.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        if (connection !=null){
            try
            {
                connection.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        if (rs !=null){
            try
            {
                rs.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }

    return list;
}
```



#### PreparedStatement

执行sql的对象

- SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
  - 输入用户随便，输入密码：`a' or 'a' = 'a`
  - sql：`select * from user where username = 'fhdsjkf' and password = 'a' or 'a' = 'a' `
  - 解决sql注入问题：使用PreparedStatement对象来解决
- 预编译的SQL：参数使用`?`作为占位符
- 获取statement对象的时候，传入sql语句
  - `preparedStatement = connection.prepareStatement(sql);`
- 执行sql语句前记得给sql语句中的`?`赋值
  - `void setString(int parameterIndex, String x);`
  - `parameterIndex`：第几个`?`
  - `x`：传入的数据
- 后期都会使用PreparedStatement来完成增删改查的所有操作
  - 可以防止SQL注入
  - 效率更高

```java
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
```



## JDBC工具类

目的：简化书写

* 分析：

  1. 注册驱动也抽取

  2. 抽取一个方法获取连接对象

     * 需求：不想传递参数（麻烦），还得保证工具类的通用性。

     * 解决：配置文件（获取路径时，如果文件夹或者文件的名称中含有空格，调用`toURI()`方法解决）

       ```xml
       jdbc.properties
       url=
       user=
       password=
       ```

  3. 抽取一个方法释放资源

```java
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
            System.out.println(path);

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
```



## 控制事物

- 一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。

- 管理事务：

  - 开启事务：`setAutoCommit(boolean autoCommit)`：调用该方法设置参数为`false`，即开启事务
    - 在执行SQL之前开启事物
  - 提交事务：`commit()`
    - 当所有SQL执行完之后提交事物
  - 回滚事务：`rollback()`
    - 在`catch`捕捉异常中回滚事务

  ```java
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
  ```



# 数据连接池

## 概述

- 一个容器(集合)，存放数据库连接的容器
- 当系统初始化好后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。



### 好处

- 节约资源
- 用户访问高效



### 实现

- 标准接口：`DataSource`   javax.sql包下
  - 获取连接：`getConnection()`
  - 归还连接：`Connection.close()`
    - 如果连接对象`Connection`是从连接池中获取的，那么调用`Connection.close()`方法，则不会再关闭连接了，而是归还连接
- 技术
  - C3P0：数据库连接池技术
  - Druid：数据库连接池实现技术，阿里巴巴提供



## C3P0

- 导入jar包 (两个) `c3p0-0.9.5.2.jar`和`mchange-commons-java-0.2.12.jar`
  - 不要忘记导入数据库驱动jar包 `mysql-connector-java-8.0.21.jar`
- 定义配置文件：
  * 名称： `c3p0.properties` 或者`c3p0-config.xml`
  * 路径：直接将文件放在src目录下即可。
- 创建核心对象 数据库连接池对象 `DataSource ds = new ComboPooledDataSource();`
  - 如果没有参数，则使用默认配置
  - 如果里面有参数（配置文件中的名称），则使用指定名称的配置
- 获取连接： `getConnection()`

```java
public static void main(String[] args) throws SQLException
{
    //1.创建数据库连接池对象
    //
    DataSource ds = new ComboPooledDataSource();
    //2. 获取连接对象
    Connection conn = ds.getConnection();
}
```



## Druid

- 导入jar包 `druid-1.0.9.jar`

- 定义配置文件：

  * 是properties形式的
  * 可以叫任意名称，可以放在任意目录下

  - 加载配置文件`Properties prop = new Properties();`
  - 获取数据库连接池对象：通过工厂来来获取  `DruidDataSourceFactory`
  - 获取连接：`getConnection()`

```java
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
```





### Druid工具类

- 定义一个类 JDBCUtils
- 提供静态代码块加载配置文件，初始化连接池对象
- 提供方法
  -  获取连接方法：通过数据库连接池获取连接
  -  释放资源
  -  获取连接池的方法

```java
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
```



## Spring JDBC

Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发

- 导入jar包

- 创建`JdbcTemplate`对象。依赖于数据源`DataSource`

  - `JdbcTemplate template = new JdbcTemplate(ds);`

- 调用JdbcTemplate的方法来完成CRUD的操作

  - `update()`：执行DML语句。增、删、改语句
  - `queryForMap()`：查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
    - 注意：这个方法查询的结果集长度只能是1（只能查询一条数据）
  - `queryForList()`：查询结果将结果集封装为list集合
    * 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中

  * `query()`：查询结果，将结果封装为JavaBean对象
    * `query`的参数：`RowMapper`
      * 一般我们使用`BeanPropertyRowMapper`实现类。可以完成数据到JavaBean的自动封装
      * `List<Emp> list = template.query(sql, new BeanPropertyRowMapper<类型>(类型.class))`
  * `queryForObject`：查询结果，将结果封装为对象
    * 一般用于聚合函数的查询

```java
public static void main(String[] args)
{
    //1.导入jar包
    //2.创建JDBCTemplate
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    //3.调用方法
    String sql = "update account set balance = 5000 where id = ?";
    //给?赋值
    int count = template.update(sql, 3);
    System.out.println(count);
}

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


```

