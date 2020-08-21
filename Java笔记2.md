# Java学习笔记2

# 类和对象

## 类

- 类是对显示生活中一类具有**共同属性**和**行为**的事物的抽象，确定对象将会拥有的属性和行为。
- 类是**对象**的**数据类型**。
- 类是具有相同属性和行为的一组对象的集合。
- 类是Java的基本组成单位。

## 对象

- **属性**：对象具有的各种特征，每个对象的每个**属性**都有特定的值。
  - 在类中通过**成员变量**来体现（类中方法外的变量）

- **行为**：对象能够执行的操作。
  - 在类中通过**成员方法**来体现（和前面的方法相比，去掉关键字**static**即可）

**类是对象的抽象；**

**对象是类的实体。**

![image-20200817150339332](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817150339332.png)



（左边：类；右边：对象）



## 对象的使用

- 创建对象
  - 格式：类名 对象名 = new 类名（）;

```java
Phone p = new Phone();
```

- 使用对象

  - 使用成员变量：

    格式：对象名.变量名

  - 使用成员方法：

    格式：对象名.方法名()

```java
p.brand;
p.Call();
```



## 对象内存图

### 单个对象

对象刚刚new出来的时候，如果成员变没有初始化，系统就会给它们一个初始值。

成员变量的内存和数组的成员内存分配相似。

![image-20200817152934308](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817152934308.png)

![image-20200817153007893](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817153007893.png)

成员方法的调用，先把成员方法加载到栈内存。调用者 s 就是前面 new 出来的 s。

![image-20200817153138772](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817153138772.png)

当方法执行完毕后，方法就会从栈内存中消失。



### 多个对象（指向不同）

成员变量的值可以不同，成员方法可以多个对象**共用**。

![image-20200817153546316](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817153546316.png)

s1和s2分别对应堆内存中001和002这两个块地址内容。

![image-20200817154115432](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817154115432.png)

这次成员方法study()的调用者是s2。



### 多个对象（指向相同）

数组的内存分配相似。

![image-20200817154305511](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817154305511.png)

此时s1和s2的值相同，都指向堆内存中001这块地址内容。

![image-20200817154512508](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817154512508.png)

通过s2来修改内容，001对应的内容发生改变。

![image-20200817154653109](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817154653109.png)

此时无论通过s1还是s2输出内容，都会输出被s2修改后的内容。



## 成员变量和局部变量

**成员变量**：**类方法外**的变量（红色框）。

**局部变量**：**方法中**的变量（蓝色框）。

![image-20200817154939224](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817154939224.png)

**区别**

|       区别       |             成员变量             |                           局部变量                           |
| :--------------: | :------------------------------: | :----------------------------------------------------------: |
|   类中位置不同   |             类方法外             |                  方法内或方法声明（形参）上                  |
| 内存中的位置不同 |              堆内存              |                            栈内存                            |
|   生命周期不同   |   随着对象的存在消失而存在消失   |            随着方法的调用而存在，调用完毕就会消失            |
|   初始化值不同   | 因为在堆内存中，有默认的初始化值 | 因为在栈内存中，没有默认的初始化值，必须先定义，赋值才能使用 |



## 封装



面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！



### 概述

- 是面对对象编程语言对客观世界的模拟，客观世界里成员变量都是隐藏在对象内部，外界无法直接操作。

**封装原则**

- 将类的某些信息隐藏在类的内部，不允许外部程序直接访问，而是通过该类提供的方法来实现对隐藏信息的操作和访问。成员变量**private**，提供对应的getXxx()和setXxx(参数)方法。

**封装好处**

- 通过方法来控制成员变量的操作，提高了代码的**安全性**。
- 把代码用方法进行封装，提高了代码的**复用性**。



### 构造方法

构造方法是一种特殊的方法，用于创建对象，主要是完成对象数据的初始化。

```java
public class 类名
{
    修饰符 类名（参数）
    {
        //构造方法内书写内容
    }
}
```

- 构造方法的创建
  - 如果没有定义构造方法，系统将给出一个**默认**的**无参构造方法**。
  - 如果定义了构造方法，系统将不再提供默认的构造方法。
- 构造方法的重载
  - 如果自定义了**带参构造方法**，还要使用**无参构造方法**，就必须再写一个**无参构造方法**。

**推荐：无论是否使用，都手工书写无参构造方法。**



### 标准类的制作

