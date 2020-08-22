# Java学习笔记

# 继承

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！



### 概述

继承可以使得子类具有父类的**属性（成员变量）**和方法，还可以在子类中重新定义，追加属性和方法。

![image-20200820210639258](https://i.loli.net/2020/08/22/LSinIZ1yuE8Wfv9.png)





- 继承的格式
  - 使用关键字 **extends**
  - Fu：是父类，也叫基类、超类
  - Zi：是子类，也叫派生类

```java
public class 子类名 extends 父类名{
    
}
//范例
public class Zi extends Fu{
    
}
```

- 继承中子类的特点
  - 子类可以有父类的内容
  - 子类还可以有自己特有的内容



### 利弊

- 利处
  - 提高了代码的复用性（多个类相同的成员可以放到同一个类中）
  - 提高了代码的维护性（如果方法的代码需要修改，修改一处即可）

- 弊端
  - 继承让类与类之间产生了关系，类的耦合性增强了，当父类发生变化时，子类实现也不得不跟着变化，削弱了子类的独立性
- **什么时候使用继承**
  - 继承体现的关系：is a（什么是什么的关系）
  -  假设法：A和B两个类，如果满足A是B的一种，或者B是A的一种，就说明他们存在继承关系，这时就可以考虑使用继承来体现，否则不能滥用继承
  - 例如：苹果和水果、猫和动物



### 变量的访问特点

在子类方法中访问一个变量

1. 子类局部范围内寻找（方法内）
2. 子类成员范围内寻找
3. 父类成员范围内寻找
4. 如果都没有就报错（不考虑父亲的父亲...）



### super

**super** 关键字用法和 **this** 关键字用法相似

- **this：**代表本类对象的引用
  - **this** 指向调用该方法的对象
- **super：**代表父类存储空间的标识（可以理解为父类对象的引用）

| 关键字 |             访问成员变量             |           访问构造方法           |               访问成员方法                |
| :----: | :----------------------------------: | :------------------------------: | :---------------------------------------: |
|  this  | this.成员变量<br />访问本类成员变量  | this(...)<br />访问本类构造方法  | this.成员方法(...)<br />访问本类成员方法  |
| super  | super.成员变量<br />访问父类成员变量 | super(...)<br />访问父类构造方法 | super.成员方法(...)<br />访问父类成员方法 |



### 构造方法的访问特点

子类中所有的构造方法默认都会访问父类中 **无参** 的构造方法

- 子类会继承父类中的数据，可能还会使用父类的数据。所以子类在初始化前，一定要先完成父类数据的初始化
- 每一个子类构造方法的第一条语句默认都是：**super()**

如果父类中没有 **无参** 构造方法，只有 **带参** 构造方法

- 通过使用super关键字去显示的调用父类的带参构造方法
- 在父类中自己提供一个无参构造方法
- **推荐：自己给出无参构造方法**

```java
public class Fu
{
    private int age;

//    public Fu()
//    {
//        System.out.println("Fu中无参构造方法被调用");
//    }

    public Fu(int age)
    {
        this.age = age;
        System.out.println("Fu中带参构造方法被调用");
    }
}

public class Zi extends Fu
{
    private int age;

    public Zi()
    {
        super(20);//通过super调用父类的带参构造方法
        System.out.println("Zi中无参构造方法被调用");
    }

    public Zi(int age)
    {
        super(20);//通过super调用父类的带参构造方法
        this.age = age;
        System.out.println("Zi中带参构造方法被调用");
    }
}
```



### 成员方法的访问特点

通过子类对象去访问一个方法

1. 子类成员范围内寻找
2. 父类成员范围内寻找
3. 如果都没有就报错（不考虑父亲的父亲...）

```java
public class Fu
{
    public Fu()
    {
    }
    
    public void show()
    {
        System.out.println("fu中show()被调用");
    }
}
public class Zi extends Fu
{
    public Zi()
    {
    }

    public void method()
    {
        System.out.println("zi中method()被调用");
    }

    public void show()
    {
        super.show();//调用Fu中的show()方法
        System.out.println("zi中show()被调用");
    }
}
```



### super内存图

![image-20200820215428326](https://i.loli.net/2020/08/22/zSWEmnqbcClsopA.png)

调用无参构造方法，加载到栈内存。子类构造方法中第一行默认有语句：**super()** 。



![image-20200820215712468](https://i.loli.net/2020/08/22/i68hYQpOjl2cbDU.png)

进入到父类后，堆内存有一个 **super** 空间用来存储父类的初始化数据，然后去访问父类的构造方法。



![image-20200820215934387](https://i.loli.net/2020/08/22/92JVof3k61mKxNb.png)

通过调用者z（001）找到super，再通过super找到对应的值。



### 方法重写

**概述**

- 子类中出现和父类一模一样的的方法声明

**应用**

- 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法，这样，既沿袭了父类的功能，又定义了子类特有的功能
- **推荐：在重写方法的声明上，添加注解 “@Override” ，可以帮我们检查重写方法声明的正确性** 

**注意事项**

- 私有方法（private）不能被重写（父类的私有成员子类是不能继承的）
- 子类方法访问权限不能更低（public > 默认 > private）



### 注意事项

- Java中类只支持单继承，不支持多继承
- Java中类支持多层继承（多重继承）

![image-20200822231429086](https://i.loli.net/2020/08/22/nFimAVU7jlbdROD.png)



# 包

## 概述

- 包就是Java中的文件夹，作用是对类进行分类管理

### 定义格式

- 格式：package 包名; （多级包用.分开）
- 范例：package com.malajie （二级包，com是第一个文件夹，malajie是第二个文件夹）



### 带包的Java类编译和执行

- 手动建包：
  - 按照以前的格式编译java文件	javac HelloWorld.java
  - 手动建包	在X盘创建文件夹com，然后在文件夹com下创建文件夹malajie
  - 把class文件放到包的最里面	把HelloWorld.class文件放到com下的malajie这个文件夹下
  - 带包执行	java com.malajie.HelloWorld
- 自动建包：javac -d . HelloWorld.java	java com.malajie.HelloWorld



## 导包

使用不同包下的类的时候，要写类的全部路径，写起来太麻烦了，为了简化带包的操作，Java提供了导包的功能

### 导包的格式

- 格式：import 包名;
- 范例：import com.animals.Cat



# 修饰符

## 权限修饰符

|            修饰符             | 同一个类中 | 同一个包中的<br />子类和无关类 | 不同包的子类 | 不同包的无关类 |
| :---------------------------: | :--------: | :----------------------------: | :----------: | :------------: |
|            private            |     ✔      |                                |              |                |
| 默认（default前面没有修饰符） |     ✔      |               ✔                |              |                |
|           protected           |     ✔      |               ✔                |      ✔       |                |
|            public             |     ✔      |               ✔                |      ✔       |       ✔        |



## 状态修饰符

### final（最终态）

final关键字是最终的意思，可以修饰成员方法，成员变量，类

#### final修饰的特点

- 修饰方法：表明该方法是**最终方法，不能被重写**
- 修饰变量：表明该变量是**常量，不能被再次赋值**
- 修饰类：表明该方法是**最终类，不能被继承**

```java
public final class Fu//不能被继承
{
    public final int age = 20;//不能被再次赋值
    
    public final void show()//不能被重写
    {
        System.out.println("123");
    }
}
```

#### final修饰局部变量

- 变量是基本类型：final修饰指的是基本类型的**数据值**不能发生改变
- 变量是引用类型：final修饰指的是引用类型的**地址值**不能发生改变，但是内容可以改变

```java
final int age = 20;//不能被再次赋值
//age = 100;报错，因为age是一个常量

final Student s = new Student();
s.age =100;//可以修改
//s = new Student();报错，因为s的地址值不能改变
```



### static（静态）

static关键字是静态的意思，可以修饰成员方法，成员变量

#### static修饰的特点

- 被类的所有对象共享
  - 这是我们判断是否使用static（静态）关键字的条件
- 可以通过类名待用，也可以通过对象名来调用
  - **推荐：使用类名来调用**

```java
public class Student
{
    public String name;
    public int age;
    public static String university;
    
    public void show()
    {
        System.out.println(name + age + university);
    }
}

public class Test
{
    public static void main(String[] args)
    {
        Student.university = "纽卡斯尔大学";
        
        Student s1 = new Student();
        s1.name = "迪丽热巴";
        s1.age = 28;
        s1.show();//输出：迪丽热巴28纽卡斯尔大学
        
        Student s2 = new Student();
        s2.name = "马拉杰";
        s2.age = "24";
        s2.show();//输出：马拉杰24纽卡斯尔大学
    }

}
```

#### static的访问特点

非静态的成员方法

- 能访问静态的成员变量
- 能访问非静态的成员变量
- 能访问静态的成员方法
- 能访问非静态的成员方法

静态的成员方法

- 能访问静态的成员变量
- 能访问静态的成员方法

**总结：静态成员方法只能访问静态成员**



































