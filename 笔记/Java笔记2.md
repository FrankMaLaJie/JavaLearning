# Java学习笔记2

# 继承

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！



## 概述

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



## 变量的访问特点

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



## 方法重写

**概述**

- 子类中出现和父类一模一样的的方法声明

**应用**

- 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法，这样，既沿袭了父类的功能，又定义了子类特有的功能
- **推荐：**
  - **在重写方法的声明上，添加注解 “@Override” ，可以帮我们检查重写方法声明的正确性** 
  - **快捷输入：直接在子类输入要重写的方法名**

**注意事项**

- 私有方法（private）不能被重写（父类的私有成员子类是不能继承的）
- 子类方法访问权限不能更低（public > 默认 > private）



## 注意事项

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
- 范例：`import com.animals.Cat`



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



# 多态

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！

面向对象的三大特征：封装、继承、多态！！！



## 概述

同一个对象，在不同时刻表现出来的不同形态

举例：猫

- 猫是猫：猫 cat = new 猫();
- 猫是动物：动物 animal = new 猫();
- **这里猫在不同时刻表现出来的不同形态，这就是多态**
- 多态的形式：具体类多态，**抽象类多态，接口多态**



### 多态的前提和实现

- 有继承/实现关系
- 有方法重写
- 有父（类/接口）引用指向（子/实现）类对象：`动物 animal = new 猫()`;

```java
public class Animal 
{
    public void eat(){
        System.out.println("动物吃东西");  
    };
}

public class Cat extends Animal //继承关系
{  
    @Override
    public void eat() //方法重写
    {  
        System.out.println("吃鱼");  
    }  
}  

    public static void main(String[] args)
    {
        Animals cat = new Cat();//父类引用 指向 子类对象
    }

```



### 利弊

- 利处
  - 提高了代码的扩展性（定义方法时，用父类作为参数，将来使用时，使用具体的子类型参与操作）

- 弊端
  - 不能使用子类的特有功能

```java
    public class Animal
    {
        public void eat(){
            System.out.println("动物吃东西");
        };
    }

    public class Cat extends Animal //继承关系
    {
        @Override
        public void eat() //方法重写
        {
            System.out.println("吃鱼");
        }
        
        public void catchMouse(){
            System.out.println("抓老鼠");
        }

    public class Dog extends Animal //继承关系
    {
        @Override
        public void eat() //方法重写
        {
            System.out.println("吃骨头");
        }
    }

    public class AnimalBehavior
    {
//        public void useAnimal(Cat cat){//Cat cat = new Cat();
//        cat.eat();
//    }
//
//    	  public void useAnimal(Dog dog){//Cat cat = new Cat();
//        dog.eat();
//    }
        public void useAnimal(Animal a){
            //Animal a = new Cat();
            //Animal a = new Dog();
            //多态访问成员方法：编译看左边，执行看右边
            //执行传入对象所对应的方法
            a.eat();
        }
    }

    public static void main(String[] args)
    {
        AnimalBehavior animalBehavior = new AnimalBehavior();

        Cat cat = new Cat();
        //animal中有eat()方法，编译通过
        //此时eat()中的a是cat，所以调用cat中的eat()方法
        animalBehavior.useAnimal(cat);

        //同上
        Dog dog = new Dog();
        animalBehavior.useAnimal(dog);
    }
```





## 多态中成员访问特点

- 成员变量：编译看左边，执行看左边
  - 通过多态访问变量，其实是访问父类中的变量
- 成员方法：编译看左边，执行看右边
  - 调用的是重写后的方法
- **因为成员方法有重写，成员变量没有**