1. 成员变量
   - 使用**private**修饰
2. 构造方法
   - 提供一个**无参构造方法**
   - 提供一个**带多参数的构造方法**
3. 成员方法
   - 提供每一个成员变量对应的**getXxx()**和**setXxx(参数)**方法。
   - 提供一个显示对象信息的**show()**方法。
4. 创建对象并且为其成员变量赋值的两种方法
   - **无参构造方法**创建对象后直接用**setXxx(参数)**方法赋值
   - **多参构造方法**直接创建带有**属性值**的对象





### "private"关键字

- 是一个权限修饰符。
- 可以修饰成员（成员变量和成员方法）。
- 作用时保护成员不被别的类使用，被**private**修饰的成员只能在本类中才能访问。

针对**private**修饰的成员变量，如果需要被其他类使用，一般会提供相应的操作，如：

- 提供”get变量名（）“方法，用于**获取**成员变量的值，方法用**public**修饰。
- 提供”set变量名（参数）“方法，用于**设置**成员变量的值，方法用**public**修饰。



### "this"关键字

- this修饰的变量用于指代成员变量
  - 方法的形参如果和成员变量同名，不带**this**修饰的变量指的是形参，而不是成员变量。
  - 方法的形参没有和成员变量同名，不带**this**修饰的变量指的是成员变量。

![image-20200817162235346](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817162235346.png)

- 使用**this**的目的就是解决局部变量隐藏成员变量的问题。
- **this**代表所在类的对象引用，方法被哪个对象对用，**this**就代表哪个对象（方法的**调用者**）。

![image-20200817162519586](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817162519586.png)





## String类

### 概述

- String在java.lang包下，使用时不需要导包。

- Java中所有的字符串文字都被实现为String类的实例，即Java中所有双引号字符串，都是String类的对象。



### 特点

- String不可变，它们的值在创建后不能被更改。
- 虽然String的值是不可变的，但是它们可以被共享。
- String效果上相当于字符数组（char[]），但是底层原理是字节数组（byte[]）。



### 构造方法

|          方法名           |                   说明                    |
| :-----------------------: | :---------------------------------------: |
|      public String()      |  创建一个空白字符串对象，不含有任何内容   |
| public String(char[] chs) |   根据字符数组的内容，来创建字符串对象    |
| public String(byte[] bys) |   根据字节数组的内容，来创建字符串对象    |
|     String s = "abc"      | 直接赋值的方式创建字符串对象，内容是"abc" |

**推荐使用直接赋值的方式创建String**



### String对象的特点

- 通过**new**创建的字符串对象，每一次**new**都会申请一个内存空间，虽然**内容相同**，但是**地址值不同**。

  如图中s1和s2的**参考（ref）的地址（内容）相同**，但是他们本身的地址（002，003）不同。

- 以直接赋值方式给出的字符串，只要序列相同（顺序和大小写），无论在程序中出现多少次，JVM都只会创建一个String对象，并且在字符串池中维护。

  如图中s3和s4都通过地址004指向常量池中004所对应的内容。

![image-20200817201307637](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200817201307637.png)



### 字符串的比较

使用 **==** 做比较

- 基本类型：比较的是**数据值**是否相同
- 引用类型：比较的是**地址值**是否相同

字符串是**对象**，它比较内容是否相同是通过一个方法实现的：**equals()**。

- public boolean equals(Object anObject)：将此字符串和指定对象进行比较，由于比较的是字符串对象，所以参数可以直接传递字符串对象。

```java
        char[] chs = {'a',  'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        String s3 = "abc";
        String s4 = "abc";

        //比较地址
        System.out.println(s1 == s2);//false,通过new创建,不同地址值
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//true,通过赋值创建,地址值是指向常量池中的同一个地址
        System.out.println("-----------------");

        //比较内容
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s3.equals(s4));//true
```



## StringBuilder

### 概述

当字符串拼接的时候，先创建**要添加的内容**，再进行拼接，然后再**申请一个新的空间**存放拼接完的内容。

每次进行字符串拼接，都会构建一个新的String对象，耗时，浪费内存空间，且无法避免。

![image-20200819144649361](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200819144649361.png)

StringBuilder是一个内容可变的字符串类，我们可以把它看成一个容器。

- String：内容不可变
- StringBuilder：内容可变



### 构造方法

