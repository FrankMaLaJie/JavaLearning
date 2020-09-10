package com.functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo
{
    public static void main(String[] args)
    {
        printInfoConsumer();
    }

    public static void interfaceAsReturn()
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

    private static Comparator<String> getComparator()
    {
        return Comparator.comparingInt(String::length);
        //return (s1, s2) -> s1.length() - s2.length();
    }

    public static void testSupplier()
    {
        String s = getString(() -> "你好");
    }

    private static String getString(Supplier<String> sup)
    {
        return sup.get();
    }

    //定义一个方法获取最大值
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

    //定义一个方法消费一个字符串;消费一个字符串两次
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

    //消费字符串数组
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


}
