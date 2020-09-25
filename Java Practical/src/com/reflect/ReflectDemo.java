package com.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.TreeSet;

public class ReflectDemo
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IOException
    {
        runFileContent();
    }


    public static void constructor() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException
    {
        Class<?> c = Class.forName("com.studentmanager.Student");

        //构造函数
        Constructor<?>[] cons = c.getConstructors();
        Constructor<?>[] decCons = c.getDeclaredConstructors();

        for (Constructor con : cons)
        {
            System.out.println(con);
        }

        for (Constructor con : decCons)
        {
            System.out.println(con);
        }

        Constructor<?> con = c.getConstructor(String.class, String.class);
        Constructor<?> decCon = c.getDeclaredConstructor(String.class, String.class, String.class, String.class);

        Object obj = con.newInstance("迪丽热巴", "28");
        Object decObj = decCon.newInstance("123", "迪丽热巴", "28", "123");
        System.out.println(obj);
        System.out.println(decObj);
    }

    public static void field() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
    {
        Class<?> c = Class.forName("com.studentmanager.Student");

        Constructor<?> con = c.getConstructor(String.class, String.class);

        Object obj = con.newInstance("迪丽热巴", "28");

        //成员变量
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

        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(obj, "长安");
        System.out.println(obj);
    }

    public static void method() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException
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
        Method decm = c.getDeclaredMethod("haha");

        decm.setAccessible(true);
        decm.invoke(obj);
    }

    public static void addString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        ArrayList<Integer> arr = new ArrayList<>();

        Class<? extends ArrayList> c = arr.getClass();

        Method m = c.getMethod("add", Object.class);

        m.invoke(arr,"String");

        System.out.println(arr);
    }

    public static void runFileContent() throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        //创建一个class.txt文件
        //内容是：
        //className=xxx(包含包名)
        //methodName=xxx

        //加载数据
        Properties prop = new Properties();
//        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("class.txt");
//        prop.load(is);
        FileReader fr = new FileReader("G:\\Github Desktop\\JavaLearning\\Java Practical\\src\\com\\reflect\\class.txt");
        prop.load(fr);
        fr.close();

        /*
        *
        * className=com.studentmanager.Student
        * methodName=haha
        *
        */
        //获取配置文件中对应的类和类中的方法
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //通过反射来使用
        Class<?> c = Class.forName(className);//com.studentmanager.Student
        Constructor<?> con = c.getConstructor();

        //创建对象，获取方法对象
        Object obj = con.newInstance();
        Method m = c.getMethod(methodName);

        m.setAccessible(true);
        m.invoke(obj);//nihao
    }

}
