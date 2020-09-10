package com.lambda;

public class MyStringDemo
{
    public static void main(String[] args)
    {
        useMyString((String s, int x, int y) ->
        {
            return s.substring(x, y);
        });

        useMyString((s, x, y) -> s.substring(x, y));

        useMyString(String::substring);

    }

    private static void useMyString(MyString my)
    {
        String s = my.mySubString("HelloWorld", 2, 5);
        System.out.println(s);
    }
}
