# maven笔记

# maven

## 概述

- Maven 是一个项目管理工具
  - 项目对象模型 （POM：Project Object Model）
  - 一组标准集合
  - 一个项目生命周期（Project Lifecycle）
  - 一个依赖管理系统（Dependency Management System）
  - 用来运行定义在生命周期阶段（phase）中插件（plugin）目标（goal）的逻辑。



### 依赖管理

- maven 工程中不直接将 jar 包导入到工程中，而是通过在 pom.xml 文件中添加所需 jar包的坐标，这样就很好的避免了 jar 直接引入进来
- 在需要用到 jar 包的时候，只要查找 pom.xml 文件，再通过 pom.xml 文件中的坐标，到一个专门用于”存放 jar 包的仓库”(maven 仓库)中根据坐标从而找到这些 jar 包，再把这些 jar 包拿去运行
- maven通过建立索引，可以大大提高加载 jar 包的速度

![image-20200914192614561](https://i.loli.net/2020/09/14/bkgNZhBC6SKmxlP.png)



### 仓库分类

- 本地仓库
  - 用来存储从远程仓库或中央仓库下载的插件和 jar 包，项目使用一些插件或 jar 包，优先从本地仓库查找
  - 默认本地仓库位置在 ${user.dir}/.m2/repository，${user.dir}表示 windows 用户目录
- 远程仓库（私服）
  - 如果本地需要插件或者 jar 包，本地仓库没有，默认去远程仓库下载
  - 远程仓库可以在互联网内也可以在局域网内
- 中央仓库 
  - 在 maven 软件中内置一个远程仓库地址 http://repo1.maven.org/maven2 ，它是中央仓库，服务于整个互联网
  - 由 Maven 团队自己维护，里面存储了非常全的 jar 包，包含了世界上大部分流行的开源项目构件。



### 标准目录结构

- 项目的组成
  - 核心代码
  - 核心代码配置文件
  - 测试代码
  - 测试代码配置文件
- maven项目标准目录结构
  - `src/main/java目录` 核心代码，存放项目的.java 文件
  - `src/main/resources` 核心代码配置文件，存放项目资源文件，如 spring, hibernate 配置文件
  - `src/test/java目录` 测试代码，存放所有单元测试.java 文件，如 JUnit 测试类
  - `src/test/resources` 测试代码配置文件，测试资源文件
  - `target` 项目输出位置，编译后的 class 文件会输出到此目录
  - （`src/main/webapp` 页面资源，js，css，图片等等）

![image-20200914195150231](https://i.loli.net/2020/09/14/IguXGbkQy5OJ8Sm.png)

![image-20200914195202316](https://i.loli.net/2020/09/14/rKAM3N85OXFWhx4.png)



## 常用的命令

|   命令    |                             作用                             |
| :-------: | :----------------------------------------------------------: |
|  `clean`  |                    删除 target 目录及内容                    |
|  `test`   |   执行 src/test/java 下的单元测试类（同时编译main和test）    |
| `compile` | 将 src/main/java 下的文件编译为 class 文件输出到 target目录下 |
| `package` | 对于 java 工程执行 package 打成 jar 包，对于 web 工程打成 war包 |
| `install` | 将 maven 打成 jar 包或 war 包发布到本地仓库（编译mian和test，打包，发布到本地仓库） |



### 规范化构建过程

- 项目往往都要经历编译、测试、运行、打包、安装 ，部署等一系列过程
- 使用maven命令`tomacat:run`可以一键完成构建
- 每一个命令都对应了maven底层的一个插件

![image-20200914200211526](https://i.loli.net/2020/09/14/TqS1Qrhm2blyOMz.png)



### 生命周期

- maven 对项目构建过程分为三套相互独立的生命周期，请注意这里说的是“三套”，而且“相互独立”
  - Clean Lifecycle（清理生命周期）：在进行真正的构建之前进行一些清理工作
  - **Default Lifecycle（默认生命周期）：构建的核心部分，编译，测试，打包，部署等等**
  - Site Lifecycle（站点生命周期）：生成项目报告，站点，发布站点



### 概念模型

- 项目对象模型

  - 一个 maven 工程都有一个 pom.xml 文件来定义项目的坐标、项目依赖、项目自身信息、插件目标等

- 依赖管理模型

  - 通过 maven 的依赖管理对项目所依赖的 jar 包进行统一管理

  ```java
      <dependency>
          <groupId>com.malajie</groupId>//公司组织的名称
          <artifactId>day01_eesy_01jdbc</artifactId>//项目名
          <version>1.0-SNAPSHOT</version>//版本号
      </dependency>
  ```

- 项目生命周期(Project Lifecycle)

  - 使用 maven 完成项目的构建，项目构建包括：清理、编译、测试、部署等过程，maven 将这些过程规范为一个生命周期

- 一组标准集合

  - maven 将整个项目管理过程定义一组标准，比如：通过 maven 构建工程有标准的目录结构，有标准的生命周期阶段、依赖管理有标准的坐标定义

- 插件(plugin)目标(goal)

  - maven 管理项目生命周期过程都是基于插件完成的

<img src="https://i.loli.net/2020/09/14/PGIyxdR34WYfvkr.png" alt="maven概念模型图"  />



## 在pom.xml文件添加坐标

```java
    <dependency>
        <groupId>com.malajie</groupId>//公司组织的名称
        <artifactId>day01_eesy_01jdbc</artifactId>//项目名
        <version>1.0-SNAPSHOT</version>//版本号
        <scope>provided</scope>
    </dependency>
    
    <package>:打包类型(jar,war)
```



### 从互联网中搜索

- http://search.maven.org/
- https://mvnrepository.com/

![image-20200914212923615](https://i.loli.net/2020/09/14/TwLZBSeO8kHCvg9.png)

![image-20200914212930186](https://i.loli.net/2020/09/14/itLjAUemTSa7qrO.png)



### 依赖范围

- A 依赖 B，需要在 A 的 pom.xml 文件中添加 B 的坐标，添加坐标时需要指定依赖范围
  - compile：编译范围，指 A 在编译时依赖 B，此范围为默认依赖范围，编译范围的依赖会用在编译、测试、运行，由于运行时需要所以编译范围的依赖会被打包
  - provided：provided 依赖只有在当 JDK 或者一个容器**已提供**该依赖之后才使用， provided 依赖在编译和测试时需要，在运行时**不需要**，比如：servlet api 被 tomcat 容器提供
  - runtime：runtime 依赖在运行和测试系统的时候需要，但在编译的时候不需要。比如：jdbc的驱动包。由于运行时需要，所以 runtime 范围的依赖会被打包
  - test：test 范围依赖 在编译和运行时都不需要，它们只有在测试编译和测试运行阶段可用，比如：junit。由于运行时不需要所以 test 范围依赖不会被打包
  - system：system 范围依赖与 provided 类似，但是你必须显式的提供一个对于本地系统中 JAR文件的路径，需要指定 systemPath 磁盘路径，system 依赖**不推荐**使用
  - 依赖范围由强到弱的顺序是：compile > provided > runtime > test

![image-20200914213946820](https://i.loli.net/2020/09/14/WPogvKGpFXRzLSd.png)



### pom基本配置

- `<project>` ：文件的根节点
- `<modelversion>` ： pom.xml 使用的对象模型版本
- `<groupId> `：项目名称，一般写项目的域名
- `<artifactId>` ：模块名称，子项目名或模块名称
- `<version> `：产品的版本号
- `<packaging>` ：打包类型，一般有 jar、war、pom 等
- `<name>` ：项目的显示名，常用于 Maven 生成的文档
- `<description>` ：项目描述，常用于 Maven 生成的文档
- `<dependencies>` ：项目依赖构件配置，配置项目依赖构件的坐标
- `<build>` ：项目构建配置，配置编译、运行插件等







### 数据库中取出数据

* 要想从数据库中取出数据，必须有四个属性
  1. 数据库驱动
  2. 连接数据库的地址
  3. 数据库用户名称
  4. 数据库密码

```java
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
```



## maven工程导入jar包

- maven工程导入jar包的坐标，必须解决jar包的冲突
- 直接依赖：项目中直接导入的jar包，就是该项目的直接依赖包
- 传递依赖：项目中没有直接导入的jar包，可以通过项目直接依赖jar包，传递到项目中



### 依赖调解原则

- 第一声明者优先原则

  - 在 pom 文件定义依赖，先声明的依赖为准
    - 先声明的jar包坐标下的依赖包，可以优先进入项目中

- 路径近者优先原则

  - 直接依赖路径比传递路径近，那么最终项目进入的jar包会是路径近的直接依赖包

- **直接排除法（推荐使用）**

  - 排除某个jar包下依赖包，在配置`<exclusions>`标签的时候，内部可以不写版本号，因为此时依赖包使用的版本号默认和本jar包一样

    ```java
    <exclusions>
        <exclusion>
        	<groupId>...</groupId>
        	<artifactId>...</artifactId>
        </exclusion>
    </exclusions>
    ```



### 锁定版本

面对众多的依赖，有一种方法不用考虑依赖路径、声明优化等因素可以采用直接锁定版本的方法确定依赖构件的版本，版本锁定后则不考虑依赖的声明顺序或依赖的路径，以锁定的版本的为准添加到工程中，此方法在企业开发中常用。

- 把版本号提取出来，使用`<properties>`标签设置成变量

```java
  <!-- 统一管理jar包版本 -->
  <properties>
    <spring.version>5.0.2.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <log4j.version>1.2.12</log4j.version>
    <shiro.version>1.2.3</shiro.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
    <spring.security.version>5.0.1.RELEASE</spring.security.version>
  </properties>
```

- 统一管理（`<dependencyManagement>`）

```java
<!-- 锁定jar包版本 -->
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
      </dependency>
    </dependencies>
  </dependencyManagement>
```



































