package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
    private DateUtils(){};

    public static String dateToString(Date date, String format){
        //使用带参（format）构造方法，创建sdf对象
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //定义一个字符串接收转化成固定格式的日期字符串
        String s = sdf.format(date);
        //返回字符串
        return s;
    }

    public static Date stringToDate(String s, String format) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Date d = sdf.parse(s);

        return d;

    }
}
