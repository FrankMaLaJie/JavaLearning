package com.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo
{
    public static void main(String[] args)
    {
        Generic<String> g1 = new Generic<>();
        g1.setT("迪丽热巴");
        System.out.println(g1.getT());

        Generic<Integer> g2 = new Generic<>();
        g2.setT(28);
        System.out.println(g2.getT() + "岁");

    }


}
