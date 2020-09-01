package com.API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo
{
    public static void main(String[] args) throws ParseException
    {
//        String s = "91 27 46 38 50";
//
//        String[] strArr = s.split(" ");
//
//        int[] arr = new int[strArr.length];
//
//        for (int i = 0; i < strArr.length; i++)
//        {
//            arr[i] = Integer.parseInt(strArr[i]);
//        }
//
//        Arrays.sort(arr);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < arr.length; i++)
//        {
//            if (i == arr.length - 1)
//            {
//
//                stringBuilder.append(arr[i]);
//            }
//            else
//            {
//                stringBuilder.append(arr[i]).append(" ");
//            }
//        }
//
//        String result = stringBuilder.toString();
//        System.out.println(result);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(date);
        System.out.println(s);

        String s1 = "2020-08-26 23:29:19";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf2.parse(s1);
        System.out.println(date1);

    }
}
