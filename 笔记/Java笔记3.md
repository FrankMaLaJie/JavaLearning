# Java学习笔记3

# 日期类

## Date类

### 概述

Date代表了一个特定的时间，精确到毫秒

|        构造方法名        |                             说明                             |
| :----------------------: | :----------------------------------------------------------: |
|     `public Date()`      | 分配一个Date对象，并初始化，以便它待变它被分配的时间，精确到毫秒 |
| `public Date(long date)` | 分配一个Date对象，并初始化为表示自标准基准时间以来的指定毫秒数，<br />即1970年1月1日00:00:00 GMT |

```java
import java.util.Date;

Date d1 = new Date();
System.out.println(d1);//输出：星期几 几月 几日 时间 时区 几年（现在的时刻）

long date = 1000*60*60;
Date d2 = new Date();
System.out.println(d2);//输出：Thu Jan 01 09:00:00 CST 1970

```



### Date类的常用方法

|              方法名              |                     说明                     |
| :------------------------------: | :------------------------------------------: |
|     `public long getTime()`      | 获取的是日期对象从标准基准时间到现在的毫秒值 |
| `public void setTime(long time)` |            设置时间，给的是毫秒值            |



## SimpleDateFormat类

### 概述

- 一个具体的类，用于以区域设置敏感的方式格式化和解析日期
- 日期和时间格式是由日期和时间模式字符串指定，在日期和时间模式字符串中，从 'A' 到 'Z' 以及 'a' 到 'z' 引号的字母被解释为表示日期或时间字符串的组件的模式字母

| 字母 | 对应字符串 |
| :--: | :--------: |
|  y   |     年     |
|  M   |     月     |
|  d   |     日     |
|  H   |     时     |
|  m   |     分     |
|  s   |     秒     |

|                构造方法名                 |                          说明                          |
| :---------------------------------------: | :----------------------------------------------------: |
|        `public SimpleDateFormat()`        |    构造一个SimpleDateFormat，使用默认模式和日期格式    |
| `public SimpleDateFormat(String pattern)` | 构造一个SimpleDateFormat使用给定的模式和默认的日期格式 |



### 格式化和解析日期

- 格式化（从Date到String）
  - `public final String format(Date date)`：将日期格式化成日期/时间字符串
- 解析（从String到Date）
  - `public Date parse(String source)`：从给定字符串的开始解析文本以生成日期

```java
//格式化（从Date到String）
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat();
String s = sdf.format(date);
System.out.println(s);//2020年08月26日 23:29:19

//解析（从String到Date）
String s1 = "2020-08-26- 23:29:19";
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//报错，因为s1中的格式和创建sdf2的格式不同
Date date1 = sdf2.parse(s1);
System.out.println(date1);
```



## Calendar类

### 概述

- 为某一时刻和一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法
- 本身是一个抽象类
- 提供了一个类方法 **`getInstance()`** 用于获取Calendar对象，其日历字段已使用当前日期和时间初始化
  - `Calendar rightNow = Calenda.getInstance()`；（多态的形式：通过子类创建对象）

```java
Calendar c = Calendar.getInstance();

int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH) + 1;//月份是从0开始，所以要+1
int date = c.get(Calendar.DATE);
System.out.println(year + "年" + month + "月" + date + "日");
```



### 常用方法

|                         方法名                         |                           说明                           |
| :----------------------------------------------------: | :------------------------------------------------------: |
|              `public int get(int field)`               |                   返回给定日历字段的值                   |
|   `public abstract void add(int field, int amount)`    | 根据日历的规则，将指定的时间量添加或者减去给定的日历字段 |
| `public final void set(int year, int month, int date)` |                   设置当前日历的年月日                   |



# 异常

## 概述

- 程序出现了不正常的情况