|              方法名              |                     说明                     |
| :------------------------------: | :------------------------------------------: |
|      public StringBuilder()      | 创建一个空白的可变字符串对象，不含有任何内容 |
| public StringBuilder(String str) |     根据字符串内容，来创建可变字符串对象     |



### 添加和返回方法

|                方法名                 |              说明              |
| :-----------------------------------: | :----------------------------: |
| public StringBuilder append(任意类型) | 添加数据，并且返回对象**本身** |
|    public StringBuilder reverse()     |       返回相反的字符序列       |

```java
StringBuilder sb = new StringBuilder();
sb.append("1");
sb.append("2");
sb.append("3");
System.out.println(sb);//输出为：123
//链式编程
sb.append("7").append("8").append("9");//因为append返回对象本身，所以可以继续调用append方法
System.out.prinlin(sb);//输出为：123789
```



### StringBuilder和String的相互转化

StringBuilder中的添加和反转方法十分方便，但是String不能直接调用，因为StringBuilder和String类型不同，所以需要进行类型的转化。

- StringBuilder转String
  - public String toString()：通过**toString()**就可以实现把StringBuilder转换为String
- String转StringBuilder
  - public StringBuilder(String str)  ：通过StringBuilder的构造方法**StringBuilder(String str)**

```java
public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
    	//String s = sb;报错，错误写法
        String s = sb.toString();
    	System.out.println(s);
    }

public static void main(String[] args)
    {
    	String s = "hello";
        StringBuilder sb = new StringBuilder(s);
    	System.out.println(sb);
    }
```



# 集合

## 概述

### 特点

提供一种储存空间可变的存储模型，存储的数据容量可以发生改变。

**ArrayList<E>：**

- 可调整大小的数组实现
- <E>：是一种特殊的数据类型，泛型
- 在所有出现<E>的地方都可以使用引用数据类型替换
  - ArrayList<String>, ArrayList<Student>

## ArrayList的构造方法和添加方法

|                方法名                 |                  说明                  |
| :-----------------------------------: | :------------------------------------: |
|          public ArrayList()           |          创建一个空的集合对象          |
|        public boolean add(E e)        |   将指定的元素追加到此集合的**末尾**   |
| public void add(int index, E element) | 在此集合中的**指定位置**插入指定的元素 |

```java
    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        
        //输出：[],arrayList里面没有元素时返回"[]"
        System.out.println(arrayList);
        
        arrayList.add("frank");
        arrayList.add("la");

        //输出：true，因为add(E e)返回Boolean值表示是否添加成功
        System.out.println(arrayList.add("jie"));
        
        //输出：[frank, la, jie]，"jie"添加到arrayList末尾
        System.out.println(arrayList);
        
        //在索引1的位置添加"ma"
        arrayList.add(1, "ma");

        //输出：[frank, ma, la, jie]，后面的元素往后推了一位
        System.out.println(arrayList);
        
        //不可以跳过索引添加元素，会造成索引越界
        //arrayList.add(5, "hello");报错
        
    }
```



## ArrayList集合的常用方法

|               方法名                |                    说明                    |
| :---------------------------------: | :----------------------------------------: |
| public **boolean remove**(Object o) |     删除指定元素，返回删除**是否成功**     |
|   public **E remove**(int index)    |     删除指定元素，返回**被删除的元素**     |
| public E set(int index, E element)  | 修改指定索引处的元素，返回**被修改的元素** |
|       public E get(int index)       |            返回指定索引处的元素            |
|          public int size()          |            返回集合中的元素个数            |



























# 典型算法

## 求水仙花数

一个三位数，它的个位、十位、百位的数字的立方和等于原数，比如：3³+7³+1³ = 371。

- 个位数求法：原始数字对 10 取余，
  371 % 10 = 1，即 x % 10；

- **十位数求法：**原始数字除以10，此时十位数就移动到百位上，再对 10 取余，
  371 / 10 = 37， 37 % 10 = 7，即 x % 10；

- 百位数求法：原始数字除以100（整除），再对10取余

  371 / 100 = 3，即 x /100 % 10；

- **求任意数字的指定位置上的数值：**先整除把对应数字转移到个位数上，再取余。

```java
for(int i = 100; i < 1000; i++)
{
    int ge = i % 10;
    int shi = i / 10 % 10;
    int bai = i / 100 % 10;
    
    if(ge * ge * ge + shi * shi * shi + bai * bai * bai == i)
    {
        System.out.println(i);
    }
}
```



