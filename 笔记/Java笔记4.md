# Java学习笔记4

# 多线程

## 进程

### 概述

- 进程是正在运行的程序
- 系统进行资源分配和调用的独立单位
- 每个进程都有自己的内存空间和系统资源



## 线程

### 概述

- 进程中的单个顺序控制流，一条执行路径
- 单线程：一个进程只有一条执行路径
  - 举例：记事本程序（打开页面设置，这关闭页面设置前都不可以继续修改文本）
- 多线程：一个进程有多条执行路径
  - 举例：扫雷（玩游戏的同时，进行计时）



### 多线程的实现方式

- 方式1：继承Tread类

  - 定义一个类`MyTread`继承`Tread`类
  - 在`MyThread`类中重写`run()`方法
    - 因为`run()`是用来封装被线程执行的代码
    - `run()`封装线程执行的代码，直接调用，相当于普通方法的调用
  - 创建`MyThread`类的对象
  - 启动线程
    - 调用`strat()`方法来启动线程
    - `start()`启动线程，然后由JVM调用此线程的`run()`方法

  ```java
  public class MyThreadDemo
  {
      public static void main(String[] args)
      {
          MyTread mt1 = new MyTread();
          MyTread mt2 = new MyTread();
  
          mt1.start();
          mt2.start();
          
          System.out.println(Thread.currentThread().getName());//获取当前进程的名称
      }
  }
  
  public class MyTread extends Thread
  {
      @Override
      public void run()
      {
          for (int i = 0; i < 100; i++)
          {
              System.out.println(i);
          }
      }
  }
  ```



- 方法2：实现Runnable接口

  - 定义一个类`MyRunnable`实现`Runnable`接口
  - 在`MyRunnable`类中重写`run()`方法
  - 创建`MyRunnable`类的对象
  - 创建`Thread`类的对象，把`MyRunnable`对象作为构造方法的参数
  - 启动线程

  ```java
  public class MyRunnableDemo
  {
      public static void main(String[] args)
      {
          MyRunnable mr = new MyRunnable();
          Thread t1 = new Thread(mr, "123");
          Thread t2 = new Thread(mr, "456");
  
          t1.start();
          t2.start();
      }
  }
  
  public class MyRunnable implements Runnable
  {
      @Override
      public void run()
      {
          for (int i = 0; i < 100; i++)
          {
              System.out.println(Thread.currentThread().getName() + ": " + i);
          }
      }
  }
  ```



相比于继承`Thread`类，实现`Runnable`接口的好处有

- 避免了Java单继承的局限性（实现`Runnable`接口的类可以有自己的父类）
- 适合多个相同程序的代码去处理同一个资源，把线程和程序的代码、数据有效分离，较好的体现了面对对象的设计思想



### 设置和获取线程名称

|            方法             |             说明             |
| :-------------------------: | :--------------------------: |
| `void setName(String name)` | 将此线程的名称更改为参数name |
|     `String getName()`      |         返回线程名称         |

- 通过构造方法也可以设置线程名称
  - 子类要给出带参构造方法
- `public static Thread currentThread()`：返回当前正在执行的线程对象的引用



### 线程调度

- 分时调度模型：所有线程轮流使用CPU的使用权，平均分配每个线程占用CPU的时间片
- 抢占式调度模型：优先让优先级高的线程使用CPU，如果优先级相同，那么会随机挑选一个，优先级高的线程获取的CPU时间片相对多一些**（Java）**

- 假如计算机只有一个CPU，那么CPU在某一时刻只能执行一条指令，线程只有得到CPU时间片（使用权），才可以执行命令。
- 多线程程序执行具有 **随机性**，因为谁抢到CPU的使用权是不一定的
- `Thread`类中设置和获取线程优先级的方法：
  - `public final int getPriority()`：返回线程的优先级
  - `public final void setPriority(int newPriority)`：更改此线程的优先级（）
  - 默认优先级是：**5**；线程优先级范围是：**1-10**
  - 线程优先级高仅仅表示线程获取CPU时间片的 **几率高**，但是要在次数比较多，或者多次运行的时候，才能看到想要的效果



