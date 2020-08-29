# Java学习笔记1

# 常用DOS命令

|        指令         |                说明                |
| :-----------------: | :--------------------------------: |
|      盘符名称       | 盘符切换。D:→回车，表示切换到D盘。 |
|         dir         |       查看当前路径下的内容。       |
|       cd目录        |       进入单级目录。cd steam       |
|        cd ..        |           返回上级目录。           |
| cd 目录1\目录2\.... |       进入多级目录。cd steam       |
|        cd \         |          返回到盘符目录。          |
|         cls         |               清屏。               |
|        exit         |        退出命令提示符窗口。        |

![image-20200810154333902](https://i.loli.net/2020/08/22/jHW9DRBVEuS8Lit.png)



# 关键字

**关键字**：就是被赋予特殊含义的单词。

- 关键字的字母全部都是**小写**。

**输出语句**

```java
System.out.println("内容");//输出内容并且换行
System.out.print("内容");//没有ln的，输出内容不换行
System.out.println();//直接输入这个语句，起到换行的作用
```



## 内置数据类型

**byte：**

- byte 数据类型是8位、有符号的，以二进制补码表示的整数；
- 最小值是 **-128（-2^7）**；
- 最大值是 **127（2^7-1）**；
- 默认值是 **0**；
- byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
- 例子：byte a = 100，byte b = -50。

**short：**

- short 数据类型是 16 位、有符号的以二进制补码表示的整数
- 最小值是 **-32768（-2^15）**；
- 最大值是 **32767（2^15 - 1）**；
- Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
- 默认值是 **0**；
- 例子：short s = 1000，short r = -20000。

**int：**

- int 数据类型是32位、有符号的以二进制补码表示的整数；
- 最小值是 **-2,147,483,648（-2^31）**；
- 最大值是 **2,147,483,647（2^31 - 1）**；
- 一般地整型变量默认为 int 类型；
- 默认值是 **0** ；
- 例子：int a = 100000, int b = -200000。

**long：**

- long 数据类型是 64 位、有符号的以二进制补码表示的整数；
- 最小值是 **-9,223,372,036,854,775,808（-2^63）**；
- 最大值是 **9,223,372,036,854,775,807（2^63 -1）**；
- 这种类型主要使用在需要比较大整数的系统上；
- 默认值是 **0L**；
- 为了防止整数过大，**long**类型后面要加上**" L "**。
- 例子： long a = 100000L，Long b = -200000L。
  "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。

**float：**

- float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
- float 在储存大型浮点数组的时候可节省内存空间；
- 默认值是 **0.0f**；
- 浮点数不能用来表示精确的值，如货币；
- 例子：float f1 = 234.5f。
- 为了防止类型不兼容，**float**后面要加上**" F "**。

**double：**

- double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
- 浮点数的默认类型为double类型；
- double类型同样不能表示精确的值，如货币；
- 默认值是 **0.0d**；
- 例子：double d1 = 123.4。

**boolean：**

- boolean数据类型表示一位的信息；
- 只有两个取值：true 和 false；
- 这种类型只作为一种标志来记录 true/false 情况；
- 默认值是 **false**；
- 例子：boolean one = true。

**char：**

- char类型是一个单一的 16 位 Unicode 字符；
- 最小值是 **\u0000**（即为0）；
- 最大值是 **\uffff**（即为65,535）；
- char 数据类型可以储存任何字符；
- 例子：char letter = 'A';。

## 引用数据类型

+ 类（class）
+ 接口（interface）
+ 数组（[ ]）

# 类型转换

**数据类型转换必须满足如下规则：**

1.  不能对boolean类型进行类型转换。

2. 不能把对象类型转换成不相关类的对象。

3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。

4. 转换过程中可能导致溢出或损失精度，例如：

   ```java
   int i =128;   
   byte b = (byte)i;
   ```

   因为 byte 类型是 8 位，最大值为127，所以当 int 强制转换为 byte 类型时，值 128 时候就会导致溢出。

5.  浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入，例如

   ```java
   (int)23.7 == 23;        
   (int)-45.89f == -45
   ```



**自动类型转换**：把一个表示 *<u>数据范围小</u>* 的数值或者变量赋值给另一个表示 <u>*数据范围大*</u> 的变量。

![image-20200810175942765](https://i.loli.net/2020/08/22/F9hMvX1jRBePqaU.png)

**强制类型转换**：把一个表示 *<u>数据范围大</u>* 的数值或者变量赋值给另一个表示 <u>*数据范围小*</u> 的变量。

- 条件是转换的数据类型必须是兼容的。
- 格式：目标数据类型 变量名 = （目标数据类型）值或者变量



# 运算符

## 字符“+”的操作

**char字符是可以和整型进行相加。**

+ 字符**‘ A ’**对应整数**65**。（A-Z是连续的）

+ 字符**‘ a ’**对应整数**97**。（a-z是连续的）

+ 字符**‘ 0 ’**对应整数**48**。（0-9是连续的）

算数表达式钟**包含多个基本数据类型**的值时，整个算术表达式的类型会**自动进行提升**。

整个表达式的类型自动提升到表达式中**最高等级操作数**同样的类型。

等级顺序：byte, short, char → int → long → float → double



当 “+” 操作中出现字符串时，这个 ”+“ 是**字符串连接符**，而不是算数运算；

当连续进行 “+” 操作时，从左到右逐个执行，例如：

```java
"马拉杰"+666 == "马拉杰666";
3+3+"马拉杰" == "6马拉杰"
```



## 赋值运算符

以下运算符底层隐含了**强制类型转换**

| 符号 |    作用    |           说明           |
| :--: | :--------: | :----------------------: |
|  =   |    赋值    | a = 10，将10赋值给变量a  |
|  +=  |  加后赋值  |  a += b，将a+b的值赋给a  |
|  -=  |  减后赋值  |  a -= b，将a-b的值赋给a  |
|  *=  |  乘后赋值  | a *= b，将a *b的值赋给a  |
|  /=  |  除后赋值  |  a /= b，将a/b的值赋给a  |
|  %=  | 取余后赋值 | a %= b，将a/b的余数赋给a |

```java
int i = 10;
i += 20; i = i +20; (i = 30)

short s = 10;
s/*(short)*/ = s/*(short)*/ + 20/*(int)*/; (因为数据类型不兼容所以导致报错)

s += 20; s = (short)(s + 20); (s = 30)

```



## 自增自减运算符

- ++ 和 -- 单独使用的时候，结果是一样的。

- 参与操作的时候，放在前面就是，先拿变量做++或者--，后拿变量参与操作。

  参与操作的时候，放在后面就是，先拿变量参与操作，后拿变量做++或者--。**（从左到右）**

  ```java
  int i = 10;
  int j = ++i;(j == 11)//i先做++再赋值
  int k = i++;(k == 10，i == 11)//先赋值，i再++
  ```

## 逻辑运算符

- &无论左边真假，右边都要执行。

  &&如果左边为真，右边执行；**如果左边为假，右边不执行。**

- |无论左边真假，右边都要执行。

  ||如果左边为假，右边执行；**如果左边为真，右边不执行。**

## 三元运算符

- 格式：关系表达式 **？** 表达式1 **：**表达式2。例如：

  a > b ? a ：b

- 计算规则：
  - 先计算关系表达式。
  - 如果为**true**，**表达式1的值**就是运算结果。
  - 如果为**false**，**表达式2的值**就是运算结果。

# 数据输入

### Scanner的使用步骤

1. 导包

2. 创建对象

3. 接受数据

   ```java
   import java.util.Scanner; //导包必须出现在类定义上面
   Scanner sc = new Scanner(System.in); //只有变量sc可以变，其他不能变。
   int i = sc.nextInt(); //只有变量i可以变，其他不能变。
   String s = sc.nextLine();//字符串是nextLine()。
   ```

# 流程控制

**流程控制语句分类**

- 顺序结构
- 分支结构（if， switch）
- 循环结构（for， while， do...while）

当使用switch语句的时候，如果出现**多种情况对应相同结果**，可以使用下面的格式：

```java
switch(month)
{
	case 1:
	case 2:
	case 12:
		System.out.println("冬季")
		break;
}
```

**while 和 do...while 的区别：**

- while 先进行判断再执行。

- do...while 先执行一次后再进行判断。

跳转控制语句：

- continue：用在循环中，基于条件控制，跳过某次循环体内容的执行，继续下一次的执行。
- break：用在循环中，基于条件控制，终止循环体内容的执行，即结束当前整个循环。



# Random

**Random的使用步骤**

1. 导包
2. 创建对象
3. 获取随机数

```java
import java.util.Random; //导包必须出现在类定义上面
Random r = new Random(); //只有变量r可以变，其他不能变。
int number = r.nextInt(10); //变量number，数字10可变，其他不能变。获取范围[0, 10),包括0，不包括10。
```



# 数组

数组是一种用于存储多个相同类型数据的储存模型。

## 初始化方式

- 动态：初始化的时候只指定数组长度，由系统为数组分配初始值。

  - 默认值：

    整数：0

    浮点数：0.0

    布尔值：false

    字符：空字符

    引用数据类型：null

  - 格式：数据类型 [ ] 变量名 = new 数据类型 [ 数组长度 ]，例如

    ```java
    int [] arr = new int [3];
    /*
    左边:
    	int：数组中元素类型是int
    	[]:说明这是一个数组
    	arr：数组名称
    右边：
    	new：为数组申请内存空间
    	int：数组中元素类型是int
    	[]:说明这是一个数组
    	3：数组长度，即数组中元素的个数
    */
    ```

- 静态：初始化的时候指定每个数组元素的初始值，由系统决定数组长度。

  - 格式：数据类型 [ ] 变量名 = new 数据类型 [ ]{数据1，数据2，数据3，数据4，....};

    ​			数据类型 [ ] 变量名 = {数据1，数据2，数据3，数据4，....};

  ```java
  int[] arr = new int[]{1,2,3};
  int[] arr = {1,2,3};
  ```



## 数组元素访问

- 数组变量方位方式：数组名。
- 数组内部保存的数据的访问方式：数组名[索引]。
- 索引是数组中数据的编号方式，用于访问数组中的数据使用。
  - 索引从0开始。
  - 索引连续。
  - 索引逐一增加1。
- 直接输出数组名就会输出数组的**地址**。



## 内存分配

为了提高效率，对空间进行了不同区域的划分，因为每一片区域都有特定的处理数据方式和内存管理方式。

![image-20200812171801822](https://i.loli.net/2020/08/22/PDBT3AFZpNjY2LR.png)

图中 **arr** 指向 **001** 这一片内存空间，**001** 赋值给了 **arr** 。

![image-20200812172158905](https://i.loli.net/2020/08/22/4b6QkSdxKLesGHE.png)

**arr[0]** 中的 **0** 找到内存 **001** 中的 **0**，然后输出所对应的数值。

- 栈内存（红色）：存储局部变量，使用完毕后立刻消失。
- 堆内存（蓝色）：存储new出来的内容（实体，对象），每一个new出来的东西都有一个地址值，使用完毕后会在垃圾回收器空闲时被回收。



## 多个数组指向相同

当两个数组指向相同的时候，任意一个数组修改堆内存的数据，另一个数组访问时，对应的元素值也会发生改变。

```java
int[] arr = new int[3];
arr[0] = 100;
arr[1] = 200;
arr[2] = 300;

int[] arr2 = arr;//arr的值（数组的地址001）赋给arr2,arr和arr2指向同一个数组
arr2[0] = 111;
arr2[1] = 222;
arr2[2] = 333;
```

![image-20200813222826226](https://i.loli.net/2020/08/22/I1cJlgVzh4RpHB5.png)

![image-20200813223001860](https://i.loli.net/2020/08/22/e92MvrF1tf7cysI.png)



## 数组操作的两个常见小问题

- 索引越界：访问了数组中不存在的索引对应的元素，造成索引越界。
- 空指针异常：访问的数组已经不再指向堆内存的数据，造成空指针异常。

```java
int[] arr = new int[3];
System.out.println(arr[3]);//不存在，报错。
arr = null;//arr不再指向之前的数组。
System.out.println(arr[0]);//arr不再指向对应数组，无法访问，报错。
```



## 数组的操作

### 遍历

获取数组元素个数

- 格式：数组名.length，例如：arr.length

```java
int[] arr = {...};
//遍历通用格式
for(int i = 0; i < arr.length; i++)
{
    System.out.println(arr[i]);
}
```



### 获取最值

```java
int[] arr = {12, 45, 98, 73, 60};
//定义一个变量用于保存最大值（最小值）,取数组中第一个数据作为初始值。
int max = arr[0];
//用这个值和数组中的数据逐个作比较，将每次对比中，更大的值保存到变量中。
for(int i = 1; i < arr.length; i++)
{
    if(arr[i] > max)
    {
        max = arr[i];
    }
}
//输出
System.out.println(max);
```



# 方法

将具有独立功能的**代码块**组织成一个整体，使其具有特殊功能的代码集。

**形参：**方法**定义中**的参数，等同于变量定义格式。

**实参：**方法**调用中**的参数，等同于使用变量或者常量。

- 必须先创建才可以使用（定义）。
- 创建后需要手动使用才可以执行（方法调用）。

```java
public static void main(String[] args) 
    {
        方法名(参数1,...);//方法调用
    }

    public static 返回值类型 方法名(参数1,....)//方法定义
    {
        //方法体
        return 与返回值类型对应的数据;
    }
```

- 方法定义时，若有返回值，最后**return**后面的返回值与方法定义上的数据类型要匹配。
- 方法调用时，参数的数量和类型必须和方法定义中的设置完全匹配。
- 有返回类型的方法推荐用变量接收调用（Ctrl + Alt + v）。



## 方法重载

同一个类中定义的多个方法之间的关系，满足以下条件的多个方法相互构成重载。

1. 多个方法再同一个类中。
2. 多个方法具有相同的方法名。
3. 多个方法的参数不同，类型不同或者数量不同。

**特点**

- 重载仅仅对应方法的**定义**，和方法的调用无关，调用方式参照标准格式。
- 重载仅仅针对同一个类中方法的名称和参数进行识别，和返回值无关（不能通过返回值来判定两个方法是否构成重载）。
- Java虚拟机会通过参数的不同来区分同名的方法。

```java
//1
public class MethodDemo
{
    public static void fn(int a){}//不是重载，因为方法名和参数都相同。
    public static int fn(int a){}
}
//2
public class MethodDemo
{
    public static float fn(int a){}//是重载，因为方法名相同，但参数不同。
    public static int fn(int a, int b){}
}
//3
public class MethodDemo
{
    public static float fn(int a){}//是重载，因为方法名相同，但参数不同。
    public static int fn(double a){}
}
//4
public class MethodDemo01
{
    public static void fn(int a){}//不是重载，因为不在同一个类中。
}
public class MethodDemo02
{
    public static int fn(double a){}
}
```



## 方法参数传递

### 基本类型

对于基本数据类型的参数，形式参数的改变，**不影响**实际参数的值。

![image-20200813235951250](https://i.loli.net/2020/08/22/C2EvQHUot37GuxM.png)

```java
public static void main(String[] args){
    int num = 100;
    System.out.println(num);//输出100
    change(num);//此时change中num是200，但修改完数据后，change弹出栈消除
    System.out.println(num);//此时main中的参数num的值依然是100，输出还是100
}
public static void change(int x){
    x = 200;
}
```

### 引用类型

对于引用数据类型的参数，形式参数的改变，**影响**实际参数的值。

```java
public static void main(String[] args){
    int[] arr = {1, 2, 3};
    System.out.println(arr[0]);//输出1
    change(arr);//此时修改了 “堆内存” 中的数据
    System.out.println(arr[0]);//因为“堆内存”的值已被改变，所以输出是已改变的值200
}
public static void change(int[] arr){
    arr[0] = 200;
}
```



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

![image-20200817150339332](https://i.loli.net/2020/08/22/cJaGTgRHE8LKSez.png)



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

![image-20200817152934308](https://i.loli.net/2020/08/22/jTU9vaRqKzSEuCN.png)

![image-20200817153007893](https://i.loli.net/2020/08/22/jJAQ4HuyZOPTB7V.png)

成员方法的调用，先把成员方法加载到栈内存。调用者 s 就是前面 new 出来的 s。

![image-20200817153138772](https://i.loli.net/2020/08/22/gGUz7Ccq5ObmEes.png)

当方法执行完毕后，方法就会从栈内存中消失。



### 多个对象（指向不同）

成员变量的值可以不同，成员方法可以多个对象**共用**。

![image-20200817153546316](https://i.loli.net/2020/08/22/Pjr5lnTSm3a2dsE.png)

s1和s2分别对应堆内存中001和002这两个块地址内容。

![image-20200817154115432](https://i.loli.net/2020/08/22/iZWrcCyph5I1SwL.png)

这次成员方法study()的调用者是s2。



### 多个对象（指向相同）

数组的内存分配相似。

![image-20200817154305511](https://i.loli.net/2020/08/22/5oyEkSwpW4C8ZYI.png)

此时s1和s2的值相同，都指向堆内存中001这块地址内容。

![image-20200817154512508](https://i.loli.net/2020/08/22/UBFlfT4nRqiLEvW.png)

通过s2来修改内容，001对应的内容发生改变。

![image-20200817154653109](https://i.loli.net/2020/08/22/g2y3hWaVHN5RrvZ.png)

此时无论通过s1还是s2输出内容，都会输出被s2修改后的内容。



## 成员变量和局部变量

**成员变量**：**类方法外**的变量（红色框）。

**局部变量**：**方法中**的变量（蓝色框）。

![image-20200817154939224](https://i.loli.net/2020/08/22/sSxapZwXI1gMT45.png)

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

![image-20200817162235346](https://i.loli.net/2020/08/22/uoCUOYSjt1A5wsP.png)

- 使用**this**的目的就是解决局部变量隐藏成员变量的问题。
- **this**代表所在类的对象引用，方法被哪个对象对用，**this**就代表哪个对象（方法的**调用者**）。

![image-20200817162519586](https://i.loli.net/2020/08/22/s9paCyduh1Y3qxH.png)





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

![image-20200817201307637](https://i.loli.net/2020/08/22/1twnYXeKLvoFEgs.png)



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

![image-20200819144649361](https://i.loli.net/2020/08/22/LukIjlCdBqsWa4g.png)

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
//StringBuilder转String
public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
    	//String s = sb;报错，错误写法
        String s = sb.toString();
    	System.out.println(s);
    }

//String转StringBuilder
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



### 集合类体系结构

![image-20200828221842035](https://i.loli.net/2020/08/28/3Hys1gzbQqd7Pul.png)

- Collections（单列）：**接口** 存储一组不唯一，无序的对象，一个 Collection 代表一组 Object，Java不提供直接继承自Collection的类，只提供继承于的子接口(如List和set)
  - List：一个有序的 Collection，能精确的控制每个元素插入的位置，能够通过索引来访问List中的元素，而且允许有相同的元素，**存储一组不唯一，有序（插入顺序）的对象**
  - Set：Set 具有与 Collection 完全一样的接口，只是行为上不同，Set 不保存重复的元素，**存储一组唯一，无序的对象**
- Map（双列）：**接口 **存储一组键值对象，提供key（键）到value（值）的映射



## Collection

### 概述

- 单例集合的顶层接口，表示一组对象，这些对象被称为Collection的元素
- JDK不提供此接口的任何直接实现，但是提供更具体的子接口（如Set、List等）实现
- 通过多态的方式创建Collection集合的对象



### Collection集合的常用方法

|           方法名            |              说明              |
| :-------------------------: | :----------------------------: |
|      boolean add(E e)       |            添加元素            |
|  boolean remove(Object o)   |      从集合中移除指定元素      |
|        void clear()         |        清空集合中的元素        |
| boolean contains(Object o ) |  判断集合中是否存在指定的元素  |
|      boolean isEmpty()      |        判断集合是否为空        |
|         int size()          | 集合的长度。即集合中元素的个数 |



### Collection集合的遍历

- Iterator：迭代器，集合专用的遍历方式
- Iterator<E> iterator()：返回此集合中元素的迭代器
- 迭代器是通过集合的 iterator() 方法得到的，所以我们说它是依赖于集合而存在的
- 常用的方法：
  - E next()：	返回迭代中的下一个元素
  - boolean hasNext()：如果迭代具有更多元素，则返回true

```java
Collection<String> c = new ArrayList<String>();//步骤1：创建集合对象
c.add("hello");//步骤2：添加元素到集合
c.add("world");
c.add("java");
//步骤3：遍历集合
Iterator<String> it = c.iterator();//步骤3.1：通过集合对象获取迭代器对象
while(it.hasNext())//步骤3.2：通过迭代器对象的hasNext()方法判断是否还有元素
{
    String s = it.next();//步骤3.3：通过迭代器对象的next()方法获取下一个元素
}
```

![image-20200828230420310](https://i.loli.net/2020/08/28/zeK3FCVUh4RQ1yb.png)

创建集合c，并且向c中添加元素

![image-20200828230505298](https://i.loli.net/2020/08/28/2yJed6nrmDhj1ku.png)

得到一个迭代器，迭代器中有的内容就是红色框中的内容，并且用一个箭头指向开始的位置

![image-20200828230709033](https://i.loli.net/2020/08/28/QRP5ObHnoLWd1Nv.png)

判断是否有下一个元素，有就执行操作，并且把箭头指向下一个元素



## List

### 概述

- 有序集合（序列），用户可以精确控制列表中每个元素的插入位置。用户可以通过整数索引访问元素，并搜索列表中的元素
- 和Set集合不同，列表通常允许重复的元素



### 特点

- 有序：存储和取出的元素顺序一致
- 可重复：存储的元素可以重复



### List集合特有的方法

|             方法名             |                  说明                  |
| :----------------------------: | :------------------------------------: |
| void add(int index, E element) |   在此集合中的指定位置插入指定的元素   |
|      E remove(int index)       | 删除指定索引处的元素，返回被删除的元素 |
|  E set(int index, E element)   | 修改指定索引处的元素，返回被修改的元素 |
|        E get(int index)        |          返回指定索引处的元素          |



### 并发修改异常

- ConcurrentModificationException

- 异常产生原因：迭代器遍历的过程中，通过集合对象修改了集合中元素的长度，造成了迭代器获取元素中判断 **预期修改值** 和 **实际修改值** 不一致

- 解决方法：用for循环代替迭代器进行遍历

  ```java
  List<String> list = new ArrayList<String>();
  list.add("hello");
  list.add("world");
  list.add("java");
  
  Iterator<String> it = list.iterator();
  while(it.hasNext())
  {
      String s = it.next();
  //    报错，因为预期修改值和实际修改值不同，产生异常
  //    if(s.equals("world"))
  //    {
  //        list.add("javaee")
  //    }
  }
  ```



### ListIterator（列表迭代器）

- 通过List集合的listIterator()方法得到的，List集合特有的迭代器
- 允许沿任一方向遍历列表
- 可以在迭代期间修改列表
- 获取列表中迭代器的当前位置



### ListIterator常用方法

|        方法名         |                             说明                             |
| :-------------------: | :----------------------------------------------------------: |
|       E next()        |                    返回迭代中的下一个元素                    |
|   boolean hasNext()   |               如果迭代具有更多元素，则返回true               |
|     E previous()      |                    返回列表中的上一个元素                    |
| boolean hasPrevious() | 如果此迭代器在相反方向迭代，遍历列表时具有更多元素，则返回true |
|   **void add(E e)**   |                   **将指定的元素插入列表**                   |

```java
List<String> list = new ArrayList<String>();
list.add("hello");
list.add("world");
list.add("java");

ListIterator<String> it = list.ListIterator();
while(it.hasNext())
{
    String s = it.next();
    //不会报错，因为ListIterator中的add(E e)方法中带有一行代码：
    //expectedModCount = modCount;
    //把实际修改值重新赋值给了预期修改值
    if(s.equals("world"))
    {
        list.add("javaee")
    }
}
```



### 增强for循环

- 简化数组和Collection集合的遍历

- 实现 Iterable 接口的类允许其对象成为增强型for循环语句的目标

- 内部原理时一个Iterator迭代器

- 格式：

  ```java
  for(元素数据类型 变量名：数组或者Collection集合){
      //此处使用变量（元素）
  }
  
  //范例：
  int[] arr = {1,2,3,4,5};
  for(int i : arr){
      System.out.println(i);
  }
  ```



## ArrayList和LinkedList

- 可调整大小的数组实现
- <E>：是一种特殊的数据类型，泛型
- 在所有出现<E>的地方都可以使用引用数据类型替换
  - ArrayList<String>, ArrayList<Student>



### List集合子类特点

- ArrayList
  - 底层数据结构是数组，查询快，增删慢
- LinkedList
  - 底层数据结构是链表，查询慢，增删快



### ArrayList的构造方法和添加方法

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



### ArrayList集合的常用方法

|               方法名                |                    说明                    |
| :---------------------------------: | :----------------------------------------: |
| public **boolean remove**(Object o) |     删除指定元素，返回删除**是否成功**     |
|   public **E remove**(int index)    |     删除指定元素，返回**被删除的元素**     |
| public E set(int index, E element)  | 修改指定索引处的元素，返回**被修改的元素** |
|       public E get(int index)       |            返回指定索引处的元素            |
|          public int size()          |            返回集合中的元素个数            |



### LinkedList集合特有的功能

|          方法名           |               说明               |
| :-----------------------: | :------------------------------: |
| public void addFirst(E e) |    在该列表开头插入指定的元素    |
| public void addLast(E e)  |  将指定的元素追加到此列表的末尾  |
|    public E getFirst()    |       返回列表中第一个元素       |
|    public E getLast()     |      返回列表中最后一个元素      |
|  public E removeFirst()   |  从列表中删除并且返回第一个元素  |
|   public E removeLast()   | 从列表中删除并且返回最后一个元素 |



## Set

### 概述

- 功能全部来自于Collection



### 特点

- 不包含重复元素的集合
- 没有带索引的方法，所以不能使用普通的for循环进行遍历
- HashSet：对集合的迭代顺序不作任何保证，允许null元素



### 哈希值

- JDK根据对象的 **地址** 或者 **字符串** 或者 **数字** 算出来的 **int** 类型的 **数值**
- Object类中有一个方法可以获取 **对象的哈希值**
  - public int hashCode()：返回对象的哈希码值

#### 对象哈希值的特点

- 同一个对象多次调用hashCode()方法返回的哈希值是相同的
- **默认情况下，**不同对象的哈希值是不同的
  - 重写hashCode()方法，可以实现让不同对象的哈希值变成相同的



### HashSet集合概述和特点

- 底层数据结构是哈希表
- 对集合的迭代顺序不作任何保证，也就是说不保证存储和取出的元素顺序一致
- 没有带索引的方法，所以不能使用普通的for循环进行遍历
- 属于Set集合的一种，所以不包含重返元素的集合

#### HashSet集合保证元素唯一性分析

HashSet集合添加一个元素的过程：

<img src="https://i.loli.net/2020/08/30/EzQOIeK7RqrwhyG.png" alt="image-20200830001917761" style="zoom:150%;" />

- 要保证元素唯一性需要：
  - **重写hashCode()方法**
  - **重写equals()方法**



### LinkedHashSet集合概述和特点

- **哈希表和链表** 实现的Set接口，具有可预测的迭代次序
- **由链表保证元素有序**，也就是说元素的存储和取出顺序是一致的
- **由哈希表保证元素唯一**，也就是说没有重复的元素



### TreeSet集合概述和特点



















## 数据结构

- 计算机存储、组织数据的方式，是指相互之间存在一种或多种特定关系的数据元素的集合
- 精心选择的数据结构可以带来更改的运行或者存储效率



### 栈

- 数据进入栈模型的过程：压栈/进栈
- 数据离开栈模型的过程：弹栈/出栈
- 一段开口：栈顶；一段封闭栈底
- **先进后出的模型**

![image-20200829152608625](https://i.loli.net/2020/08/29/JMfEswi5LtKVdxp.png)

进入的时候，第一个数据（数据A）先进入到栈底

![image-20200829152301461](https://i.loli.net/2020/08/29/PwzWHplQDUO1TYh.png)

离开的时候，最后进入的数据（数据D）先离开



### 队列

- 数据进入队列模型的过程：入队列
- 数据离开队列模型的过程：出队列
- 一段开口：后端；一段开头：前端
- **先进先出的模型**

![image-20200829152716350](https://i.loli.net/2020/08/29/ucdiRel4GaNZQqO.png)

![image-20200829153122483](https://i.loli.net/2020/08/29/fHFk2nhoBdiezCg.png)

入队列方向；出队列方向



### 数组

- 查询数据：通过索引定位，**查询任意数据耗时相同，查询速度快**
- 删除数据：要将原始数据删除，同时**后面每个数据前移，删除效率低**
- 添加数据：添加位置后的**每个数据后移，再添加元素，添加效率极低**
- **查询快，增删慢** 的模型



### 链表

- **增删快，查询慢的模型（对比数组）**
- 要查询数据是否存在，必须从头（head）开始查询

- 结点的结构

  ![image-20200829153703052](https://i.loli.net/2020/08/29/Vp4teBrsgEGvLFw.png)

- 头节点的结构

  ![image-20200829153732950](https://i.loli.net/2020/08/29/4Korz2gXRIY7tWM.png)

- 链表的组成

  ![image-20200829154035472](https://i.loli.net/2020/08/29/u17ISDPNZUbzHTC.png)



-  添加数据的过程（A和C之间添加B）
  - 将要添加的数据（数据B）的下一个数据地址指向C
  - 将前一个数据（数据A）的下一个数据地址指向B

![image-20200829154303405](https://i.loli.net/2020/08/29/DutlUkapKFYiSzE.png)



- 删除数据的过程（B和D之间删除C）
  - 将数据B对应的下一个地址指向数据D
  - 删除数据C

![image-20200829154603950](https://i.loli.net/2020/08/29/peJutMOiX6jTm85.png)



### 哈希表（HashMap）

- JDK8之前，底层采用 **数组+链表** 实现，也可以说是一个：**元素为链表的数组**

- JDK8之后，在长度比较长的时候，底层实现了优化

- HashMap默认初始容量为 **16**

哈希表数据存储过程：

1. 计算要存储的数据的哈希值，数组默认容量为 **16（0-15）**

   ![image-20200830002745425](https://i.loli.net/2020/08/30/TqcJNzYVoaPHlGE.png)

2. 对哈希值 **进行对16取余** ，把哈希值转化为 **0-15** 这样的数据

   ![image-20200830003027464](https://i.loli.net/2020/08/30/YfaRohEVjyrnQZT.png)

3. 先存放"Hello"，此时 **位置2** 没有元素 ，所以"Hello"就直接存储进去了

   ![image-20200830003505053](https://i.loli.net/2020/08/30/9tBTiPLMJ8wSgO2.png)

4. 然后到"world"，存储位置一样是 **位置2**，但是此时 **位置2 **有元素，所以要跟已经在这个位置的元素进行比较

   1. 首先比较哈希值是否相同（不相同，所以直接存储进去了）
   2. 如果哈希值相同，就比较内容是否相同（哈希值不同就不用比较内容了）

   ![image-20200830004132160](https://i.loli.net/2020/08/30/mpFbKPSagiuVJIC.png)

5. 然后到"java"，存储位置一样是 **位置2**，此时 **位置2 **有多个元素，所以要跟在这个位置的所有元素进行比较

   1. 首先比较哈希值是否相同（不相同，所以直接存储进去了）
   2. 如果哈希值相同，就比较内容是否相同（哈希值不同就不用比较内容了）

   ![image-20200830004246553](https://i.loli.net/2020/08/30/6pBYk3dmGfhwEc8.png)

6. 然后到"world"（第二个），存储位置一样是 **位置2**，此时 **位置2 **有多个元素，所以要跟在这个位置的所有元素进行比较

   1. 首先比较哈希值是否相同
   2. 哈希值相同，就比较内容是否相同
   3. 如果内容也相同，说明是重复元素，所以不存储

   ![image-20200830004716711](https://i.loli.net/2020/08/30/SnYAH9qEwo1cxBW.png)

7. 然后到"通话"，此时 **位置3** 没有元素 ，所以"通话"就直接存储进去了（同步骤1）

8. 然后到"重地"，存储位置一样是 **位置3**，但是此时 **位置3 **有元素，所以要跟已经在这个位置的元素进行比较

   1. 首先比较哈希值是否相同
   2. 如果哈希值相同，就比较内容是否相同

   ![image-20200830005033659](https://i.loli.net/2020/08/30/4NCjYXmdEoKScf2.png)

   

   



