## 斐波那契数列

0、1、1、2、3、5、8、13、21、34...

- 规律：*F*(1)=1，*F*(2)=1, *F*(n)=*F*(n - 1)+*F*(n - 2)（*n* ≥ 3，*n* ∈ N*）

```java
    public static void rabbits()
    {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        //从第三个数开始
        for (int i = 2; i < arr.length; i ++)
        {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[19]);
    }
```



## 百钱百鸡

一只公鸡5块钱，一只母鸡3块钱，三只小鸡1块钱，小明用100块钱买了100只鸡，求公鸡母鸡小鸡各多少只？

- 公鸡：0 <= x <=20

- 母鸡：0 <= y <=33
- 小鸡：0 <= z <=100 → z = 100 - x - y → 总共100只鸡
- 5x + 3y + z/3 = 100 → 100块钱
- z % 3 =0 → 1块钱三只鸡，所以z一定是3的倍数

```java
 public static void BuyChicken()
    {
        for(int x = 0; x <= 20; x++)
        {
            for (int y = 0; y <=33; y++)
            {
                int z = 100 - x -y;
                if (z % 3 == 0 && 5*x + 3*y + z/3 == 100)
                {
                    System.out.println("公鸡有：" + x + "，" + "母鸡有：" + y + "，" + "小鸡有：" + z);
                }
            }
        }
    }
```

 

## 比较两个数组的内容是否相同

- 先比较两个数组的长度
- 如果长度相同，先排序sort(arr)
- 遍历数组进行比较

```java
    public static boolean CompareArray()
    {
        int[] arr1 = {11,22,33,44,55};
        int[] arr2 = {11,22,33,55,44};

        //先排序
        sort(arr1);
        sort(arr2);

        if (arr1.length != arr2.length)
        {
            return false;
        }
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != arr2[i])
            {
                return false;
            }
        }
        return true;
    }
```



## 查找

输入一个数据，查找该数据在数组中的索引并且输出。

- 定义一个索引变量，默认为-1
- 遍历数组获取数组中每一个元素
- 拿输入的数据和每一个元素进行比较，相同时把对应的索引值赋值给索引变量并且**结束循环（break）**

```java
    public static int getIndex(int[]arr, int num)
    {
        int index = -1;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == num)
            {
                index = i;
                break;
            }
        }
        return index;
    }
```



## 数组反转

- 创建一个临时空间
- 第一个和最后一个元素交换；第二个和倒数第二个交换...
- 循环遍历数组时，定义两个索引变量，判断条件是**开始索引小于等于结束索引**

![image-20200816215214220](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200816215214220.png)



```java
    public static void Reverse(int[]arr)
    {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
```



## 用户登陆

已知用户名和密码，实现模拟用户登陆。总共有三次机会，登陆后，给出相应的提示。

思路：

- 已知用户名和密码用字符串表示
- 键盘输入要登陆的用户名和密码，Scanner实现
- 拿键盘输入的用户名、密码和已知的用户名、密码进行比较。字符串比较，用equals()实现
- 用循环实现多次机会，用for循环，登陆成功的时候，用break结束循环

```java
		String userName = "frank";
        String password = "123";


        for (int i = 0; i < 3;i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String inputUserName = sc.nextLine();
            System.out.println("请输入密码：");
            String inputPassword = sc.nextLine();

            if (userName.equals(inputUserName) && password.equals(inputPassword))
            {
                System.out.println("登陆成功");
                break;
            }
            else if (2-i == 0)
            {
                System.out.println("登陆失败，你的账户已被锁定，请与管理员联系");
            }
            else
            {
                System.out.println("登陆失败，你还有" + (2-i) + "次机会");
            }
        }
```



## 遍历字符串

键盘输入一个字符串，程序实现在控制台输出。

思路：

- 键盘输入字符串，用Scanner实现
- 获取字符串中每一个字符
  - public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始
- 获取字符串长度
  - public int length()：返回字符串的长度
  - 数组长度：数组名.length
  - 字符串长度：字符串对象.length()
- 遍历字符串通用格式

```java
for(int i = 0; i < s.length(); i++)
{
	s.charAt(i);//指定索引处的字符值
}
```



## 统计字符类型个数（大写字母，小写字母，数字）

键盘输入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现次数（不考虑其他字符）。

思路：

