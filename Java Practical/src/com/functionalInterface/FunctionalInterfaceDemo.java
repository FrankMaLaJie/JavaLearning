package com.functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo
{
    public static void main(String[] args)
    {
        convertFunction();
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
        return pre1.and(pre2).test(s);
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

}
