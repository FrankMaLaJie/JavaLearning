package com.map;

import com.algorithm.Student;

import java.util.*;

public class MapDemo
{
    public static void main(String[] args)
    {
        sortArrayList();
    }


    public static void traverseByKey()
    {
        Map<String, Integer> map = new HashMap<>();

        map.put("一二三", 123);
        map.put("四五六", 456);
        map.put("七八九", 789);

        Set<String> keySet = map.keySet();

        for (String key : keySet)
        {
            Integer value = map.get(key);
            System.out.println(key + "," + value);
        }
    }

    public static void traverseByKeyAndValue()
    {
        Map<String, Integer> map = new HashMap<>();

        map.put("一二三", 123);
        map.put("四五六", 456);
        map.put("七八九", 789);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        for (Map.Entry<String, Integer> me : entrySet)
        {
            System.out.println(me.getKey() + "," + me.getValue());
        }
    }

    public static void hashMapDemo1()
    {
        HashMap<String, Student> hm = new HashMap<>();

        Student s1 = new Student("迪丽热巴", 28);
        Student s2 = new Student("马拉杰", 24);

        hm.put("123", s1);
        hm.put("456", s2);

        Set<String> keySet = hm.keySet();

        for (String key : keySet)
        {
            Student value = hm.get(key);
            System.out.println(key + "," + value.getName() + "," + value.getAge());
        }

        Set<Map.Entry<String, Student>> entrySet = hm.entrySet();

        for (Map.Entry<String, Student> me : entrySet)
        {

            System.out.println(me.getKey() + "," + me.getValue());
        }

    }

    public static void hashMapDemo2()
    {
        HashMap<Student, String> hm = new HashMap<>();

        Student s1 = new Student("迪丽热巴", 28);
        Student s2 = new Student("马拉杰", 24);
        Student s3 = new Student("孙仁杰", 25);
        Student s4 = new Student("孙仁杰", 25);


        hm.put(s1, "长安");
        hm.put(s2, "大朗");
        hm.put(s3, "松山湖");
        hm.put(s4, "东莞");


        Set<Student> keySet = hm.keySet();

        for (Student key : keySet)
        {
            System.out.println(key + hm.get(key));
        }
    }

    public static void hashMapInArrayList()
    {
        ArrayList<HashMap> arr = new ArrayList<>();

        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("孙策", "大乔");
        hm1.put("周瑜", "小乔");

        HashMap<String, String> hm2 = new HashMap<>();
        hm1.put("郭靖", "黄蓉");
        hm1.put("杨过", "小龙女");

        HashMap<String, String> hm3 = new HashMap<>();
        hm1.put("令狐冲", "任盈盈");
        hm1.put("林平之", "岳灵珊");

        arr.add(hm1);
        arr.add(hm2);
        arr.add(hm3);

        for (HashMap<String, String> hashMap : arr)
        {
            Set<String> keySet = hashMap.keySet();
            for (String key : keySet)
            {
                System.out.println(key + hashMap.get(key));
            }
        }


    }

    public static void arrayListInHashMap()
    {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        ArrayList<String> sgyy = new ArrayList<>();
        sgyy.add("诸葛亮");
        sgyy.add("赵云");
        hm.put("三国演义", sgyy);

        ArrayList<String> xyj = new ArrayList<>();
        xyj.add("唐僧");
        xyj.add("孙悟空");
        hm.put("西游记", xyj);

        ArrayList<String> shz = new ArrayList<>();
        shz.add("武松");
        shz.add("鲁智深");
        hm.put("水浒传", shz);

        Set<String> keySet = hm.keySet();
        for (String key : keySet)
        {
            System.out.println(key);
            ArrayList<String> value = hm.get(key);
            for (String s : value)
            {
                System.out.println(s);
            }
        }
    }

    public static void numOfChar()
    {
        //键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = sc.nextLine();

        //创建HashMap集合，键是字符，值是字符出现的次数
        TreeMap<Character, Integer> tm = new TreeMap<>();

        //遍历字符串，得到每一个字符,判断HashMap中是否含有遍历出来的键
        //拿得到的每一个字符作为键，判断HashMap中是否含有这个键
        for (int i = 0; i < str.length(); i++)
        {
            char key = str.charAt(i);

            //- 如果返回不是null：说明该字符在HashMap中存在，就把该该值+1，然后重新存储该字符和对应的值
            if (tm.containsKey(key))
            {
                tm.put(key, tm.get(key) + 1);
            }
            //- 如果返回null：说明该字符在HashMap中不存在，就把该字符作为键，1作为值存储
            else
            {
                tm.put(key, 1);
            }
        }

        //创建StringBuilder对象
        StringBuilder sb = new StringBuilder();

        //遍历HashMap
        Set<Character> keySet = tm.keySet();
        for (Character key : keySet)
        {
            sb.append(key).append("(").append(tm.get(key)).append(")");
        }
        System.out.println(sb);
    }

    public static void sortArrayList()
    {
        ArrayList<Student> arr = new ArrayList<>();

        Student s1 = new Student("a迪丽热巴", 28);
        Student s2 = new Student("b马拉杰", 24);
        Student s3 = new Student("c孙仁杰", 25);
        Student s4 = new Student("d孙仁杰", 25);

        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);

        Collections.sort(arr, new Comparator<Student>()
        {
            @Override
            public int compare(Student s1, Student s2)
            {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });


        for (Student s:arr){
            System.out.println(s.getName() + s.getAge());
        }
    }


}