- 键盘输入字符串，用Scanner实现
- 要统计三种类型的字符个数，定义三个统计变量，初始值为0
- 遍历字符串，得到每一个字符
- 判断每一个字符属于哪种类型，对应类型统计变量+1
  - 假如⭐是个字符，要判断属于哪种类型，直接判断⭐是否在对应范围内就可以了
  - 大写字母：⭐>='A' && ⭐<= 'Z'
  - 小写字母：⭐>='a' && ⭐<= 'z'
  - 数字：⭐>='0' && ⭐<= '9'

```java
    public static void CountStrType(String s)
    {
        int cap = 0;
        int low = 0;
        int num = 0;


        for (int i = 0; i < s.length(); i ++)
        {
            char ch = s.charAt(i);
            if (ch >='A' && ch <= 'Z')
            {
                cap++;
            }
            else if (ch>='a' && ch<= 'z')
            {
                low++;
            }
            else if (ch>='0' && ch<= '9')
            {
                num++;
            }
        }
        System.out.println("大写字母有：" + cap + "个");
        System.out.println("小写字母有：" + low + "个");
        System.out.println("数字有：" + num + "个");
    }
```



## 字符串拼接

定义一个方法，把int数组中的数据按照指定格式拼接成一个字符串返回，调用该方法并输出。

例如，数组为int[] arr = {1,2,3}，执行方法后输出结果为：[1,2,3]

### String

思路：

- 定义一个int类型的数组，用静态初始化完成元素的初始化
- 定义一个方法，把int数组中的数据按照指定格式拼接成一个字符串返回。返回类型是String，参数是int[] arr
- 在方法中遍历数组，用一个变量接受结果

```java
    public static String ArrayToString(int[] arr)
    {
        String s = "";

        s += "[";

        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length -1)
            {
                s += arr[i];
            }
            else
            {
                s += arr[i];
                s += ", ";
            }
        }
        s += "]";

        return s;
    }
```



### StringBuilder

思路：

- 定义一个int类型的数组，用静态初始化完成元素的初始化
- 定义一个方法，把int数组中的数据按照指定格式拼接成一个字符串返回。返回类型是String，参数是int[] arr
- 在方法中用StringBuilder按照要求进行拼接，并且转化成String返回
- 调用，用一个变量接受结果

```java
    public static String ArrayToStringNew(int[] arr)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <arr.length; i++)
        {
            if (i == arr.length -1)
            {
                sb.append(arr[i]);
            }
            else
            {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");
        
        String s = sb.toString();
        return s;
    }
```



## 字符串反转

定义一个方法实现字符串反转。键盘输入一个字符串，调用方法后输出。

例如，输入abc，输出cba。

### String

思路：

- 键盘输入字符串，用Scanner实现
- 定义一个方法实现字符串反转。返回类型String，参数String s
- 在方法中倒着遍历String，然后把每一个得到的字符拼接成字符串返回

```java
    public static String ReverseString(String s)
    {
        String rs = "";

        for (int i = s.length() - 1; i >=0; i--)
        {
            rs += s.charAt(i);
        }
        return rs;
    }
```



### StringBuilder

思路：

- 键盘输入字符串，用Scanner实现
- 定义一个方法实现字符串反转。返回类型String，参数String s
- 在方法中用StringBuilder实现字符串反转，并且转化成String返回
- 调用，用一个变量接受结果

```java
    public static String ReverseStringNew(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        return s;

        //匿名对象，一行代码解决
        //return new StringBuffer(s).reverse().toString();等价于上面三行代码
    }
```



## 存储字符串并且遍历（集合）

创建一个存储字符串的**集合**，存储3个字符串元素，并且遍历。

思路：

- 创建集合对象

- 向集合添加字符串对象

- 遍历集合，首先要能够获取集合中的每一个元素，通过get(int index)实现

- 遍历集合，其次要能够获取集合测长度，通过size()实现

- 遍历集合的通用格式

  ```java
  for(int i = 0; i < arrayList.size(); i++)
  {
      arrayList.get(i) //就是指定索引处的元素
  }
  ```



## 学生管理系统项目

**思路：**

1. 定义学生类
2. 主界面的代码编写
3. 添加学生的代码编写
4. 查看学生的代码编写
5. 删除学生的代码编写
6. 修改学生的代码编写

### 定义学生类

**推荐：快捷键（Ctrl + INSERT）快速生成构造函数和get/set方法**

