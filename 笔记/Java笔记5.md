# Java笔记5

# Stream流

使用Stream流的方式进行过滤操作

```java
public static void main(String[] args)
{
    //创建一份名单
    ArrayList<String> list = new ArrayList<>();
    list.add("林青霞");
    list.add("张曼玉");
    list.add("王祖贤");
    list.add("柳岩");
    list.add("张敏");
    list.add("张无忌");

    //姓张的放在一个集合
    ArrayList<String> zhangList = new ArrayList<>();
    for (String s : list)
    {
        if (s.startsWith("张"))
        {
            zhangList.add(s);
        }
    }
    System.out.println(zhangList);

    //姓张的集合中长度为3的放入一个集合
    ArrayList<String> zhangList3 = new ArrayList<>();
    for (String s : zhangList)
    {
        if (s.length() == 3)
        {
            zhangList3.add(s);
        }
    }
    System.out.println(zhangList3);

    //Stream改进
    //直接阅读代码的字面意思就可以完美展示无关逻辑方式的语义
    //生成流、过滤张、过滤长度为3、逐一打印
    list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(System.out::println);
    
}
```



## Stream流的生成方式

- 生成流
  - 通过数据源（集合、数组等）生成流
  - `list.stream()`
- 中间操作
  - 一个流后面可以不跟或者跟多个中间操作，目的主要是打开流，做出某种程度的数据过滤/映射，然后返回一个新的流，交给下一个操作使用
  - `filter()`
- 终结操作
  - 一个流只能有一个终结操作，当这个操作执行后，流就被使用“光”了，无法再被操作，所以这个必定是最后一个操作
  - `forEach()`

