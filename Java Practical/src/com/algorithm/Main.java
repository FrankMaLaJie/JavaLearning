package com.algorithm;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.sort;

public class Main
{

    public static void main(String[] args)
    {
        File file = new File("F:\\学习视频");
        traverseDir(file);
    }

    //遍历目录
    public static void traverseDir(File file)
    {
        //获取给定的File目录下所有的文件或者目录的File数组
        File[] listFiles = file.listFiles();

        //遍历File数组，得到每一个File对象
        //先判断File数组是否为null
        if (listFiles != null)
        {
            //遍历File数组，获取每一个File对象
            for (File f : listFiles)
            {
                //如果是目录，递归
                if (f.isDirectory())
                {
                    traverseDir(f);
                }
                //如果不是，输出
                else
                {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    //求阶乘
    public static int factorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return n * factorial(n - 1);
        }
    }

    public static void addStudent(ArrayList<Student> arrayList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生姓名");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄");
        int age = scanner.nextInt();

        Student s = new Student();
        s.setName(name);
        s.setAge(age);

        arrayList.add(s);
    }

    public static String ReverseStringNew(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        return s;

        //匿名对象，一行代码解决,等价于上面三行代码
        //return new StringBuffer(s).reverse().toString();
    }

    public static String ArrayToStringNew(int[] arr)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length - 1)
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

    public static String ReverseString(String s)
    {
        String rs = "";

        for (int i = s.length() - 1; i >= 0; i--)
        {
            rs += s.charAt(i);
        }

        return rs;
    }

    public static String ArrayToString(int[] arr)
    {
        String s = "";
        s += "[";

        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length - 1)
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

    //统计字符出现次数
    public static void CountStrType(String s)
    {
        int cap = 0;
        int low = 0;
        int num = 0;


        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
            {
                cap++;
            }
            else if (ch >= 'a' && ch <= 'z')
            {
                low++;
            }
            else if (ch >= '0' && ch <= '9')
            {
                num++;
            }
        }
        System.out.println("大写字母有：" + cap + "个");
        System.out.println("小写字母有：" + low + "个");
        System.out.println("数字有：" + num + "个");
    }

    //遍历打印字符串
    public static void PrintStr(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            System.out.println(s.charAt(i));
        }
    }

    //用户登陆
    public static void Login()
    {
        String userName = "frank";
        String password = "123";

        for (int i = 0; i < 3; i++)
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
            else if (2 - i == 0)
            {
                System.out.println("登陆失败，你的账户已被锁定，请与管理员联系");
            }
            else
            {
                System.out.println("登陆失败，你还有" + (2 - i) + "次机会");
            }
        }
    }

    //评委打分
    public static void InputScore()
    {
        int[] arr = new int[6];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++)
        {
            System.out.println("请输入第" + (i + 1) + "个评委的打分");
            arr[i] = sc.nextInt();
        }
        int max = getMax(arr);
        int min = getMin(arr);
        int sum = getSum(arr);

        int avg = (sum - max - min) / (arr.length - 2);
        System.out.println(avg);
    }

    //求最大值
    public static int getMax(int[] arr)
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    //求最小值
    public static int getMin(int[] arr)
    {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }

    //求和
    public static int getSum(int[] arr)
    {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    //数组反转
    public static void ReverseInt(int[] arr)
    {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    //遍历打印数组
    public static void PrintArray(int[] arr)
    {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length - 1)
            {
                System.out.print(arr[i]);
            }
            else
            {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    //拍7
    public static void clapNum()
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++)
        {
            if (i % 10 != 7 || i / 10 % 10 != 7 || i % 7 != 0)
            {
                list.add(i);
            }
        }
        System.out.println(list);

    }

    //斐波那契数列
    public static void FibonacciSequence()
    {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        //从第三个数开始
        for (int i = 2; i < arr.length; i++)
        {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[19]);
    }

    //百钱百鸡
    public static void BuyChicken()
    {
        for (int x = 0; x <= 20; x++)
        {
            for (int y = 0; y <= 33; y++)
            {
                int z = 100 - x - y;
                if (z % 3 == 0 && 5 * x + 3 * y + z / 3 == 100)
                {
                    System.out.println("公鸡有：" + x + "，" + "母鸡有：" + y + "，" + "小鸡有：" + z);
                }
            }
        }
    }

    //数组指定元素求和
    public static void SumArray()
    {
        //求出数组中满足要求的元素的和，元素的个位和十位都不能是7，且只能是偶数。
        int[] arr = {68, 27, 95, 88, 171, 996, 51, 210};
        int max = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 10 != 7 && arr[i] / 10 % 10 != 7 && arr[i] % 2 == 0)
            {
                max += arr[i];
            }
        }
        System.out.println(max);
    }

    //对比数组
    public static boolean CompareArray()
    {
        int[] arr1 = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 55, 44};

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

    //获取索引
    public static int getIndex(int[] arr, int num)
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

    //不重复随机数
    public static void notRepeatRandomNum()
    {
        Set<Integer> set = new HashSet<>();

        Random r = new Random();

        while (set.size() < 10)
        {
            set.add(r.nextInt(20) + 1);
        }

        for (Integer i : set)
        {
            System.out.println(i);
        }
    }

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

    public static void WriteExcel() throws IOException
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
    }

    public static void ReadExcel(List<String> news) throws IOException
    {
        //从Excel文件中读取新闻数据打印到控制台
        List<String> news2 = new ArrayList<String>();
        news2 = ReadExcel.readExcel("G:/news.xlsx");
        for (String str : news)
        {
            System.out.println(str);
        }
    }

}