- 学生类：Student
- 成员变量：
  1. 学号：sid
  2. 姓名：name
  3. 年龄：age
  4. 居住的：address
- 构造方法：
  1. 无参构造
  2. 带四个参数的构造
- 成员方法：每个成员变量给出对应的get/set方法

```JAVA
package com.StudentManager;

public class Student
{
    private String sid;
    private String name;
    private String age;
    private String address;

    public Student()
    {
    }

    public Student(String sid, String name, String age, String address)
    {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getSid()
    {
        return sid;
    }

    public void setSid(String sid)
    {
        this.sid = sid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}

```



### 主界面的代码编写

![image-20200819211031546](C:\Users\Frank\AppData\Roaming\Typora\typora-user-images\image-20200819211031546.png)

**思路：**

- 输出语句完成主界面的编写
- Scanner实现键盘录入
- 用switch完成操作选择
- 用循环再次回到主界面（System.exit (0);//JVM退出

```java
public static void main(String[] args)
    {
        while (true)
        {
            //主界面
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1、添加学生信息");
            System.out.println("2、删除学生信息");
            System.out.println("3、修改学生信息");
            System.out.println("4、查看所有学生信息");
            System.out.println("5、退出");
            System.out.println("请输入你的选择：");

            //Scanner实现键盘录入
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            switch (line)
            {
                case "1":
                {
                    System.out.println("添加学生信息");
                    break;
                }
                case "2":
                {
                    System.out.println("删除学生信息");
                    break;
                }
                case "3":
                {
                    System.out.println("修改学生信息");
                    break;
                }
                case "4":
                {
                    System.out.println("查看所有学生信息");
                    break;
                }
                case "5":
                {
                    System.out.println("感谢使用");
                    System.exit(0);//JVM虚拟机退出(程序退出)
                }

            }
        }
    }
```



### 添加学生的代码编写

**思路：**

- 键盘录入选择添加学生资料
- 定义一个方法用于添加学生
  - 显示提示信息，提示要输入的信息
  - 键盘录入学生对象所需要的数据
  - 创建学生对象，把键盘录入的数据赋值给学校对象的成员变量
  - 将学生对象添加到集合中保存起来
  - 给出添加成功的信息
- 调用方法

```java
public static void addStudent(ArrayList<Student> arrayList)
    {
        Scanner scanner = new Scanner(System.in);
        String sid;

        //让程序回到这里，用循环实现
        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否重复
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                System.out.println("输入学号已经被使用，请重新输入");
            }
            else
            {
                break;
            }
        }
        System.out.println("请输入学生的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入学生的年龄：");
        String age = scanner.nextLine();
        System.out.println("请输入学生的地址：");
        String address = scanner.nextLine();

        //创建学生对象，把信息赋值给成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //添加到集合中
        arrayList.add(s);

        //给出添加成功的提示
        System.out.println("添加成功");
    }
```



### 查看学生的代码编写

**思路：**

- 键盘录入选择添加学生资料
- 定义一个方法用于查看学生
  - 判断集合中是否有数据，如果没有显示提示信息
  - 显示表头信息
  - 将集合中的数据提取出来按照对应格式显示学生信息，年龄补充“岁”
- 调用方法

**推荐：用 \t （Tab）来进行缩进，调整格式。判断没有学生信息，用 return 跳出方法**

```java
    public static void findAllStudent(ArrayList<Student> arrayList)
    {
        //判断集合中是否有数据，如果没有显示提示信息
        if (arrayList.size() == 0)
        {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }

        //显示表头信息，\t就是按下Tab进行缩进
        System.out.println("学号\t姓名\t年龄\t\t居住地");

        //将集合中的数据提取出来按照对应格式显示学生信息，年龄补充“岁”
        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t\t" + s.getAddress());
        }
    }
```



### 删除学生的代码编写

**思路：**

- 键盘录入选择删除学生资料
- 定义一个方法用于删除学生
  - 显示提示信息
  - 键盘录入要删除的学生的学号
  - 遍历集合将对应的学生对象从集合中删除
  - 给出删除成功的信息
- 调用方法

```java
public static void deleteStudent(ArrayList<Student> arrayList)
    {
        Scanner scanner = new Scanner(System.in);

        //键盘录入要删除的学生的学号
        String sid;

        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否存在
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                break;
            }
            else
            {
                System.out.println("输入学号有误，请重新输入");
            }
        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            Student s = arrayList.get(i);
            if (s.getSid().equals(sid)/*s.getSid() == sid*/)
            {
                arrayList.remove(i);
                System.out.println("删除学生成功");
                break;
            }
        }
    }
```

