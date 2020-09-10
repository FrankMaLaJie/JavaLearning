package com.lambda;

public class PrintDemo
{
    public static void main(String[] args)
    {
        //Lambda表达式
        usePrinter(s -> System.out.println(s.toUpperCase()));

        //引用对象的实例方法
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);

    }

    private static void usePrinter(Printer p)
    {
        p.printUpperCase("HelloWorld");
    }
}