- 异常体系：

  - Error：严重问题，不需要处理
  - Exception：异常类，表示程序本身可以处理的问题
    - RuntimeException：编译期是不检查的，出现问题后，需要回来修改代码
    - 非RuntimeException：编译期就必须处理，否则程序不能通过编译，更不能正常运行

  ![image-20200827005020146](https://i.loli.net/2020/08/27/kJKjlCXFuO13aBp.png)



## JVM的默认处理方案

- 如果程序出现了问题，我们没有做任何处理，最终JVM会做默认的处理
  1. 把异常的 **名称**，**原因 **以及 **出现的位置** 等信息输出到控制台
  2. 程序停止执行



## 异常处理

- 如果程序出现了问题，我们需要自己处理，有两种方案：
  1. `try...catch...`
  2. `throws`



### try...catch...

- 格式：

  ```java
  try
  {
  	可能出现异常的代码;
  } catch (异常类名 变量名)
  {
      异常的处理代码;
  }
  ```

  1. 程序从try里面的代码开始执行
  2. 出现异常，会自动生成一个异常类对象，将被提交给Java运行时的系统
  3. 当Java运行时系统接收到异常对象时，会到catch中去找匹配的异常类，找到后，进行异常的处理
  4. 执行完毕之后，程序还可以继续往下执行



### Throwable的成员方法

|             方法名              |              说明               |
| :-----------------------------: | :-----------------------------: |
|  `public String getMessage()`   | 返回此throwable的详细消息字符串 |
|   `public String toString()`    |     返回此可抛出的简短描述      |
| `public void printStackTrace()` |  把异常的错误信息输出在控制台   |



### 编译异常和运行异常

- Java中的异常被分成两大类：**编译时异常** 和 **运行时异常** ，也被称为 **受检异常** 和 **非受检异常**
- 所有的 **RuntimeException类** 及其 **子类** 被称为运行时异常，其他的异常都是编译时异常

#### 区别

- 编译时异常：必须显示处理，否则程序就会发生错误，无法通过编译
- 运行时异常：无需显示处理，也可以和编译时异常一样处理



### throws（方法括号后）

- 虽然可以通过try...catch...对异常进行处理，但是并不是所有情况我们都有权限进行异常处理，针对这种情况，Java提供了throws的处理方案
- 格式：

  - `throws 异常类名`；
  - **注意：throws 这个格式时跟在方法的括号后面**
- **注意：throw**

- **编译时异常必须要进行处理**，两种处理方案
  - try...catch...
  - throws，采用这种方案，将来谁调用，谁处理
- **运行时异常可以不处理**，出现问题后，需要我们回来修改代码



### 自定义异常

- 只要类继承了 **RuntimeException** 或者 **Exception** ，这个类就变成了异常体系成员

- 格式：

  ```java
  //格式：
  public class 异常类名 extends Exception{
      无参构造
      带参构造
  }
  //范例：
  public class ScoreException extends Exception{
      public ScoreException(){};
      public ScoreException(String message){
          super(message);
      };
  }
  
  public class Teacher{
      public void checkScore(int score) throws ScoreException{
          if(score < 0 || score > 100){
              //throw用于在方法体内部抛出异常，
              //因为ScoreException是自定义异常，
              //所以需要手动抛出
              throw new ScoreException("你给的分数有误，应该在0到100之间");
          }
          else
          {
              System.out.println("分数正常");
          }
      }
  }
  ```



#### throws和throw的区别

- throws
  - 用在方法声明后，跟的是异常 **类名** 
  - 表示抛出异常，由该方法的 **调用者** 来处理
  - 表示出异常的一种可能性，**并不一定** 会发生这些异常

- throw
  - 用在方法体内，跟的是异常 **对象名** 
  - 表示抛出异常，由方法体内的 **语句** 处理
  - 执行throw **一定** 抛出了某种异常



# IO流

## File类

### 概述

- 文件和目录路径名的抽象表示
- 文件和目录可以通过File封装成对象
- 对于File来说，它封装的不是一个真正存在的文件，而仅仅是一个路径名。它可以存在，可以不存在，将来是要通过具体操作把这个路径的内容转换为具体存在的



### 构造方法

|               方法名                |                            说明                            |
| :---------------------------------: | :--------------------------------------------------------: |
|       `File(String pathname)`       | 通过将给定的路径名字符串转换为抽象路径名来创建新的File实例 |
| `File(String parent, String child)` |      从父路径名字符串和子路径名字符串创建新的File实例      |
|  `File(File parent, String child)`  |       从父抽象路径名和子路径名字符串创建新的File实例       |

```java
public static void main(String[] args){
    File f1 = new File("E:\\xxxx\\xxxx.exe");
    
    File f2 = new File("E:\\xxx", "xxx.exe");
    
    File f3 = new File("E:\\xxxx");
    File f4 = new File(f3, "xxx.exe");
    
}
```



### 创建功能

|              方法名              |                             说明                             |
| :------------------------------: | :----------------------------------------------------------: |
| `public boolean createNewFile()` | 当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件 |
|     `public boolean mkdir()`     |                 创建由此抽象路径名命名的目录                 |
|    `public boolean mkdirs()`     |  创建由此抽象路径名命名的目录，包括任何必须但不存在的父目录  |

```java
public static void main(String[] args){
    File f1 = new File("E:\\xxxx\\xxxx.exe");
    //如果文件不存在，就创建文件返回true
    //如果文件存在，就不创建文件返回false
    f1.createNewFile();
    
    File f2 = new File("E:\\xxx");
    //如果目录不存在，就创建文件返回true
    //如果目录存在，就不创建文件返回false
    f2.mkdir();
    
    File f3 = new File("E:\\aaa\\bbb\\cccc");
    //要创建多级目录，必须用 mkdirs()方法
    f3.mkdirs();
}
```



### 判断、获取和删除功能

|              方法名               |                           说明                           |
| :-------------------------------: | :------------------------------------------------------: |
|  `public boolean isDirectory()`   |           测试此抽象路径名表示的File是否为目录           |
|     `public boolean isFile()`     |           测试此抽象路径名表示的File是否为文件           |
|     `public boolean exists()`     |            测试此抽象路径名表示的File是否存在            |
| `public String getAbsolutePath()` |            返回此抽象路径名的绝对路径名字符串            |
|     `public String getPath()`     |             将此抽象路径名转化为路径名字符串             |
|     `public String getName()`     |         返回由此抽象路径名表示的文件或目录的名称         |
|     `public String[] list()`      | 返回此抽象路径名表示的目录中的文件和目录的名称字符串数组 |
|    `public File[] listFiles()`    |  返回此抽象路径名表示的目录中的文件和目录的File对象数组  |
|     `public boolean delete()`     |            删除由此抽象路径名表示的文件或目录            |

- 绝对路径：**完整的路径名**，不需要任何其他信息就可以定位它所在的文件
  - 例如：E:\\\aaa\\\bbb\\\cccc.exe
- 相对路径：必须使用取自其他路径名的信息进行解释
  - 例如：aaa\\\bbb\\\cccc.exe
- **删除目录时的注意事项：**
  - 如果一个 **目录中有内容**，**不能直接删除**，应该先删除目录中的内容，最后删除目录



## 递归

### 概述

- **方法** 定义中 **调用方法本身**

- 把一个复杂的问题层层转化为一个 **和原问题相似的规模较小** 的问题求解
- 递归策略只需 **少量的程序** 就可以描述出解题过程所需要的多次重复计算
- 通过递归解决问题必须找到两个内容
  - 递归出口：否则出现内存溢出
  - 递归规则：和原问题相似的规模较小的问题

```java
public static int f(int n){
    if(n == 1 || n == 2){
        return 1;
    }
    else
    {
        return f(n - 1) + f(n - 2)
    }
}
```



### 内存图

```java
public static int factorial(int n){
    if (n == 1){
        return 1;
    }
    else
    {
        return n * factorial(n-1);
    }
}
```



- 进栈的过程

![image-20200902163256662](https://i.loli.net/2020/09/02/wFfMT2roZL9Eq3O.png)

![image-20200902163519824](https://i.loli.net/2020/09/02/QcH481e5jCkWOZL.png)

一直调用同一个方法，直到调用到 **递归出口** 为止



- 出栈的过程

![image-20200902163853703](https://i.loli.net/2020/09/02/Y6p2xGc4s7jvw9d.png)



**递归出口** 算完了，就反过来一直计算直到执行完所有方法



### 递归遍历目录

给定一个路径，通过递归完成遍历该目录下的所有内容

思路：

- 根据给定的路径创建File对象
- 定义一个方法，用于获取给定目录下的所有内容，参数为刚刚创建的File对象
- 获取给定的File目录下所有的文件或者目录的File数组
- 遍历File数组，得到每一个File对象
- 盘对File对象是否是目录
  - 是：递归调用
  - 否：获取绝对路径输出

```java
public static void traverseDir(File file)
{
    //获取给定的File目录下所有的文件或者目录的File数组
    File[] listFiles = file.listFiles();

    //遍历File数组，得到每一个File对象
    //先判断File数组是否为null
    if (listFiles != null)
    {
        //遍历File数组，获取每一个File对象
        for (File f : listFiles)
        {
            //如果是目录，递归
            if (f.isDirectory())
            {
                traverseDir(f);
            }
            //如果不是目录，输出
            else
            {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
```



## IO流

### 概述

- IO：输入/输入（Input / Output）
- 流：是对数据传输的总称
  - 数据在设备间的传说称为流
  - 流的本质是数据传输
- IO流就是用来处理设备间数据传输问题的
  - 文件复制，文件上传，文件下载

![image-20200902170017828](https://i.loli.net/2020/09/02/ibekjZDunyVE2tL.png)



### 分类

- 根据 **流向** 进行分类
  - 输入流：读数据
  - 输出流：写数据
- 根据 **数据类型** 进行分类**（默认）**
  - 字节流
    - 字节输入流
    - 字节输出流
  - 字符流
    - 字符输入流
    - 字符输出流
- 数据通过记事本打开，不是乱码，就是用字符流，否则使用字节流
- **万能流：字节流**



### 字节流

字节流抽象类基类

- `InputStream`：字节输入流的所有类的超类
- `OutputStream`：字节输出流的所有类的超类
- 子类名特点：子类名称都是以其父类名作为子类名的后缀

#### 写数据

- `FileOutputStream`：文件输出流用于将数据写入File
  - `FileOutputStream(String name)`：创建文件输出流以指定的名称写入文件
  - `FileOutputStream(String name, boolean append)`：创建文件输出流以指定的名称写入文件。如果第二个参数是 **true**，则字节将写入文件的末尾而不是开头
- 写完数据后，换行要加换行符
  - windows：\r\n
  - linux：\n
  - mac：\r
- 使用字节输出流写数据的步骤：
  - 创建字节流输出对象
    - 调用系统功能创建了文件
    - 创建字节输出流对象
    - 让字节输出流对象指向文件
  - 调用字节输出流对象的写数据方法
  - **释放资源（非常重要）**
    - **关闭此文件的输出流**
    - **释放和此流相关的任何系统资源**

```java
public static void main(String[] args) throws IOException
{
    //创建字节输出流对象
    FileOutputStream fos = new FileOutputStream("Java Pratical\\fos.txt");
    /*
            干了三件事情：
            - 调用系统功能创建了文件
            - 创建字节输出流对象
            - 让字节输出流对象指向文件
    */

    //写进去的不是"95"，而是"95"对应的字符
    fos.write(95);

    //最后一定要释放资源
    fos.close();
}
```



#### 方法

|                  方法名                  |                             说明                             |
| :--------------------------------------: | :----------------------------------------------------------: |
|           `void write(int b)`            |     将指定的字节写入此文件输出流<br />一次写一个字节数据     |
|          `void write(byte[] b)`          | 将b.length字节从指定的字节数组写入此文件输出流<br />一次写一个字节数组数据 |
| `void write(byte[] b, int off, int len)` | 将len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流<br />一次写一个字节数组的部分数据<br />从第off个索引开始，写len个数据 |



#### 字节流写数据的异常处理

- finally：在异常处理时，提供 **finally** 块来执行所有清楚操作，比如IO流中的释放资源

  - 特点：被finally控制的语句一定会执行，除非JVM退出

  ```java
  try{
      可能出现异常的代码;
  }
  catch(异常类名 变量名){
      异常的处理代码;
  }
  finally{
      执行所有清楚操作;
  }
  ```

  

#### 读数据

##### 一次读一个字节的数据

- `FileIntputStream`：从文件系统中的文件获取输入字节
  - `FileIntputStream(String name)`：创建文件输出流以指定的名称写入文件
- 使用字节输入流写数据的步骤：
  - 创建字节流输入对象
  - 调用字节输入流对象的读数据方法read()
    - 第一次读，读取第一个字符；第二次读，读取第二个字符
    - 当读取到末尾，没有数据可读的时候，返回 -1
  - **释放资源（非常重要）**
    - **关闭此文件的输入流**
    - **释放和此流相关的任何系统资源**

```java
public static void main(String[] args) throws IOException
{
    //创建字节输出流对象
    FileInputStream fis = new FileInputStream("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");

    int by;
    /*
        - fis.read()：读数据
        - by = fis.read()：把读到的数据赋值给by
        - by != -1：判断读取到的数据是否是-1
     */
    while ((by = fis.read()) != -1)
    {
        //把读取到的字节强制转换为字符
        System.out.println((char) by);
    }

    //最后一定要释放资源
    fis.close();
}
```



##### 一次读一个字节数组的数据（可以用于复制图片）

- 使用字节输入流写数据的步骤：
  - 创建字节流输入对象()
  - 创建字节数组
  - 调用字节输入流对象的读数据方法read()
    - 当读取到末尾，没有数据可读的时候，返回 -1
  - **释放资源（非常重要）**
    - **关闭此文件的输入流**
    - **释放和此流相关的任何系统资源**

```java
public static void main(String[] args) throws IOException
{
    //创建字节输出流对象
    FileInputStream fis = new FileInputStream("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt");//abcd

    //创建字节数组
    byte[] by = new byte[3];

    //读取最多字节数组长度（by.length()）个字符
    //此时by是空的，所以把文件中前三个字符的字节存入数组
    int len = fis.read(by);
    //返回实际读取到的个数
    System.out.println(len);//3
    //把从索引 0 到 len 的字节转换成字符串输出，
    System.out.println(new String(by, 0, len));//abc

    //此时，文件中只剩下d，所以拿d替换掉a，by里面最后存放了dbc
    len = fis.read(by);
    //返回实际读取到的个数
    System.out.println(len);//1
    System.out.println(new String(by, 0, len));//dbc

    //优化方案
    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) != -1)
    {
        System.out.println(new String(bytes, 0, length));
    }
    
    //最后一定要释放资源
    fis.close();
}
```

- 读取最多字节数组长度（`by.length()`）个字符
- 把读到的字符字节存到创建的字节数组中，by
- 在字节数组中，后一次读取到的数据，会覆盖前一次读取到的数据
- 如果剩余的字符字节个数小于字节数组的长度
  - 先把剩余的字符字节存入数组，覆盖前一次数据
  - 后面的数据没有东西去覆盖，所以输出时依然是上一次的数据
  - `read(bytep[] b)`，返回实际读取到的个数



### 字节缓冲流

#### 概述

- `BufferedOutputStream`：该类实现缓冲输出流。
  - 通过设置这样的输出流，应用程序可以向底层输出流写入字节，而不必为写入每个字节导致底层系统调用
- `BufferedInputStream`：创建`BufferedInputStream`将创建一个内部缓冲区数组
  - 当从流中读取或跳过字节时，内部缓冲区根据需要从所包含的输入流中重新填充，一次很多字节



#### 构造方法

- 字节缓冲输出流：`BufferedOutputStream(OutputStream out)`
- 字节缓冲输入流：`BufferedInputStream(InputStream in)`
- 字节缓冲流 **仅仅提供缓冲区**，而真正的读写数据还是得依靠基本的字节流对象进行操作



### 字符流

- 由于字节流操作中文不方便，所以Java提供字符流
- 字符流 = 字节流 + 编码表
- 用字节流复制文本时，文本中可以也有中文，因为最终底层操作会自动进行字节拼接
- 汉字存储：
  - GBK编码，占用2个字节
  - UTF-8编码，占用3个字节
  - 无论那一种编码，第一个字节都是 **负数**



#### 编码表

- 计算机存储信息用 **二进制数** 表示
- 屏幕上的英文、汉字等字符都是二进制数转化后的结果
- 按照某种规则将字符存储到计算机中称为 **编码**
- 将字符存储在计算机按照某种规则解析出来称为 **解码**
- **采用什么规则编码，就要采用对应的规则解码，否则就会出现乱码**
- 字符集：
  - 一个系统支持的所有字符的集合，包括国家文字、标点符号、图形符号、数字等
  - 要准确存储和识别各种字符集符号，就要进行字符编码，一套字符集至少有一套字符编码
  - 常见的字符集有：ASCII、GBXXX、Unicode等



##### ASCII

- 美国信息交换标准代码
- 基于拉丁字母的一套电脑编码系统，用于显示现在英语
- 主要包括控制字符（回车键、退格等）和可显示字符（英文大小写字符、阿拉伯数字和西文字符）
- 基本ASCII字符集用7位表示一个字符，共128字符
- ASCII扩展字符集用8位表示一个字符，共256字符，方便欧洲常用字符
- 一个系统支持的所有字符的集合，包括国家文字、标点符号、图形符号、数字等



##### GBXXX

- GB2312：简体中文码表
  - 一个小于127的字符的意义和原来相同，但两个大于127的字符连在一起，就表示一个汉字，包含了了7000多个简体汉字
  - 全角：数字符号，罗马希腊的字母、日文的假名也编进去了，ASCII原本的数字、标点、字母都重新编了两个字节长的编码
  - 半角：原来在127号以下的那些就叫半角字符
- **GBK**：最常用的中文码表
  - 在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了21003个汉字，完全兼容GB2312，同时支持繁体汉字以及日韩汉字等
- GB18030：最新中文码表
  - 收录汉字70244个，采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等



##### Unicode

- Unicode：统一码，万国码
  - 为了表达任意语言的任意字符而设计的，是业界的一种标准
  - 最多使用4个字节的数字来表达每个字母、符号或者文字
    - 有三种编码方案：**UTF-8**（最常用）、UTF-16和UTF32
  - **UTF-8**：可以用来表示Unicode标准中任意字符，它是电子邮件、网页以及其他存储或传送文字的应用中。优先采用的编码。
    - 互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码
    - 它使用一至四个字节为每个字符编码
    - 规则：
      - 128个US-ASCII字符，只需要1个字节编码
      - 拉丁文字符，需要2个字节编码
      - 大部分常用字（包含中文），需要3个字节编码
      - 其他极少使用的Unicode辅助字符，需要4个字节编码

#### 字符流中的编码解码问题

**采用什么规则编码，就要采用对应的规则解码，否则就会出现乱码**

##### 编码

- `byte[] getBytes()`：使用平台的默认字符集将该String编码为一系列字节，将结果存储到新的字节数组中
- `byte[] getBytes(String charsetName)`：使用指定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中



##### 解码

- `String(byte[] byte)`：使用平台的默认字符集解码指定的字节数组来构造新的String
- `String(byte[] byte, String charsetName)`：使用指定的字符集解码指定的字节数组来构造新的String





#### 字符流中的编码解码问题

- 字符流抽象基类
  - `Reader`：字符输入流的抽象类
  - `Writer`：字符输出流的抽象类
- 字符流中和编码解码问题相关的两个类
  - `InputStreamReader`
  - `OutputStreamWriter`
- 复制文件可以直接用他们的直接子类
  - `FileReader`
  - `FileWriter`



#### 字符流写数据的5种方式

|                   方法名                    |                             说明                             |
| :-----------------------------------------: | :----------------------------------------------------------: |
|             `void write(int c)`             |                          写一个字符                          |
|          `void write(char[] cbuf)`          |                       写入一个字符数组                       |
| `void write(char[] cbuf, int off, int len)` |                   写入一个字符数组的一部分                   |
|           `void write(String str)           |                        写入一个字符串                        |
| `void write(String str, int off, int len)`  |                    写入一个字符串的一部分                    |
|               `void flush()`                |                   刷新流，还可以继续写数据                   |
|               `void close()`                | 关闭流，释放资源，但是在关闭之前会先刷新流。一点关闭就不能再写数据 |



#### 字符流读数据的2种方式

|          方法名          |          说明          |
| :----------------------: | :--------------------: |
|      `void read()`       |   一次读一个字符数据   |
| `void read(char[] cbuf)` | 一次读一个字符数组数据 |



### 字符缓冲流

- `BufferedWriter`：将文本写入字符输出流，缓冲字符，以提供单个字符、数组和字符串的高效写入，
  - 可以指定缓冲区的大小，或者接受默认大小
  - 默认值足够大，可用于大多数用途
- `BufferedReader`：从字符输入流读取文本，缓冲字符，以提供单个字符、数组和行的高效读取
  - 可以指定缓冲区的大小，或者接受默认大小
  - 默认值足够大，可用于大多数用途



#### 构造方法

- 字符缓冲输出流：`BufferedWriter(Writer out)`
- 字符缓冲输入流：`BufferedReader(Reader in)`



#### 特有功能

- `BufferedWriter`：
  - `void newLine()`：写一个行分隔符，行分隔符字符串由系统属性定义
- `BufferedReader`：
  - `public String readLine()`：读一行文字，结果包含行的内容的字符串，**不包含任何行终止符**，如果到达流的结尾，返回null
  - 一行被认为是由换行符（'\ n'），回车符（'\ r'），回车符后紧跟换行符或到达文件结尾的任何一个终止（EOF）。 

```java
public static void main(String[] args) throws IOException
{
    //创建字符缓冲流对象
    BufferedReader br = new BufferedReader(new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\Github Desktop\\JavaLearning\\Java Practical\\fos.txt"));
    
    //写10行，每行都是helloi
    for(int i = 0; i < 10; i++)
    {
        //用BufferedWriter写数据标准三个步骤
        bw.write("hello" + i);
        bw.newLine();//换行
        bw.flush();
    }
    
    //用BufferedReader读数据标准格式
    String line;
    while ((line = br.readLine()) != null)
    {
        //System.out.print(line);//输出全部在同一行，因为readLine()不读换行符
        System.out.println(line);
    }
    
    //最后一定要释放资源
    br.close();
    bw.close();
}
```



### IO流总结

#### 字节流

![image-20200903211710838](https://i.loli.net/2020/09/03/uUXdLD2WJQ71jhn.png)

![image-20200903211813101](https://i.loli.net/2020/09/03/vRV4XiEtdIDc2Bm.png)

#### 字符流

![image-20200903211908713](https://i.loli.net/2020/09/03/OG3Hkhjby2CfU9I.png)

![image-20200903212024743](https://i.loli.net/2020/09/03/j3Ksti8fFMBHyha.png)





