|  关键字  |                             作用                             |                             结束                             |
| :------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|  break   |   跳出所在的当前整个循环，到外层代码继续执行。（跳出一层）   | 不仅可以结束其所在的循环，还可结束其外层循环，但一次只能结束一种循环。 |
|  return  | 直接返回函数，所有该函数体内的代码（包括循环体）都不会再执行。 |              同时结束其所在的循环和其外层循环。              |
| continue | 跳出本次循环，从下一个迭代继续运行循环，内层循环执行完毕，外层代码继续运行。 |             结束本次循环，将接着开始下一次循环。             |



### 修改学生的代码编写

**思路：**

- 键盘录入选择修改学生资料
- 定义一个方法用于修改学生
  - 显示提示信息
  - 键盘录入要修改的学生的学号
  - 键盘录入要修改的学生对应的信息
  - 给出修改成功的信息
- 调用方法

```java
public static void updateStudent(ArrayList<Student> arrayList)
    {
        //键盘录入要修改的学生的学号
        Scanner scanner = new Scanner(System.in);

        //创建对象
        Student s = new Student();
        String sid;

        //判断集合中是否有一个对象的学号和输入的相同
        //相同继续执行，不同重新输入
        while (true)
        {
            //录入学生信息
            System.out.println("请输入学生的学号：");
            sid = scanner.nextLine();

            //判断学号是否存在
            boolean flag = isUsed(arrayList, sid);
            if (flag)
            {
                break;
            }
            else
            {
                System.out.println("输入学号有误，请重新输入");
            }
        }

        //找出对应的对象进行修改
        for (int i = 0; i < arrayList.size(); i++)
        {
            s = arrayList.get(i);
            if (s.getSid().equals(sid)/*s.getSid() == sid*/)
            {
                //选择要修改的信息，case实现
                System.out.println("请选择要修改的信息");
                System.out.println("1、修改学生学号");
                System.out.println("2、修改学生姓名");
                System.out.println("3、修改学生年龄");
                System.out.println("4、修改学生居住地");
                String line = scanner.nextLine();

                switch (line)
                {
                    case "1":
                        System.out.println("请输入新的学生学号");
                        String newSid = scanner.nextLine();
                        s.setSid(newSid);
                        break;
                    case "2":
                        System.out.println("请输入新的学生姓名");
                        String newName = scanner.nextLine();
                        s.setName(newName);
                        break;
                    case "3":
                        System.out.println("请输入新的学生年龄");
                        String newAge = scanner.nextLine();
                        s.setAge(newAge);
                        break;
                    case "4":
                        System.out.println("请输入新的学生居住地");
                        String newAddress = scanner.nextLine();
                        s.setAddress(newAddress);
                        break;
                }

                //把修改好的数据放回集合中
                arrayList.set(i, s);
                System.out.println("修改成功");
                break;
            }
        }
    }
```



### 解决删除/修改学生学号不存在问题

**思路：**

- 在修改/删除学生操作前，对学号是否存在进行判断
  - 如果不存在，显示信息
  - 如果存在，执行修改/删除操作





### 解决添加学生学号重复问题

**思路：**

- 定义一个方法，对学号是否被使用进行判断
  - 如果和集合中某一个学生学号相同，返回true
  - 都不同，返回false
- 在添加学生录入学号后调用方法
  - 如果返回true，弹出提示，重新输入学号
  - 返回false，正常添加学生对象

```java
public static boolean isUsed(ArrayList<Student> arrayList, String sid)
    {
        boolean flag = false;

        for (int i = 0; i <arrayList.size();i++){
            Student s = arrayList.get(i);
            if (s.getSid().equals(sid))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
```

























# 爬虫

技术点：

1. URL类：访问网络
2. IO流：传输数据
3. 正则表达式：解析数据

