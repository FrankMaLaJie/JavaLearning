# Java学习笔记3

# 日期类

## Date类

### 概述

Date代表了一个特定的时间，精确到毫秒

|       构造方法名       |                             说明                             |
| :--------------------: | :----------------------------------------------------------: |
|     public Date()      | 分配一个Date对象，并初始化，以便它待变它被分配的时间，精确到毫秒 |
| public Date(long date) | 分配一个Date对象，并初始化为表示自标准基准时间以来的指定毫秒数，<br />即1970年1月1日00:00:00 GMT |

```java
import java.util.Date;

Date d1 = new Date();
System.out.println(d1);//输出：星期几 几月 几日 时间 时区 几年（现在的时刻）

long date = 1000*60*60;
Date d2 = new Date();
System.out.println(d2);//输出：Thu Jan 01 09:00:00 CST 1970

```



### Date类的常用方法

|             方法名             |                     说明                     |
| :----------------------------: | :------------------------------------------: |
|     public long getTime()      | 获取的是日期对象从标准基准时间到现在的毫秒值 |
| public void setTime(long time) |            设置时间，给的是毫秒值            |



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

|               构造方法名                |                          说明                          |
| :-------------------------------------: | :----------------------------------------------------: |
|        public SimpleDateFormat()        |    构造一个SimpleDateFormat，使用默认模式和日期格式    |
| public SimpleDateFormat(String pattern) | 构造一个SimpleDateFormat使用给定的模式和默认的日期格式 |



### 格式化和解析日期

- 格式化（从Date到String）
  - public final String format(Date date)：将日期格式化成日期/时间字符串
- 解析（从String到Date）
  - public Date parse(String source)：从给定字符串的开始解析文本以生成日期

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
- 提供了一个类方法 **getInstance()** 用于获取Calendar对象，其日历字段已使用当前日期和时间初始化
  - Calendar rightNow = Calenda.getInstance()；（多态的形式：通过子类创建对象）

```java
Calendar c = Calendar.getInstance();

int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH) + 1;//月份是从0开始，所以要+1
int date = c.get(Calendar.DATE);
System.out.println(year + "年" + month + "月" + date + "日");
```



### 常用方法

|                        方法名                        |                           说明                           |
| :--------------------------------------------------: | :------------------------------------------------------: |
|              public int get(int field)               |                   返回给定日历字段的值                   |
|   public abstract void add(int field, int amount)    | 根据日历的规则，将指定的时间量添加或者减去给定的日历字段 |
| public final void set(int year, int month, int date) |                   设置当前日历的年月日                   |



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
  1. try...catch...
  2. throws



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

|            方法名             |              说明               |
| :---------------------------: | :-----------------------------: |
|  public String getMessage()   | 返回此throwable的详细消息字符串 |
|   public String toString()    |     返回此可抛出的简短描述      |
| public void printStackTrace() |  把异常的错误信息输出在控制台   |



### 编译异常和运行异常

- Java中的异常被分成两大类：**编译时异常** 和 **运行时异常** ，也被称为 **受检异常** 和 **非受检异常**
- 所有的 **RuntimeException类** 及其 **子类** 被称为运行时异常，其他的异常都是编译时异常

#### 区别

- 编译时异常：必须显示处理，否则程序就会发生错误，无法通过编译
- 运行时异常：无需显示处理，也可以和编译时异常一样处理



### throws（方法括号后）

- 虽然可以通过try...catch...对异常进行处理，但是并不是所有情况我们都有权限进行异常处理，针对这种情况，Java提供了throws的处理方案
- 格式：

  - throws 异常类名；
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

































