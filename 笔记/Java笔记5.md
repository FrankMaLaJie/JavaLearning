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