```java
package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static List<String> webCrawler() throws IOException
    {
        //装载爬取到的新闻数据的容器
        List<String> list = new ArrayList<String>();

        //定义变量，存放要爬取的网址
        String strUrl = "https://news.baidu.com";

        //访问网页，创建URL对象
        URL url = new URL(strUrl);

        //传输数据 java io
        //在程序和服务器之间建立数据传输通道
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        //传输数据
        String strRead = "";

        //定义正则表达式
        String aPattern = "<a.*?href=\"(.*?)\".*?>(.*?)<\\/a>";

        while ((strRead = br.readLine()) != null)
        {
            //解析数据，Pattern.compile第二个参数是忽略大小写
            Matcher m = Pattern.compile(aPattern, Pattern.CASE_INSENSITIVE).matcher(strRead);

            if (m.find())
            {
                //2表示aPattern中第二个括号中的内容
                //System.out.println("新闻信息 ：" + m.group(2) + "(" + m.group(1) + ")");
                list.add(m.group(2) + "(" + m.group(1) + ")");
            }
        }
        return list;
    }
}
```



# Apache POI实现办公自动化

Excel各种库，自动发邮件stmp库，zmail库，操作微信发信息itchat。

**导入POI所有的jar文件！！！**

**导入POI所有的jar文件！！！**

**导入POI所有的jar文件！！！**

- HSSF：提供读写Microsoft Excel **XLS格式**档案的功能。
- XSSF：提供读写Microsoft Excel OOXML **XLSX格式**档案的功能。
- HWPF：提供读写Microsoft **Word DOC97格式**档案的功能。
- XWPF：提供读写Microsoft Word **DOC2003格式**档案的功能。
- HSLF：提供读写Microsoft **PowerPoint格式**档案的功能。
- HDGF：提供读Microsoft **Visio格式**档案的功能。
- HPBF：提供读Microsoft **Publisher格式**档案的功能。
- HSMF：提供读Microsoft **Outlook格式**档案的功能。



```java
//写EXCEL
	public static XSSFWorkbook importData(List<String> news)
    {
        //新建excel文件(.xls)
        XSSFWorkbook wb = new XSSFWorkbook();

        //创建工作表sheet表
        XSSFSheet sheet = wb.createSheet();

        //创建表头
        XSSFRow head = sheet.createRow(0);//第一行

        //创建单元格
        XSSFCell cell1 = head.createCell(0);//第一个单元格
        cell1.setCellValue("序号");

        XSSFCell cell2 = head.createCell(1);//第二个单元格
        cell2.setCellValue("新闻");

        //构建新闻数据
        int rowNum = 1;//行号，现在是第二行
        for (String n:news)
        {
            XSSFRow row = sheet.createRow(rowNum);//第二行
            XSSFCell cell;

            cell = row.createCell(0);//第一个单元格
            cell.setCellValue(rowNum);

            cell = row.createCell(1);//第二个单元格
            cell.setCellValue(n);

            rowNum += 1;
        }

        return wb;//此时生成的表格还在内存中
    }
```



```java
	public static void main(String[] args) throws IOException
    {
        //爬取新闻
        List<String> news = new ArrayList<String>();
        news = webCrawler();

        //写入Excel
        XSSFWorkbook wb = WriteExcel.importData(news);//生产Excel文件
        //将Excel文件写入磁盘
        File file = new File("G:/news.xlsx");
        FileOutputStream fileOut = new FileOutputStream(file);
        wb.write(fileOut);
        fileOut.flush();//刷新缓存，将数据输出到内存

        //从Excel文件中读取新闻数据打印到控制台
        List<String> news2 = new ArrayList<String>();
        news2 = ReadExcel.readExcel("G:/news.xlsx");
        for (String str:news)
        {
            System.out.println(str);
        }
```



```java
//读EXCEL
    public static List<String> readExcel(String fileName) throws IOException
    {
        List<String> list = new ArrayList<String >();

        //获取excel表格
        File file = new File(fileName);//文件IO流，用于读写文件
        FileInputStream inputStream = new FileInputStream(file);//文件IO流，用于读写文件

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //读取Excel文件中的数据
        XSSFSheet sheet = wb.getSheetAt(0);
        //解析每一行的数据，构造数据对象
        int rowStartAt = 1;//数据第一行,即Excel表格的第二行
        int rowEndAt = sheet.getPhysicalNumberOfRows();//有数据的最后一行

        for (int rowNum = rowStartAt; rowNum < rowEndAt; rowNum ++)
        {
            XSSFRow row = sheet.getRow(rowNum);//获取一行
            XSSFCell cell;
            int cellNum = 1;
            //获取新闻
            cell = row.getCell(cellNum);
            String name = cell.getStringCellValue();//获取单元格的内容
            list.add(name);
        }
        return list;

    }
```