```java
public class Animal 
{
    int age = 20;
    
    public void eat(){
        System.out.println("动物吃东西");  
    };
}

public class Cat extends Animal //继承关系
{  
    int age = 40;
    int weight = 60;
    
    @Override
    public void eat() //方法重写
    {  
        System.out.println("吃鱼");  
    }
    
    public void catchMouse()
    {
        System.out.println("抓老鼠");
	}
}  

public static void main(String[] args)
{
    Animals cat = new Cat();//父类引用 指向 子类对象
    
    System.out.println(cat.age);// 输出 20，通过多态访问变量，其实是访问父类中的变量
    //System.out.println(cat.weight);报错，内存中对象是猫，但是外界看到的其实是动物的引用，动物中没有定义变量 weight，所以报错
    
    cat.eat();//输出 吃鱼，调用的是重写后的方法
    //cat.catchMouse();报错，和变量一样，因为是动物的引用，动物中没有声明catchMouse()这个方法
}
```



## 多态中的转型

### 向上转型

- 从子到父：父类引用 **指向** 子类对象

```java
Animal a = new Cat();//向上转型
//父类引用Animal a 指向子类对象new Cat()
//把子类对象new Cat()赋值给了Animal a
```



### 向下转型

- 从父到子：父类引用 **转为** 子类对象

```java
Animal a = new Cat();

//Cat c = new Cat();想要调用子类Cat中特有的方法，没有必要再创建多一个Cat的对象
Cat c = (Cat)a;//向上转型
//把父类引用a强行转换为子类Cat的对象
c.eat();
c.catchMouse();//转型后可以直接调用Cat中特有的方法
```



### 转型的内存图