![image-20200910160511714](https://i.loli.net/2020/09/10/UJ9kdsuL3neaHSK.png)



### 常见的生成方式

- `Collection`体系的集合可以使用默认方法`stream()`生成流
  - `default Stream<E> stream()`
- `Map`体系的集合间接的生成流
  - 通过键的集合
  - 通过值的集合
  - 通过键 - 值的集合
- 数组可以通过`Stream`接口的静态方法`of(T...values)`生成流

```java
public static void createStream(){
    //`Collection`体系的集合可以使用默认方法`stream()`生成流
    List<String> list = new ArrayList<>();
    Stream<String> listString = list.stream();

    Set<String> set = new HashSet<>();
    Stream<String> setStream = set.stream();

    //`Map`体系的集合间接的生成流
    Map<String,Integer> map = new HashMap<>();
    Stream<String> keyStream = map.keySet().stream();
    Stream<Integer> valueStream = map.values().stream();
    Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

    //数组可以通过`Stream`接口的静态方法`of(T...values)`生成流
    String[] strArr = {"hello","world","java"};
    Stream<String> strArrStream = Stream.of(strArr);
    Stream<String> strArrStream2 = Stream.of("hello", "world", "java");
    Stream<Integer> integerStream = Stream.of(10, 20, 30);
}
```



### 常见的中间操作

- `Stream<T> filter(Predicate predicate)`：用于对流中的数据进行过滤
  - `Predicate`接口中的方法：`boolean test(T t)`：对给定的参数进行判断，返回一个布尔值
- `Stream<T> limit(long maxSize)`：返回此流中的元素组成的流，截取前指定参数个数的数据
- `Stream<T> skip(long n)`：跳过指定参数个数的数据，返回由此流中的剩余元素组成的流
- `static<T> Stream<T> concat(Stream a, Stream b)`：合并a和b两个流为一个流
- `Stream<T> distinct()`：返回由该流的不同元素（根据`Object.equals(Object)`）组成的流
- `Stream<T> sorted()`：返回由该留的元素组成的流，根据自然顺序排序
- `Stream<T> sorted(Comparator comparator)`：返回由该流的元素组成的流，根据提供的`Comparator`进行排序
- `<R> Stream<R> map(Function mapper)`：返回一个流，该流包含将给定函数应用于此流的元素的结果。
  - `Function`接口中的方法：`R apply(T t)`
- `IntStream mapToInt(ToIntFunction mapper)`：返回`IntStream`其中包含将给定函数应用于此流的元素的结果
  - `IntStream`：表示原始`int`流
  - `ToIntFunction`接口中的方法：`int applyAsInt(T value)`

```java
public static void midOperation()
{
    ////创建一份名单
    ArrayList<String> list = new ArrayList<>();
    list.add("linqingxia");
    list.add("zhangmanyu");
    list.add("wangzuxian");
    list.add("liuyan");
    list.add("zhangmin");
    list.add("zhangwuji");

    ArrayList<String> list2 = new ArrayList<>();
    list2.add("10");
    list2.add("20");
    list2.add("30");
    list2.add("40");
    list2.add("50");
    list2.add("60");

    //需求1：取前4个个元素数据组成一个流
    Stream<String> stream1 = list.stream().limit(4);

    //需求2：跳过2个数据组成一个流
    Stream<String> stream2 = list.stream().skip(2);

    //需求3：合并需求1，2得到的流，并且输出，要求字符串元素不重复
    //消耗流，做需求4之前要先注释
    Stream.concat(stream1, stream2).distinct().forEach(System.out::println);
    System.out.println("--------");

    //需求4：按照顺序把数据在控制台输出
    //消耗流，做需求5之前要先注释
    list.stream().sorted().forEach(System.out::println);
    System.out.println("--------");

    //需求5：按照字符串长度在控制在输出
    list.stream().sorted((s1, s2) ->
                         {
                             int num = s1.length() - s2.length();
                             int num2 = num == 0 ? s1.compareTo(s2) : num;
                             return num2;
                         }).forEach(System.out::println);

    //需求6：将集合中的字符串数据转换为整数后输出
    list2.stream().map(Integer::parseInt).forEach(System.out::println);
    //mapToInt获得的是一个IntStream，可以做别的操作
    int sum = list2.stream().mapToInt(Integer::parseInt).sum();
    System.out.println(sum);
}
```



### 常见的终结操作

- `void forEach(Consumer action)`：对此流的每个元素进行操作
  - `Consumer`接口中的方法：`void accept(T t)`：对给定的参数执行此操作

- `long count()`：返回此流中的元素个数

```java
public static void endOperation(){
    ////创建一份名单
    ArrayList<String> list = new ArrayList<>();
    list.add("linqingxia");
    list.add("zhangmanyu");
    list.add("wangzuxian");
    list.add("liuyan");
    list.add("zhangmin");
    list.add("zhangwuji");

    //需求1：把集合中的元素在控制台输出
    list.stream().forEach(System.out::println);
    System.out.println("--------------------------");

    //需求2：统计集合中有多少个元素以“z”开头，输出统计结果
    long count = list.stream().filter(s -> s.startsWith("z")).count();
    System.out.println(count);
}
```



### Stream流中的收集操作

Stream流的收集方法

- `R collect(Collector collector)`
- 这个收集方法的参数是一个`Collector`接口

工具类`Collectors`提供了具体的收集方式

- `public static <T> Collector toList()`：把元素收集到List集合中
- `public static <T> Collector toSet()`：把元素收集到Set集合中
- `public static Collector toMap(Function keyMapper, Function valueMapper)`：把元素收集到Map集合中

```java
public static void collect()
{
    //创建List集合
    ArrayList<String> list = new ArrayList<>();
    list.add("林青霞");
    list.add("张曼玉");
    list.add("柳岩");
    list.add("王祖贤");

    //需求1：得到名字为3个字的流
    Stream<String> threeStream = list.stream().filter(s -> s.length() == 3);

    //需求2：把使用Stream流操作完毕的数据收集到list集合中，并且遍历
    List<String> threeList = threeStream.collect(Collectors.toList());
    for (String s : threeList)
    {
        System.out.println(s);
    }

    //创建Set集合
    Set<Integer> set = new HashSet<>();
    set.add(10);
    set.add(20);
    set.add(30);
    set.add(33);
    set.add(35);

    //需求3：得到年龄大于25的流
    Stream<Integer> ageStream = set.stream().filter(i -> i > 25);

    //需求4：把使用Stream流操作完毕的数据收集到set集合中，并且遍历
    Set<Integer> ageSet = ageStream.collect(Collectors.toSet());
    for (int i : ageSet)
    {
        System.out.println(i);
    }

    //定义一个字符串数组，每一个字符串数据由名字和年龄组合而成
    String[] strArr = {"林青霞，30", "张曼玉，35", "王祖贤，33", "柳岩，25"};

    //需求5：得到字符串中年龄数据大于28的流
    Stream<String> arrStream = Stream.of(strArr).filter(s -> Integer.parseInt(s.split("，")[1]) > 28);

    //需求6：把使用Stream流操作完毕的数据收集到map集合中，并且遍历,字符串中姓名为键，年龄为值（int）
    Map<String, Integer> map = arrStream.collect(Collectors.toMap
                                                 (s -> s.split("，")[0], s -> Integer.parseInt(s.split("，")[1])));

    Set<String> keySet = map.keySet();
    for (String key : keySet)
    {
        Integer i = map.get(key);
        System.out.println(key + "，" + i);
    }
}
```



# 类加载器

## 类加载

- 当程序要使用某个类的时候，如果该类还没被加载到内存中，则系统会通过类的加载，类的连接，类的初始化，这三个步骤来对类进行初始化。
- 如果不出意外，JVM将会连续完成这三个步骤，所以有时候也会把这三个步骤统称为类加载或者类初始化



### 类的加载

- 将class文件读入内存，并且为之创建一个java.lang.Class对象
- 任何类被使用的时候，系统都会为之创建一个java.lang.Class对象



### 类的连接

- 验证阶段：用于检验被加载的类是否有正确的内部结构，并且和其他类协调一致
- 准备阶段：负责为类的类变量分配内存，并且设置默认初始化值
- 解析阶段：将类的二进制数据中的符号引用替换为直接引用



### 类的初始化

- 在该阶段，主要就是对类变量进行初始化
- 初始化步骤：
  1. 假如类还未被加载和连接，则程序先加载并连接该类
  2. 假如该类的直接父类还未被初始化，则先初始化其直接父类
     - **注意：**这执行这一步的时候，系统对直接父类的初始化步骤也遵循初始化步骤1~3
  3. 假如类中有初始化语句，则系统一次执行这些初始化语句
- 初始化时机：
  - 创建类的实例
  - 调用类的方法
  - 访问类或者接口的类变量，或者为该类变量赋值
  - 使用反射方式来强制创建某个类或者接口对应的java.lang.Class对象
  - 初始化某个类的子类
  - 直接使用java.exe命令来运行某个主类



### 类加载器

- 作用：
  - 将.class文件加载到内存中，并为之生成对应的java.lang.Class对象
- JVM的类加载机制：
  - 全盘负责：当一个类加载器负责加载某个Class时，该Class所依赖的和引用的其他Class也将由该类加载器负责载入，除非显示使用另一个类加载器来载入
  - 父类委托：当一个类加载器负责加载某个Class时，先让父类加载器试图加载该Class，只有在父类加载器无法加载该类时，才尝试从自己的类路径中加载该类
  - 缓存机制：保证所有加载过的Class都会被缓存，当程序需要使用某个Class对象时，类加载器先从缓存区中搜索该Class，只有当缓存区中不存在该Class对象时，系统才会读取该类对应的二进制数据，并将其转换成Class对象，存储到缓存区

- `ClassLoader`：是负责加载类的对象
  - `static ClassLoader getSystemClassLoader()`：返回用于委派的系统类加载器
  - `ClassLoader getParent()`：返回父类加载器进行委派

- Java运行时具有以下内置类加载器：
  - `Bootstrap class loader`：虚拟机的内置类加载器，**通常表示为null**，并且没有父null
  - `Platform class loader`：平台类加载器可以看到所有平台类，平台类包括由平台类加载器或其祖先定义的Java SE平台API，其实现类和JDK特定的运行时类
  - `System class loader`：应用程序类加载器，与平台类加载器不同。系统类加载器通常用于定义应用程序类路径，模块路径和JDK特定工具上的类
  - 继承关系：`System`的父类加载器为`Platform`，`Platform`的父类加载器为`Bootstrap`

```java
public static void main(String[] args)
{
    ClassLoader c1 = ClassLoader.getSystemClassLoader();
    System.out.println(c1);//AppClassLoader

    ClassLoader c2 = c1.getParent();
    System.out.println(c2);//PlatformClassLoader

    ClassLoader c3 = c2.getParent();
    System.out.println(c3);//null，Bootstrap class loader通常表示为null
}
```



## 反射

### 概述

框架的设计灵魂

- 框架：
  - 半成品软件
  - 在框架的基础上进行软件开发，简化编码

 Java反射机制

- 在运行时去获取一个类的变量和方法信息，通过获取到的信息来创建对象，调用方法的一种机制
- 由于这种动态性，可以极大的增强程序的灵活性，程序不用再编译期就完成确定，运行期仍然可以扩展



### 获取Class类的对象

- 想要通过反射去使用一个类，首先要获取该类的字节码文件对象，也就是类型为Class类型的对象
  - 使用类的class属性来获取该类对应的Class对象
    - `Student.class`将会返回`Student`类对应的Class对象
    - 多用于参数的传递
  - 调用对象的`getClass()`方法，返回该对象所属类对应的Class对象
    - 该方法是`Object`类中的方法，所有的Java对象都可以调用该方法
    - 多用于对象的获取字节码的方式
  - 使用`Class`类中的静态方法`forName(String className)`，该方法需要传入字符串参数，该字符串参数的值是某个类的全路径，也就是完整包名的路径
    - 多用于配置文件，将类名定义在配置文件中，读取文件，加载类



### 反射获取构造方法并使用

- Class类中用于获取构造方法的方法
  - `Constructor<?>[] getConstructors()`：返回所有**公共**构造方法对象的数组
  - `Constructor<?>[] getDeclaredConstructors()`：返回所有构造方法对象的数组
  - `Constructor<T>[] getConstructors(Class<?>...parameterTypes)`：返回单个**公共**构造方法对象
    - 参数是`数据类型.class`，基本数据类型也可以
  - `Constructor<T>[] getDeclaredConstructor(Class<?>...parameterTypes)`：返回单个构造方法对象
    - 参数是`数据类型.class`，基本数据类型也可以
    - `public void setAccessible(boolean flag)`：值为true，取消访问检查，可使用私有构造方法

- Constructor类中用于创建对象的方法
  - `T newInstance(Object...initargs)`：根据指定的构造方法创建对象

```java
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
{
    //获取一个类
    Class<?> c = Class.forName("com.studentmanager.Student");

    //获取类中的公共构造方法
    Constructor<?>[] cons = c.getConstructors();
    //获取类中的所有构造方法
    Constructor<?>[] decCons = c.getDeclaredConstructors();

    for (Constructor con : cons)
    {
        System.out.println(con);
    }

    for (Constructor con : decCons)
    {
        System.out.println(con);
    }

    //获取类中的一个公共构造方法
    //参数是数据类型.class，基本数据类型也可以
    Constructor<?> con = c.getConstructor(String.class, String.class);
    //获取类中的一个构造方法
    Constructor<?> decCon = c.getDeclaredConstructor(String.class, String.class, String.class, String.class);
    
    //值为true，取消访问检查
    decCon.setAccessible(true);

    //参数是new Object[]
    Object obj = con.newInstance("迪丽热巴", "28");
    Object decObj = decCon.newInstance("123", "迪丽热巴", "28", "123");
    System.out.println(obj);
    System.out.println(decObj);
}
```



### 反射获取成员变量并使用

- Class类中用于获取成员变量的方法
  - `Field[] getFields()`：返回所有**公共**成员变量对象的数组
  - `Field[] getDeclaredFields()`：返回所有成员变量对象的数组
  - `Field[] getField(String name)`：返回单个**公共**成员变量对象
  - `Field[] getDeclaredFields(String name)`：返回单个成员变量对象
- `Field`类中用于给成员变量赋值的方法
  - `void set(Object obj, Object value)`：给`obj`对象的成员变量赋值为`value`

```java
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
{
    Class<?> c = Class.forName("com.studentmanager.Student");

    Constructor<?>[] cons = c.getConstructors();

    Object obj = con.newInstance();

    Field[] fields = c.getFields();
    Field[] declaredFields = c.getDeclaredFields();

    for (Field field : fields)
    {
        System.out.println(field);
    }

    for (Field field : declaredFields)
    {
        System.out.println(field);
    }

    //不管成员变量是否公共，都用暴力反射
    //标准格式
    Field addressField = c.getField("address");
    //暴力反射
    addressField.setAccessible(true);
    addressField.set(obj, "长安");
}
```



### 反射获取成员方法并使用

- Class类中用于获取成员方法的方法
  - `Method[] getMethods()`：返回所有**公共**成员方法对象的数组，**包括继承的**
  - `Method[] getDeclaredMethods()`：返回所有成员方法对象的数组，**不包括继承的**
  - `Method[] getMethod(String name, Class<?>...parameterTypes)`：返回单个**公共**成员方法对象
  - `Method[] getDeclaredMethods(String name, Class<?>...parameterTypes)`：返回单个成员方法对象
- `Method`类中用于调用成员方法的方法
  - `Object invoke(Object obj, Object...args)：`调用obj对象的成员方法
    - `Object`：返回值类型
    - `obj`：调用方法的对象
    - `args`：方法需要的参数

```java
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
{
    Class<?> c = Class.forName("com.studentmanager.Student");

    Constructor<?> con = c.getConstructor(String.class, String.class);

    Object obj = con.newInstance("迪丽热巴", "28");

    //成员方法
    Method[] methods = c.getMethods();
    Method[] declaredMethods = c.getDeclaredMethods();

    for (Method m : methods)
    {
        System.out.println(m);
    }

    for (Method m : declaredMethods)
    {
        System.out.println(m);
    }

    Method m = c.getMethod("setSid", String.class);
    Method decm = c.getDeclaredMethod("setName", String.class);

    decm.setAccessible(true);
    decm.invoke(obj,"123");
}
```



# 模块化

## 概述

把Java拆分成N多个模块，并且允许Java程序可以根据需要选择加载程序必须的Java模块，这样就可以让Java以轻量化的方式来运行

![image-20200913154351419](https://i.loli.net/2020/09/13/gkeIuvNB1EalKrs.png)

## 模块的基本使用

### 步骤

- 创建模块（创建包，创建类，定义方法）
- 在模块的src目录下新建一个名为 module-info.java 的描述性文件，该文件专门定义模块名，访问权限，模块依赖等信息
  - 描述性文件中使用模块导出和模块依赖来进行配置并使用
- 模块中所有未导出的包都是 **模块私有的**，他们是不能在模块之外被访问的
  - 需要导出的模块下的描述性文件中配置模块导出的格式：
    - `exports 包名;`
- 一个模块要访问其他模块，必须明确指定依赖哪些模块，未明确指定依赖的模块不能访问
  - 需要依赖的模块下的描述性文件中配置模块依赖的格式：
    - `requires 模块名;`



## 模块服务的使用

### 服务

- Java提供一种服务机制，允许服务提供者和服务使用者之间完成解耦
  - 服务使用者只面向接口编程，但是不清楚提供者的实现类
- Java允许将服务接口定义在一个模块中，并使用 `uses` 语句来声明该服务接口，然后针对该服务接口提供不同的服务实现类，这些服务实现类可以分布在不同的模块中
- 服务实现模块则使用 `provides` 语句为服务接口指定实现类，服务使用者只需要面向接口编程即可



### 步骤

- 在模块一下提供一个接口，接口中定义一个抽象方法

- 提供接口的多个实现类

- 在模块一的描述性文件中添加配置

  - 模块导出：`exports 包名;`
  - 服务提供：`provides 接口名 with 实现类名`（指定该接口的服务实现类是哪个）

- 在模块二的描述性文件中添加配置

  - 声明服务接口：`uses 接口名`

- 在模块二的类中使用 `接口名` 接口提供的服务

  - `ServiceLoader`：一种加载服务实现的工具

  ```java
  //加载服务
  ServiceLoader<接口名> services = ServiceLoader.load(接口名.class);
  
  //遍历服务
  for(接口名 s : services){
      s.抽象方法名;
  }
  ```



# Junit单元测试

## 测试分类

### 概述

- 黑盒测试
  - 不需要写代码，给输入值，看程序是否能输出期望的值

- 白盒测试
  - 需要写代码，关注程序具体的执行流程



### Junit使用

- 属于白盒测试
- 步骤
  - 定义一个测试类（测试用例）
    - 建议：
    - 测试类名：被测试的类名Test	`CalculatorTest`
    - 包名：xxx.xxx.xx.test	`com.malajie.test`
  - 定义测试方法：可以独立运行
    - 方法名：test测试的方法名	`testAdd()`
    - 返回值：`void`
    - 参数列表：空参
  - 给方法加上注解`@Test`
  - 导入junit依赖环境
- 判定结果
  - 红色：失败
  - 绿色：成功
  - 一般会使用断言来处理结果
    - `Assert.assertEquals(期望结果, 运算结果)`
- 注解：
  - `@Before`初始化方法：
      * 用于资源申请，所有测试方法在执行之前都会先执行该方法
  - `@After`释放资源方法：
       * 所有测试方法执行之后都会自动执行该方法
  - `@Test`测试方法

```java
/*
  * 初始化方法：
  * 用于资源申请，所有测试方法在执行之前都会先执行该方法
  * */
@Before
public void init(){
    System.out.println("init");
}

/*
   * 释放资源方法：
   * 所有测试方法执行之后都会自动执行该方法
   * */
@After
public void close(){
    System.out.println("close");
}

@Test
public void testAdd(){
    //创建对象
    Calculator c = new Calculator();
    //调用方法
    int result = c.add(1,2);
    //断言
    Assert.assertEquals(3, result);
}
```



# 注解

## 概述

* 概念：说明程序的。给计算机看的
* 注释：用文字描述程序的。给程序员看的
* 注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。



### 作用分类

- 编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
- 代码分析：通过代码里标识的注解对代码进行分析【使用反射】
- 编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】



### JDK中预定义的一些注解

* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
* @Deprecated：该注解标注的内容，表示已过时
* @SuppressWarnings：压制警告
	* 一般传递参数all  @SuppressWarnings("all")



### 自定义注解

* 格式：

```java
元注解
    public @interfacr 注解名称{
    	属性列表;
}
```

* 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
		
		
	
	* `public interface MyAnno extends java.lang.annotation.Annotation {}`
	
* 属性：接口中的抽象方法

   * 要求：

   1. 属性的返回值类型有下列取值
      - 基本数据类型
      - String
      - 枚举
      - 注解
      - 以上类型的数组
   2. 定义了属性，在使用时需要给属性赋值
      - 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值
      - 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
      - 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略

* 元注解：用于描述注解的注解

   * `@Target`：描述注解能够作用的位置
      * `TYPE`：可以作用于类上
      * `METHOD`：可以作用于方法上
      * `FIELD`：可以作用于成员变量上
   * `@Retention`：描述注解被保留的阶段
      * `@Retention(RetentionPolicy.RUNTIME)`：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
   * `@Documented`：描述注解是否被抽取到api文档中
   * `@Inherited`：描述注解是否被子类继承

* 在程序使用(解析)注解：获取注解中定义的属性值

   * 获取注解定义的位置的对象  （Class，Method,Field）
   *  获取指定的注解
      * `getAnnotation(Class)`
      * 其实就是在内存中生成了一个该注解接口的子类实现对象
   * 调用注解中的抽象方法获取配置的属性值
   
* 大多数时候都是使用注解，而不是自定义注解

* 注解不是程序的一部分，可以理解为注解就是一个标签

* 注解主要给解析程序用

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro
{
    String className();
    String methodName();
}

@Pro(className = "annotation.Demo1", methodName = "show")
public class TestAnno
{
    public static void main(String[] args)
    {
        //解析注解
        //获取该类的字节码文件对象
        Class<TestAnno> cls = TestAnno.class;

        //获取注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*public class ProImpl implements Pro
        {
            public String className()
            {
                return "annotation.Demo1";
            }

            public String methodName()
            {
                return "show";
            }
        }
        */
        Pro an = cls.getAnnotation(Pro.class);

        //调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);
    }

}
```

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Check
{
}

public static void main(String[] args) throws IOException
{
    //创建计算器对象
    Calculator c = new Calculator();

    //获取字节码文件对象
    Class cls = c.getClass();

    //获取所有的方法
    Method[] methods = cls.getMethods();

    int num = 0;//出现异常的次数
    BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

    for (Method m : methods)
    {
        //判断方法上是否有check注解
        if (m.isAnnotationPresent(Check.class))
        {
            //有执行
            try
            {
                m.invoke(c);
            } catch (Exception e)
            {
                //捕获异常，记录到文件中
                num++;

                bw.write(m.getName() + "方法出异常了");
                bw.newLine();
                bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                bw.newLine();
                bw.write("异常原因：" + e.getCause().getMessage());
                bw.newLine();
                bw.write("--------------");
                bw.newLine();
            }

        }
    }
    bw.write("本次测试一共出现" + num + "次异常");
    bw.flush();
    bw.close();
}
```