### 线程控制

|               方法               |                             说明                             |
| :------------------------------: | :----------------------------------------------------------: |
| `static void sleep(long millis)` |       使当前正在执行的线程停留（暂停执行）指定的毫秒数       |
|          `void join()`           | 等待这个线程死亡；其他线程必须等待这个线程执行完毕，才能继续执行 |
|   `void setDaemon(boolean on)`   | 将此线程编辑为守护线程，当运行的线程都是守护线程时，Java虚拟机将退出 |



### 线程生命周期

![image-20200907165825012](https://i.loli.net/2020/09/07/Pr1qLscBG5YzOfM.png)



### 多线程的数据安全问题

判断多线程程序是否会有数据安全问题的标准

- 是否多线程环境
- 是否有共享数据
- 是否有多条语句操作共享数据

如何解决

- 基本思想：让程序没有安全问题的环境
- 把多条语句操作共享数据的代码锁起来，让任意时刻只能有一个线程执行就可以了（同步代码块）

#### 同步代码块

- 锁多条语句操作共享数据，可以使用同步代码块实现

- 格式：

  - `synchronized(任意对象)`：就相当于给代码加锁了，任意对象就可以看成是一把锁

  ```java
  synchronized(任意对象){
      多条语句操作共享数据的代码
  }
  ```

- 好处：解决了多线程的数据安全问题
- 弊端：当线程很多时，因为每个线程都会去判断同步上的锁，这样很耗费资源，无形中会降低程序的运行效率

#### 同步方法

- 把`synchronized`关键字加到方法上

- **同步方法**锁定的对象：`this`

- **同步静态方法**锁定的对象：`类名.class`

- 格式：

  ```java
  修饰符 synchronized 返回值类型 方法名(方法参数){
      
  }
  
  //同步静态方法
  修饰符 static synchronized 返回值类型 方法名(方法参数){
      
  }
  ```

#### 线程安全的类

StringBuffer

- 线程安全，可变的字符序列
- 从JDK 5版本开始，这个类已经补充了一个设计用于单个线程的等效类， StringBuilder 。 通常应优先使用StringBuilder类，因为它支持所有相同的操作，但速度更快，因为它不执行同步。 

Vector

- 从Java 2平台v1.2开始，该类被改进以实现List接口，使其成为Java Collections Framework的成员。 与新的集合实现不同， Vector是同步的。 如果不需要线程安全实现，建议使用ArrayList代替Vector 。

Hashtable

- 该类实现了一个哈希表，它将键映射到值，任何非null对象都可以用作键或者值
- 从Java 2平台v1.2开始，该类被改进以实现Map接口，使其成为Java Collections Framework的成员。 与新的集合实现不同， Hashtable是同步的。 如果不需要线程安全实现，建议使用HashMap代替Hashtable 。 如果需要线程安全的高度并发实现，则建议使用ConcurrentHashMap代替Hashtable 。 

或直接调用`Collections.synchronizedList(new ArrayList<String>())`之类的方法直接列表变成线程安全

#### Lock锁

- `Lock`实现提供比使用`synchronized`方法和语句可以获得更广泛的锁定操作
  - `void lock()`：获得锁
  - `void unlock()`：释放锁
- `Lock`是接口不能直接实例化，这里采用它的实现类`ReentrantLock`来实例化
- `ReentrantLock`的构造方法
  - `ReentrantLock()`：创建一个`ReentrantLock`的实例



## 生产者消费者

### 概述

- 生产者消费者模式是一个十分经典的多线程协作模式
- 生产者消费者问题实际上包含两类线程：
  - 生产者线程用于生成数据
  - 消费者线程用于消费数据
- 为了解耦生产者和消费者的关系，通常采用共享的数据区域
  - 生产者生成数据只会直接放置在共享数据区中，不需要关心消费者的行为
  - 消费者只需要从共享数据区中获取数据，不需要关心生产者的行为

![image-20200908145404734](https://i.loli.net/2020/09/08/8n7t613rjMsLN4w.png)

### Object类中的等待和唤醒方法

|        方法        |                             说明                             |
| :----------------: | :----------------------------------------------------------: |
|   `void wait()`    | 导致当前线程等待，直到另一个线程调用该对象的`notify()`或`notifyAll()` |
|  `void notify()`   |               唤醒正在等待对象监视器的单个线程               |
| `void notifyAll()` |               唤醒正在等待对象监视器的所有线程               |



# 网络编程

## 概述

计算机网络

- 将地理位置不同得具有独立功能得多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理协调下，实现资源共享和信息传递的计算机系统

![image-20200908153320268](https://i.loli.net/2020/09/08/rhKG2t4Cm5L6D9F.png)

网络编程

- 在网络通信协议下，实现网络互联的不同计算机上运行的程序间可以进行数据交换



## 网络编程三要素

### IP地址

- 要想让网络中的计算机能够互相通信，必须为每台计算机指定一个标识号，通过这个标识号来指定要接收数据的计算机和识别发送的计算机，而IP地址就是这个标识号，也就是**设备的标识**
- IPv4：给每个连接在网络上的主机分配一个32bit地址。
  - 按照TCP/IP规定，IP地址用二进制来表示，每个IP地址长32bit（4个字节）
  - 为了方便使用，IP地址经常被写成十进制形式，例如：192.168.1.166
- IPv6：为了扩大地址范围，通过IPv6重新定义地址空间，采用128位地址长度，每16字节一组，分成8组十六进制数
- 常用命令：
  - ipconfig：常看本机IP地址
  - ping IP地址：检查网络是否连通
  - 特殊IP地址：127.0.0.1，回送地址，可以表示本机地址，一般用于测试

#### InetAddress类

此类表示Internet协议（IP）地址

|                    方法                     |                             说明                             |
| :-----------------------------------------: | :----------------------------------------------------------: |
| `static InetAddress getByName(String host)` | 确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址 |
|           `String getHostName()`            |                     获取此IP地址的主机名                     |
|          `String getHostAddress()`          |                 返回文本显示中的IP地址字符串                 |



### 端口

- 网络的通信，本质上是两个应用程序的通信。
- 每台计算机都有很多应用程序，那么在网络通信的时候，如何区分这些应用程序呢？
  - 若说IP地址可唯一标识网络中的设备，那端口号就可唯一标识设备中的应用程序，也就是**应用程序的标识**
- 端口号用两个字节表示的整数，取值范围是：0~65535
  - 其中0~1023之间的端口号用于一些知名的网络服务和应用
  - 普通应用程序需要使用1024以上的端口号
  - 如果端口号被另一个服务或应用所占用，会导致当前程序启动失败



### 协议

- 通过计算机网络可以使多台计算机实现连接，位于同一个网络中的计算机在进行连接和通信时需要遵守一定的规则
- 在计算机网络中，这些连接和通信的规则被称为网络通信协议，它对数据的传输格式、速率、步骤等做了统一规定，通信双方必须同时遵守才能完成数据交换
- 常见的协议有：UDP和TCP
  - UDP（用户数据报协议）：
    - 无连接通信协议，在传输数据时，数据的发送端和接收端不建立逻辑连接，即，当一台计算机向另一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会像发送端反馈是否收到数据
    - 消耗资源小，通信效率高，常用于音频，视频和普通数据的传输
    - 例如视频会议，偶尔丢失一两个数据包，也不会对接受结果产生太大的影响
    - UDP的面向无连接性，不能保证数据的完整性，因此在传输数据时，不建议使用UDP协议
  - TCP（传输控制协议）：
    - **面向连接** 的通信协议，即在数据传输之前，在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间 **可靠无差错** 的数据传输。
    - 必须要明确客户端和服务端，由客户端向服务端发出连接请求，每次创建连接都要经过 **三次握手**
    - 三次握手：发送数据的准备阶段，客户端和服务端之间的三次交互，以保证连接的可靠
      1. 客户端向服务端发出连接请求，等待服务端确认
      2. 服务端向客户端回送一个响应，通知客户端收到了连接请求
      3. 客户端再次向服务端发送确认信息，确认连接
    - 完成三次握手，连接建立后，客户端和服务器就可以开始数据传输了
    - 由于面向连接的特性，TCP协议可以保证传输数据的安全，常用于上传下载文件、浏览网页等

![image-20200908160725212](https://i.loli.net/2020/09/08/QK8kEpB627RunDC.png)

## UDP

UDP（用户数据报协议）：

- 无连接通信协议，在传输数据时，数据的发送端和接收端不建立逻辑连接，即，当一台计算机向另一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会像发送端反馈是否收到数据
- 消耗资源小，通信效率高，常用于音频，视频和普通数据的传输
- 例如视频会议，偶尔丢失一两个数据包，也不会对接受结果产生太大的影响
- UDP的面向无连接性，不能保证数据的完整性，因此在传输数据时，不建议使用UDP协议



### UDP通信程序

- UDP是不可靠的网络协议，通信两端各建立一个Socket对象，但是这两个Socket只是发送，接收数据的对象，因此对于基于UDP的通信双方而言，没有所谓的客户端和服务器概念
- Java提供了`DatagramSocket`类作为基于UDP协议的Socket



### UDP发送数据

步骤：

- 创建发送端的Socket对象（`DatagramSocket`）
- 创建数据，并且把数据打包
- 调用`DatagramSocket`对象的方法发送数据
- 关闭发送端

```java
public class UDP
{
    public static void main(String[] args) throws IOException
    {
        //创建发送端的Socket对象（`DatagramSocket`）
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并且把数据打包
        byte[] bytes = "hello,udp,我来了".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.139"), 10086);

        //调用`DatagramSocket`对象的方法发送数据
        ds.send(dp);

        //关闭发送端
        ds.close();
    }
}
```



### UDP接收数据

步骤：

- 创建发送端的Socket对象（`DatagramSocket`）
- 创建数据包，用于接收数据
- 调用`DatagramSocket`对象的方法接收数据
- 解析数据包，并把数据在控制台显示
- 关闭发送端

```java
public class UDPReceive
{
    public static void main(String[] args) throws IOException
    {
        //- 创建发送端的Socket对象（`DatagramSocket`）
        DatagramSocket ds = new DatagramSocket(10086);

        //- 创建数据包，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        //- 调用`DatagramSocket`对象的方法接收数据
        ds.receive(dp);

        //- 解析数据包，并把数据在控制台显示
        byte[] data = dp.getData();
        int length = dp.getLength();
        String dataString = new String(data,0,length);
        System.out.println("数据是:" + dataString);

        //- 关闭发送端
        ds.close();
    }
}
```



## TCP

TCP（传输控制协议）：

- **面向连接** 的通信协议，即在数据传输之前，在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间 **可靠无差错** 的数据传输。
- 必须要明确客户端和服务端，由客户端向服务端发出连接请求，每次创建连接都要经过 **三次握手**
- 三次握手：发送数据的准备阶段，客户端和服务端之间的三次交互，以保证连接的可靠
  1. 客户端向服务端发出连接请求，等待服务端确认
  2. 服务端向客户端回送一个响应，通知客户端收到了连接请求
  3. 客户端再次向服务端发送确认信息，确认连接
- 完成三次握手，连接建立后，客户端和服务器就可以开始数据传输了
- 由于面向连接的特性，TCP协议可以保证传输数据的安全，常用于上传下载文件、浏览网页等



### TCP通信原理

- TCP是可靠的网络协议，它在通信的两端各建立一个Socket对象，从而在通信的两端形成网络虚拟链路，一旦建立了虚拟的网络链路，两端的程序就饿可以通过虚拟链路进行通信
- Java对基于TCP协议的网络提供了良好的封装，使用Socket对象来代表两端的通信端口，并通过Socket产生IO流来进行网络通信
  - 客户端Socket类
  - 服务端ServerSocket类



### TCP发送数据

步骤：

- 创建客户端的Socket对象（Socket）
- 获取输出流，写数据
- 释放资源

```java
public static void send() throws IOException
{
    //创建客户端的Socket对象（Socket）
    Socket s = new Socket(InetAddress.getByName("192.168.0.139"), 12345);

    //获取输出流，写数据
    OutputStream os = s.getOutputStream();
    os.write("hello,tcp,我来了".getBytes());

    //释放资源
    os.close();
}
```



### TCP接收数据

步骤：

- 创建服务端的Socket对象（ServerSocket）
- 监听客户端连接，返回一个Socket对象
- 获取输入流，读数据，把数据显示在控制台
- 释放资源

```java
public static void receive() throws IOException
{
    //- 创建服务端的Socket对象（ServerSocket）
    ServerSocket ss = new ServerSocket(12345);

    //- 获取输入流，读数据，把数据显示在控制台
    //要先监听Socket对象，真听到连接到此套接字并接收它
    Socket s = ss.accept();
    InputStream is = s.getInputStream();
    byte[] bytes = new byte[1024];
    int length = is.read(bytes);
    String data = new String(bytes, 0, length);
    System.out.println("数据是：" + data);

    //- 释放资源
    s.close();
    ss.close();
}
```



# Lambda表达式

## Lambda表达式的标准格式

- 组成Lambda表达式的三要素
  - 形式参数
  - 箭头
  - 代码块

- 使用前提

  - 有一个接口
  - 接口中有且只有一个抽象方法
  - 必须有上下文环境，才能推导出Lambda对应的接口
    - 根据局部变量的赋值
    - 根据调用方法的参数

- 格式：

  - `(形式参数)->{代码块}`
  - 形式参数：如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可
  - `->`：由英文中画线和大于符号组成，固定写法。代表指向动作
  - 代码块：具体要做的事情，也就是之前写的方法体内容

  ```java
  //启动一个线程，输出：你好
  public static void main(String[] args){
      //实现类的方式实现需求
      MyRunnable my = new MyRunnable();
      Thread t = new Thread(my);
      t.start();
      
      //匿名内部类的方式实现
      new Thread(new Runnable()){
          @Override
          public void run(){
              System.out.println("你好");
          }
      }.start();
      
      //Lambda表达式的方式改进
      new thread(() -> {
          System.out.println("你好");
      }).start();
      
  }
  ```



## Lambda省略规则

- 参数类型可以省略，但是有多个参数的情况下，不能只省略一个
- 如果参数有且只有一个，小括号可以省略
- 如果代码块语句只有一条，可以省略大括号和分号，甚至是return



## Lambda表达式和匿名内部类的区别

- 所需类型不同
  - 匿名内部类：可以是接口、抽象类或具体类
  - Lambda表达式：只能是接口
- 使用限制不同
  - 如果接口中有且只有一个抽象方法，两者都可以使用
  - 如果接口中有多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式
- 实现原理不同
  - 匿名内部类：编译之后，产生一个单独的.class字节码文件
  - Lambda表达式：编译只会，没有一个单独的.class字节码文件，对应的字节码会在运行时动态生成



## 接口组成更新

### 概述

- 接口组成
  - 常量：`public static final`
  - 抽象方法：`public abstract`
  - 默认方法（Java8）
  - 静态方法（Java8）
  - 私有方法（Java9）



#### 默认方法

- 格式：
  - `public default 返回类型 方法名(参数列表){}`
  - 范例：`public default void show(){}`

- 注意事项：
  - 默认方法不是抽象方法，不强制重写，但是可以被重写，重写时去掉`default`关键字
  - `public`可以省略，`default`不能省略



#### 静态方法

- 格式：
  - `public static 返回类型 方法名(参数列表){}`
  - 范例：`public static void show(){}`

- 注意事项：
  - 静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
  - `public`可以省略，`static`不能省略



#### 私有方法

- 格式1：
  - `private 返回类型 方法名(参数列表){}`
  - 范例：`private void show(){}`

- 格式2：
  - `privat static 返回类型 方法名(参数列表){}`
  - 范例：`private static void show(){}`

- 注意事项：
  - 默认方法可以调用私有的静态方法和非静态方法
  - 静态方法只能调用私有的静态方法



## 方法引用

- 方法引用符
  - `::`该符号为引用运算符，它所在的表达式被称为方法引用
- Lambda表达式：`useEatable(s -> System.out.println(s));`
  - 分析：拿到参数s之后通过Lambda表达式，传递给`System.out.println`方法去处理
- 方法引用：`useEatable(System.out::println);`
  - 分析：直接使用`System.out`中的`println`方法来取代Lambda，代码更加简洁
- 如果使用Lambda，根据“可推到就是可省略“的原则，无需指定参数类型，也无需指定的重载形式，它们都将被自动推导
- 如果使用方法引用，同样可以根据上下文进行推导
- 方法引用时Lambda的孪生兄弟



### Lambda表达式支持的方法引用

- 常见的引用方式
  - 引用类方法
  - 引用对象的实例方法
  - 引用类的实例方法
  - 引用构造器



#### 引用类方法

- 引用类方法，就是引用类的静态方法
  - 格式：`类名::静态方法`
  - 范例：`Integer::parseInt`
  - `Integer`类的方法：`public static int parseInt(String s)`，将此String转化为int
  - Lambda表达式被类方法替代时，它的形参全部传递给静态方法作为参数

```java
public class ConverterDemo
{
    public static void main(String[] args)
    {
        useConverter(s -> Integer.parseInt(s));

        useConverter(Integer::parseInt);
    }

    private static void useConverter(Converter c){
        int num = c.convert("666");
        System.out.println(num);
    }
}

public interface Converter
{
    int convert(String s);
}
```



#### 引用对象的实例方法

- 引用对象的实例方法，就是引用类中的成员方法
  - 格式：`类名::成员方法`
  - 范例：`"HelloWorld"::toUpperCase`
  - `String`类的方法：`public String toUpperCase()`，将此String所有字符转化为大写
  - Lambda表达式被对象的实例方法替代时，它的形参全部传递给该方法作为参数

```java
public class PrintDemo
{
    public static void main(String[] args)
    {
        //Lambda表达式
        usePrinter(s -> System.out.println(s.toUpperCase()));

        //引用对象的实例方法
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);

    }

    private static void usePrinter(Printer p)
    {
        p.printUpperCase("HelloWorld");
    }
}

public interface Printer
{
    void printUpperCase(String s);
}

public class PrintString
{
    public void printUpper(String s){
        String result = s.toUpperCase();
        System.out.println(result);
    }
}
```



#### 引用类的实例方法

- 引用类方法，就是引用类中的成员方法
  - 格式：`类名::成员方法`
  - 范例：`String::substring`
  - `String`类的方法：`public String substring(int beginIndex, int endIndex)`，从`beginInder`开始到`endIndex`结束，截取字符串，返回一个子串，子串长度为`endIndex` - `beginIndex`
  - Lambda表达式被类的实例方法替代时：
    - 它的第一个参数作为调用者
    - 后面的参数全部传递给该方法作为参数

```java
public class MyStringDemo
{
    public static void main(String[] args)
    {
        useMyString((String s, int x, int y) ->
                    {
                        return s.substring(x, y);
                    });

        useMyString((s, x, y) -> s.substring(x, y));

        useMyString(String::substring);

    }

    private static void useMyString(MyString my)
    {
        String s = my.mySubString("HelloWorld", 2, 5);
        System.out.println(s);
    }
}

public interface MyString
{
    String mySubString(String s, int beginIndex, int endIndex);
}
```



#### 引用构造器

- 引用构造器，就是引用构造方法
  - 格式：`类名::new`
  - 范例：`Student::new`
  - Lambda表达式被构造器替代时，它的形参全部传递给该方法作为参数

```java
public class StudentDemo
{
    public static void main(String[] args)
    {
        useStudentBuilder((String name, String age)->{
            return new Student(name, age);
        });

        useStudentBuilder((name, age)-> new Student(name, age));

        useStudentBuilder(Student::new);

    }

    private static void useStudentBuilder(StudentBuilder sb){
        Student s = sb.build("迪丽热巴", "28");
        System.out.println(s.toString());
    }
}

public interface StudentBuilder
{
    Student build(String name, String age);
}
```



# 函数式接口

## 概述

- 有且只有一个抽象方法的接口
- Java中函数式编程体现就是Lambda表达式，所有函数式接口就是适用于Lambda表达式的接口
- 只有确保接口中有且只有一个抽象方法，Java中的Lambda才能顺利推导



如何检测一个接口是不是函数式接口？

- `@FunctionalInterface`：放在接口定义的上方，如果是，编译通过；如果不是编译失败
- `@FunctionalInterface`可选，只要保证满足函数式接口定义的条件，也照样是函数式接口，**建议加上**



### 函数式接口作为方法的参数

- 如果方法的参数是一个函数式接口，我们可以用Lambda表达式作为参数传递
  - `startThread(() -> System.out.println(Thread.currentThread().getName() + "线程启动"));`



### 函数式接口作为方法的返回值

- 如果方法的返回值是一个函数式接口，我们可以用Lambda表达式作为结果返回
  - `private static Comparator<String> getComparator(){return (s1, s2)->s1.length() - s2.length();}`

```java
public class FunctionalInterfaceDemo
{
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("bbb");
        arr.add("cc");
        arr.add("aaaa");
        arr.add("d");

        System.out.println("排序前：" + arr);

        Collections.sort(arr);
        System.out.println("自然排序后：" + arr);

        Collections.sort(arr, getComparator());
        System.out.println("根据长度排序后：" + arr);
    }

    private static Comparator<String> getComparator(){
        //return Comparator.comparingInt(String::length);
        return (s1, s2)->s1.length() - s2.length();
    }
}
```



## 常用的函数式接口

- Supplier接口
- Consumer接口
- Predicate接口
- Function接口



### Supplier接口

`Supplier<T>`：包含一个无参的方法

- `T get()`：获得结果
- 该方法不需要参数，它会按照某种实现逻辑（Lambda表达式实现）返回一个数据
- `Supplier<T>`也被称为生产型接口，如果我们制定了接口的泛型是什么类型，那么接口中的`get()`就会产生什么类型的数据供我们使用

```java
public static void getMaxSupplier()
{
    int[] arr = {15, 68, 96, 54, 25, 7, 86, 3, 12, 45, 68, 12};

    int maxValue = getMax(() ->
                          {
                              int max = arr[0];
                              for (int i = 0; i < arr.length; i++)
                              {
                                  if (arr[i] > max)
                                  {
                                      max = arr[i];
                                  }
                              }
                              return max;
                          });

    System.out.println(maxValue);
}

private static int getMax(Supplier<Integer> sup)
{
    return sup.get();
}
```



### Consumer接口

`Consumer<T>`：包含两个方法

- `void accept(T t)`：对给定的参数执行此操作
- `default Counsumer<T> andThen(Consumer after)`：返回一个组合的`Consume`，一次执行此操作，然后执行`after`操作
- 消费型接口，它消费的数据的数据类型由泛型指定

```java
//定义一个方法消费一个字符串
public static void operatorStringConsumer()
{
    operatorString("迪丽热巴", s -> System.out.println(s));
    operatorString("迪丽热巴", s -> System.out.println(new StringBuilder(s).reverse().toString()));

    operatorString("迪丽热巴", s -> System.out.println(s), s -> System.out.println(new StringBuilder(s).reverse().toString()));
}

private static void operatorString(String name, Consumer<String> con1, Consumer<String> con2)
{
    //        con1.accept(name);
    //        con2.accept(name);
    con1.andThen(con2).accept(name);
}

private static void operatorString(String name, Consumer<String> con)
{
    con.accept(name);
}


//定义一个方法消费一个字符串两次
public static void printInfoConsumer()
{
    String[] strArray = {"malajie,24", "pikachu,5"};
    printInfo(strArray,
              (String str) ->
              {
                  String name = str.split(",")[0];
                  System.out.print("姓名：" + name);
              },
              (String str) ->
              {
                  int age = Integer.parseInt(str.split(",")[1]);
                  System.out.println(",年龄：" + age);
              });
}

private static void printInfo(String[] strArr, Consumer<String> con1, Consumer<String> con2)
{
    for (String s : strArr)
    {
        con1.andThen(con2).accept(s);
    }
}
```



### Predicate接口

`Predicate<T>`：常用的4个方法

- `boolean test(T t)`：对给定的参数进行判断（判断逻辑由Lambda表达式实现），返回一个布尔值
- `default Predicate<T> and(Predicate other)`：返回一个组合判断，对应短路与
- `default Predicate<T> or(Predicate other)`：返回一个组合判断，对应短路或
- `default Predicate<T> negate()`：返回一个逻辑的否定，对应逻辑非
- `Predicate<T>`接口通常用于判断参数是否满足指定的条件

```java
//判断给定字符串是否满足要求
public static void checkStringPredicate()
{
    //checkString1
    System.out.println(checkString("hello", s -> s.length() > 8));

    //checkString2
    boolean b3 = checkString2("hello", s -> s.length() > 8, s -> s.length() < 15);
    System.out.println(b3);

    boolean b4 = checkString2("HelloWorld", s -> s.length() > 8, s -> s.length() < 15);
    System.out.println(b4);
}

private static boolean checkString(String s, Predicate<String> pre)
{
    return pre.test(s);
}

//同一个字符串给出两个不同的判断条件，最后把这两个判断的结果做逻辑与运算的结果作为最终的结果
private static boolean checkString2(String s, Predicate<String> pre1, Predicate<String> pre2)
{
    //        boolean b1 = pre1.test(s);
    //        boolean b2 = pre2.test(s);
    //        boolean b = b1 && b2;
    //        return b;
    return pre1.and(pre2).test(s);//b1 && b2
    return pre1.or(pre2).test(s);//b1 || b2

}

//筛选满足条件的数据
public static void myFilterPredicate()
{
    String[] strArr = {"柳岩，34", "林青霞，30", "张曼玉，35", "貂蝉，31", "王祖贤，33"};
    ArrayList<String> arrayList = myFilter(strArr, s -> s.split("，")[0].length() > 2,
                                           s -> Integer.parseInt(s.split("，")[1]) > 33);

    for (String str : arrayList)
    {
        System.out.println(str);
    }
}


private static ArrayList<String> myFilter(String[] strArr, Predicate<String> pre1, Predicate<String> pre2)
{
    ArrayList<String> arr = new ArrayList<>();

    for (String s : strArr)
    {
        if (pre1.and(pre2).test(s))
        {
            arr.add(s);
        }
    }
    return arr;
}
```



### Function接口

`Function<T, R>`：常用的2个方法

- `R apply(T t)`：将此函数应用于给定的参数
- `default <V> Function andThen(Function after)`：返回一个组合函数，首先将该函数应用于输入，然后将after函数应用于结果
- `Function<T, R>`接口通常用于对参数进行处理，转换（处理逻辑由Lambda表达式实现），返回一个新的值

```java
//把一个字符串转换为int类型
public static void convertFunction()
{
    convert("100", Integer::parseInt);
    convert(200, i -> String.valueOf(i + 50));
    convert("100", Integer::parseInt,i -> String.valueOf(i + 50));
}

private static void convert(String s, Function<String, Integer> fun)
{
    int i = fun.apply(s);
    System.out.println(i);
}

//把一个int类型的数据加上一个整数后，转换为字符串输出
private static void convert(int i, Function<Integer, String> fun)
{
    String s = fun.apply(i);
    System.out.println(s);
}

//把一个字符串转换为int类型，加上一个整数后，转换为字符串输出
private static void convert(String s, Function<String, Integer> fun1,Function<Integer, String> fun2)
{
    //        Integer i = fun1.apply(s);
    //        String str = fun2.apply(i);
    String str = fun1.andThen(fun2).apply(s);
    System.out.println(str);
}
```







