package com.lambda;

public class ConverterDemo
{
    public static void main(String[] args)
    {
        useConverter(s -> Integer.parseInt(s));

        useConverter(Integer::parseInt);
    }

    private static void useConverter(Converter c){
        int num = c.convert("666");
        System.out.println(num);
    }
}
