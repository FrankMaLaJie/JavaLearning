package com.stream;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo
{
    public static void main(String[] args)
    {
    }

    public static void zhangList()
    {
        ////创建一份名单
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
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }

    public static void createStream()
    {
        //`Collection`体系的集合可以使用默认方法`stream()`生成流
        List<String> list = new ArrayList<>();
        Stream<String> listString = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        //`Map`体系的集合间接的生成流
        Map<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        //数组可以通过`Stream`接口的静态方法`of(T...values)`生成流
        String[] strArr = {"hello", "world", "java"};
        Stream<String> strArrStream = Stream.of(strArr);
        Stream<String> strArrStream2 = Stream.of("hello", "world", "java");
        Stream<Integer> integerStream = Stream.of(10, 20, 30);
    }

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
        //Stream.concat(stream1, stream2).distinct().forEach(System.out::println);
        System.out.println("--------");

        //需求4：按照顺序把数据在控制台输出
        //list.stream().sorted().forEach(System.out::println);
        System.out.println("--------");

        //需求5：按照字符串长度在控制在输出
        list.stream().sorted((s1, s2) ->
        {
            int num = s1.length() - s2.length();
            int num2 = num == 0 ? s1.compareTo(s2) : num;
            return num2;
        }).forEach(System.out::println);

        //需求6：将集合中的字符串数据转换为整数后输出
        //list2.stream().map(Integer::parseInt).forEach(System.out::println);
        int sum = list2.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

    }

    public static void endOperation()
    {
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

    public static void actor()
    {
        //创建集合
        ArrayList<String> manList = new ArrayList<>();
        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");

        ArrayList<String> womanList = new ArrayList<>();
        womanList.add("林心如");
        womanList.add("林青霞");
        womanList.add("张曼玉");
        womanList.add("柳岩");
        womanList.add("林志玲");
        womanList.add("王祖贤");

        //男演员只要名字为3个字的前3人
        Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);

        //女演员只要姓林的，并且不要第1个人
        Stream<String> womanStream = womanList.stream().filter(s -> s.startsWith("林")).skip(1);

        //把过滤后的男演员和女演员姓名合并到一起
        Stream<String> stream = Stream.concat(manStream, womanStream);

        //把上个步骤操作后的元素作为构造方法的参数创建演员对象，遍历数据
        stream.map(Actor::new).forEach(a -> System.out.println(a.toString()));
    }

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

}
