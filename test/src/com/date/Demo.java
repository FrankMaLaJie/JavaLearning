package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo
{
    public static void main(String[] args)
    {
        String s1 = "2020-08-26 23:29:19";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//报错，因为s1中的格式和创建sdf2的格式不同
        Date date1 = null;
        try
        {
            date1 = sdf2.parse(s1);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(date1);


    }

//    //键盘输入年份
//    Scanner sc = new Scanner(System.in);
//        System.out.println("请输入要查询的年份：");
//    int year = sc.nextInt();
//
//    //设置日历对象的年月日
//    Calendar c = Calendar.getInstance();
//        c.set(year, 2, 1);
//
//    //3月1日向前推一天，获取2月的最后一天
//        c.add(Calendar.DATE, -1);
//    int date = c.get(Calendar.DATE);
//
//        System.out.println(year + "年的2月份有" + date + "天");
}