![image-20200823051616289](https://i.loli.net/2020/08/23/FH6ZMPg5cYXebQ7.png)

在堆内存中开辟地址为001，Cat继承了Animal，把001这个地址给了a

![image-20200823051859005](https://i.loli.net/2020/08/23/BHz3ArEogqxM6iv.png)

执行看右边，此时的a是Cat的对象，所以执行Cat中的eat()方法

![image-20200823052114411](https://i.loli.net/2020/08/23/XrTPWDBsemEcAK9.png)

a通过001指向堆内存中的内容，001所对应的内容就是Cat，所以向下转换是可以进行的

![image-20200823052321679](https://i.loli.net/2020/08/23/klvBqHdhj9oMCT4.png)

因为Dog也继承了Animal，所以刚刚创建的地址002所对应的内容也可以赋值给a，此时就把a的地址改为了002

![image-20200823052548471](https://i.loli.net/2020/08/23/SvxrDNIqznKyJV4.png)

此时a通过002指向堆内存，代表的是Dog

![image-20200823052603769](https://i.loli.net/2020/08/23/KIACoR3zUtySgFc.png)

Cat和Dog都继承了Animal，但是他们之间不等价，所以他们相互之间不能进行转换

![image-20200823052805962](https://i.loli.net/2020/08/23/75wdUzXBbDKlL3P.png)

强制执行就会出现ClassCastException（类型转换异常）



# 抽象类（abstract）

## 概述

对事物的抽象！！！

对事物的抽象！！！

对事物的抽象！！！



一个**没有方法体**的方法应该被定义为**抽象方法**，而类中如果有**抽象方法**，该类就必须定义为**抽象类**

抽象类不是具体的，不能创建对象（实例化）

```java
public abstract class Animal//2、有抽象方法，必须定义为抽象类
{
    public abstract void eat();//1、没有方法体，必须是抽象方法
}
```



### 抽象类的特点

- 抽象类和抽象方法必须使用 **abstract** 关键字进行修饰

```java
public abstract class 类名{}
public abstract void eat();
```



- 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
- 抽象类不能实例化
  - 实例化方法可以参照多态的方式，通过子类的对象实例化（抽象类多态）
- 抽象类的子类（下面二选一）
  1. 重写抽象类的 **所有** 的抽象方法
  2. 子类也是**抽象类**



### 抽象类的成员特点

- 成员变量
  - 可以是变量
  - 可以是常量
- 构造方法
  - 有构造方法，但是不能实例化
  - 用于子类访问父类数据的初始化
- 成员方法
  - 可以有抽象方法：限定子类必须完成某些操作
  - 可以是普通成员方法（非抽象方法）：提高代码的复用性（用继承来保证）



# 接口（interface）

## 概述

对行为的抽象！！！

对行为的抽象！！！

对行为的抽象！！！



一种 **公共的规范标准** ，只要符合规范标准，大家都可以通用，Java中更多体现在 **对行为的抽象**

### 接口的特点

- 接口用关键字 **interface** 修饰

```java
public interface 接口名
public interface Jumping
{
    public abstract void jump();
}
```

- 类 **实现** 接口用 关键字 **implements** 表示

```java
public class 类名 implements 接口名
public class Cat implements Jumping
{
    @Override
    public void jump()
    {
        System.out.println("猫可以跳高了");
    }
}
```

- 接口不能实例化
  - 参照多态的方式，通过实现类对象实例化（接口多态）
- 接口实现类（下面二选一）
  - 重写抽象类的 **所有** 的抽象方法
  - 子类也是**抽象类**



### 接口的成员特点

- 成员变量
  - 只能是常量
  - 默认修饰符：`public static final`（可以省略不写，直接定义变量）

```java
public interface Inter{
    public int num = 10;
    public final int num = 10;
    public static final int num =10;//三行等价
}
```



- 构造方法
  - 接口中 **没有构造方法** ，因为接口主要是对 **行为** 进行抽象，是没有具体存在的
  - 一个类如果没有父类，默认继承自 **Object类**

```java
public class InterImpl implements Inter{
}
public class InterImpl extends Object implements Inter{
    public InterImpl{
        super();//调用的是Object类中的构造函数
    }
}//等价
```



- 成员方法
  - 只能是抽象方法
  - 默认修饰符：`public abstract`（可以省略不写，直接定义方法）

```java
public interface Inter{
    public abstract void method();
    void method();//等价
}
```



## 类和接口的关系

- 类和类的关系
  - 继承关系，只能单继承，但是可以多层继承
- 类和接口的关系
  - 实现关系，可以单实现，可以多实现，可以在继承一个类的同时实现多个接口**（要先继承类再实现接口）**

```java
public class InterImpl extends Object implements Inter1, Inter2, Inter3{
}
```

- 接口和接口的关系
  - 继承关系，可以单继承，可以多继承（不同于多层继承）

```java
public interface Inter3 extends Inter1, Inter2{
}
```



### 抽象类和接口的区别

- 成员区别
  - 抽象类：变量，常量，有构造方法，也有抽象方法
  - 接口：常量，抽象方法
- 关系区别（如上一个小节）
  - 类和类：继承，单继承
  - 类和接口：实现，单继承，多继承
  - 接口和接口：继承，单继承，多继承
- **设计理念区别**
  - **抽象类：对类抽象，包括属性、行为**
  - **接口：对行为抽象，主要是行为**



# 抽象类和接口案例

有乒乓球运动员和篮球运动员、乒乓球教练和篮球教练。为了出国交流，乒乓球相关人员需要学习英语。分析哪些具体类，哪些抽象类，哪些接口。

- 分析：从具体到抽象
  1. 乒乓球运动员
  2. 篮球运动员
  3. 乒乓球教练
  4. 篮球教练

- 实现：从抽象到具体
- 使用：使用的是具体的类的对象

![image-20200823220024809](https://i.loli.net/2020/08/23/sDY2BgVtprxLZKd.png)



思路：

1. 定义英语接口	成员方法：说英语()

2. 定义抽象人类	成员变量：姓名，年龄；构造方法：无参，有参；成员方法：get/set方法，吃饭()；

3. 定义抽象教练类、继承人类	构造方法：无参，有参；成员方法：教()；

4. 定义抽象运动员类、继承人类	构造方法：无参，有参；成员方法：学习()；

5. 定义抽象篮球教练类、继承教练类	构造方法：无参，有参；成员方法：重写教(){...}；重写吃饭(){...};

6. 定义抽象乒乓球教练类、继承教练类、实现学习英语接口	构造方法：无参，有参；成员方法：重写教(){...}；重写吃饭(){...}；重写说英语();

7. 定义抽象篮球运动员类、继承教练类	构造方法：无参，有参；成员方法：重写学习(){...}；重写吃饭(){...};

8. 定义抽象乒乓球运动员类、继承教练类、实现学习英语接口	构造方法：无参，有参；成员方法：重写学习(){...}；重写吃饭(){...}；重写说英语(){...}；

   

# 形参和返回值

## 抽象类名作为形参和返回值

- 方法的形参是 **抽象类名** ，其实需要的是该抽象类的 **子类** 对象
- 方法的返回值是 **抽象类名** ，其实返回是的该抽象类的 **子类** 对象的



```java
public class AnimalBehavior{
    //Animal是抽象类，要调用这个方法，必须先创建继承Animal的子类，实例化子类后才能使用 
    public void useAnimal(Animal a)
    {
        a.eat();
    }
    
    public Animal getAnimal()//返回一个继承Animal的子类Cat的对象
    {
        Animal a = new Cat();
        return a;
    }
}

public class Cat extends Animal
{
    @Override
    public void eat()
    {
        System.out.println("猫吃鱼");
    }
}

public class Demo{
    public static void main(String[] args)
    {
        AnimalBehavior ab = new AnimalBehavior();
        Animal a = new Cat();
        ab.useAnimal(a);
        
        Animal a2 = ab.getAnimal();
        a2.eat();
    }
}
```



## 接口名作为形参和返回值

- 方法的形参是 **接口名** ，其实需要的是该接口的 **实现类** 对象

- 方法的返回值是 **接口名** ，其实返回是的该接口的 **实现类** 对象的



```java
public interface Jumping{
    void jump();
}

public class JumpingBehavior{
    //Animal是抽象类，要调用这个方法，必须先创建继承Animal的子类，实例化子类后才能使用 
    public void useJumping(Jumping j)
    {
        j.jump();
    }
    
    public Jumping getJumping()//返回一个继承Animal的子类Cat的对象
    {
        Jumping j = new Cat();
        return j;
    }
}

public class Cat implements Jumping
{
    @Override
    public void jump()
    {
        System.out.println("猫可以跳了");
    }
}

public class Demo{
    public static void main(String[] args)
    {
        JumpingBehavior jb = new JumpingBehavior();
        Jumping j = new Cat();
        jb.useJumping(j);
        
        Jumping j2 = jb.getAnimal();
        j2.eat();
    }
}
```



# 内部类

## 概述

在一个类中定义一个类。举例：在类A的内部定义一个类B，类B就是内部类

### 格式

```java
public class 类名{
    修饰符 class 类名{
        
    }
}

public class Outer{
    public class Inner{
        
    }
}
```



### 内部类的访问特点

- 内部类可以直接访问外部类的成员，包括私有
- 外部类要访问内部类的成员，必须创建对象



## 成员内部类

按照内部类在类中定义的位置不同，可以分为两种形式：

- 在类的成员位置：成员内部类
- 在类的局部位置：局部内部类（方法里面）

### 创建内部类对象

- 格式：

```java
外部类名.内部内名 对象名 = 外部类对象.内部类对象
public class Outer{

    private int num = 10;

    //一般内部类都是private的，因为不想直接给外部调用
    public class Inner{
        public void show(){
           System.out.println(num);
        }
    }
    
    //一般内部类的用法
    private class Inner2{
    	private void show2(){
        	System.out.println(num + num);
    	}   
	}
    //外部类中创建一个方法，方法里面创建内部类对象，调用内部类方法
    public void method(){
        Inner2 i2 = new Inner2();
        i2.show2();
    }
}

public class InnerDemo
{
    public static void main(String[] args)
    {
        //Inner i = new Inner();报错，不可以直接创建内部类对象
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
        
        //调用privat内部类中的方法
        Outer o = new Outer();
        o.method();
    }
}


```



## 局部内部类

在方法中定义类，所以外界无法直接使用，需要在方法内部创建对象并使用

该类可以直接访问外部类的成员，也可以访问方法内的局部变量

```java
public class Outer
{

    private int num = 10;

    public void method()
    {
        int num2 = 20;
        class Inner
        {
            public void show()
            {
                System.out.println(num);
                System.out.println(num2);
            }
        }
        
        Inner i = new Inner();
        i.show()
    }
}
```



### 匿名内部类

**前提：存在一个类或者接口，这里的类可以是具体类，也可以是抽象类**

**本质：一个继承了该类或者实现了该接口的子类匿名对象**

格式：

```java
new 类名或者接口名(){
    重写方法;
};

new Inner(){
    public void show(){
        System.out.println("匿名内部类");
    }
};//整一个是一个对象
-----------------------------------------------------------------------------------------
//范例：
public interface Inter
{
    void show();
}

public class Outer
{
    public void method()
    {
        ///本质上是一个实现了接口Inter的对象
        new Inter()
        {
            @Override
            public void show()
            {
                System.out.println("匿名内部类");
            }
        }.show();//本质上是一个实现了接口Inter的对象，所以可以直接调用方法
        
        //因为本质上是一个实现了接口Inter的对象，所以可以以多态的方式赋值给接口
        Inter i = new Inter()
        {
            @Override
            public void show()
            {
                System.out.println("匿名内部类");
            }
        };
        //多次调用
        i.show();
        i.show();
        i.show();
    }
}

public class InnerDemo
{
    public static void main(String[] args)
    {
        Outer o = new Outer();
        o.method();
    }
}
```



# 常用API

## Math

- 包含执行基本数字运算的方法
- 没有构造方法
- 调用的时候看类的成员是否都是 **静态** 的，如果是，通过类名就可以直接调用

|                   常用方法名                   |               说明               |
| :--------------------------------------------: | :------------------------------: |
|         `public static int abs(int a)`         |         返回参数的绝对值         |
|     `public static double ceil(double a)`      |   返回大于或等于参数的最小整数   |
|     `public static double floor(double a)`     |   返回小于或等于参数的最大整数   |
|       `public static int round(float a)`       | 按照四舍五入返回最接近参数的int  |
|     `public static int max(int a, int b)`      |     返回两个int值中的较大值      |
|     `public static int min(int a, int b)`      |     返回两个int值中的较小值      |
| `public static double pow(double a, double b)` |         返回a的b次幂的值         |
|        `public static double random()`         | 返回值为double的正值，[0.0, 1.0) |



## System

- 包含几个有用的类字段和方法，不能被实例化

|                常用方法名                |                    说明                    |
| :--------------------------------------: | :----------------------------------------: |
|  `public static void exit(int status)`   | 终止当前运行的Java虚拟机，非零表示异常终止 |
| `public static long currentTimeMillis()` |        返回当前时间（以毫秒为单位）        |



# Object类

- 类层次结构的根，每个类都可以将Object作为超类（super）
- 所有类都直接或者间接继承自Object类
- 构造方法：`public Object()`
- 子类的构造方法默认访问的是父类的无参构造方法，因为它们的顶级父类（Object）只有无参构造方法

|               方法名                |                            说明                            |
| :---------------------------------: | :--------------------------------------------------------: |
|     `public String toString()`      | 返回对象的字符串表达形式。建议所有子类重写该方法，自动生成 |
| `public boolean equals(Object obj)` | 比较对象是否相等，默认比较地址，重写可以比较内容，自动生成 |



## toString()

```java
public class Demo
{
    public static void main(String[] args){
    	Student s = new Student("迪丽热巴", 5);
    	System.out.println(s);//调用的是Object中的toString()方法
    }
    //public String toString(){
    //    return getClass().getName() + "@" + Integer.toHexString(hashCode());
    //}

}
```

自动生成代码：

```java
@Override
public String toString()
{
    return "Student{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
}
```



## equals()

自动生成代码：

```java
@Override
public boolean equals(Object o)
{
    //比较地址是否相同，如果相同，直接返回ture
    if (this == o) return true;
    //判断参数是否为null，判断是否来自于同一个类
    if (o == null || getClass() != o.getClass()) return false;
    
    //向下转型
    Student student = (Student) o;
    
    //比较姓名内容是否相同
    if (name != null ? !name.equals(student.name) : student.name != null) return false;
    //比较年龄内容是否相同
    return age != null ? age.equals(student.age) : student.age == null;
}
```



# Arrays

## 排序

将一组数据按照固定的规则进行排列

### 冒泡排序

- 对要进行排序的数据中相邻的数据进行两两比较，将较大的数据放在后面，依次对所有数据进行操作，直至按要求完成排序
  - 如果有 **n** 个数据进行排序，总共需要比较 **n-1** 次
  - 每次比较完毕，下一次的比较就会少一个数据参与

```java
for (int i = 0; i < arr.length - 1; i++)
    {
        for (int j = 0; i < arr.length - 1 - i; j++)
        {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
```



## Arrays类的概述

包含用于操作数组的各种方法

|                  方法名                  |                 说明                 |
| :--------------------------------------: | :----------------------------------: |
| `public static String toString(int[] a)` | 返回指定数组的内容的字符串表达形式。 |
|    `public static void sort(int[] a)`    |      按照数字顺序排列指定的数组      |



### 工具类的设计思想

- **构造方法用private修饰（防止外界创建对象）**
- **成员用public static修饰（使用类名访问成员方法）**



# 基本类型包装类

- 将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据

- 常用的操作之一：用于基本数据类型和字符串类型之间的转化

  | 基本数据类型 |    包装类     |
  | :----------: | :-----------: |
  |     byte     |     Byte      |
  |    short     |     Short     |
  |   **int**    |  **Integer**  |
  |     long     |     Long      |
  |    float     |     Float     |
  |    double    |    Double     |
  |   **char**   | **Character** |
  |   boolean    |    Boolean    |



## Integer类

### 构造方法

Integer：包装一个对象中的原始类型int的值

|                  方法名                   |                 说明                  |
| :---------------------------------------: | :-----------------------------------: |
|        `public Integer(int value)`        |   根据int值创建Integer对象（过时）    |
|        `public Integer(String s)`         |  根据String值创建Integer对象（过时）  |
|  `public static Integer valueOf(int i)`   |   返回表示指定的int值得Integer实例    |
| `public static Integer valueOf(String s)` | 返回一个保存指定值得Integer对象String |

```java
Integer i1 = Integer.valueOf(100);
Integer i2 = Integer.valueOf("100");
```



### int和String的相互转化

基本类型包装类最常用的操作就是：用于基本数据类型和字符串类型之间的转化

- int转换为String
  - `public static String valueOf(int i)`：返回int参数得字符串表示形式。String类中的方法
- String转换为int
  - `public static int parseInt(String s)`：将字符串解析为int类型。Integer类中的方法

```java
//int → String
int num = 100;

//方法1
String s1 = "" + num; 

//方法2
String s2 = String.valueOf(num);

//String → int
String s = "100";

//方法1
//String---Integer---int
Integer i = Integer.valueOf(s);
int x = i.intValue();

//方法2
int y = Integer.parseInt(s);

```



## 自动装箱和拆箱

- 装箱：把基本数据类型转化为对应的包装类类型
- 拆箱：把包装类类型转化为对应的基本数据类型
- **注意：在使用包装类类型的时候，如果做操作，最好先判断是否为null**
- **推荐：只要是对象，在使用前就必须进行不为null的判断**

```java
//装箱
Integer i = Integer.valueOf(100);
//自动装箱
Integer ii = 100;//自动调用了valueOf(100)方法

//拆箱
i = i.intValue()/*拆箱动作*/ + 200;//int 类型最后赋值给了i（Integer类型），自动装箱
//自动拆箱
i += 200;//内部隐含了拆箱操作和自动装箱
/*
分解开来就是：
i + 200 自动拆箱
i = i + 200 自动装箱
*/
```
