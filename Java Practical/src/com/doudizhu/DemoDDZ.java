package com.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class DemoDDZ
{
    public static void main(String[] args)
    {
//        DouDiZhu ddz = new DouDiZhu();
//        ArrayList<String> cards = ddz.getArr();
//        ArrayList<String> player0 = ddz.getPlayer0();
//        ArrayList<String> player1 = ddz.getPlayer1();
//        ArrayList<String> player2 = ddz.getPlayer2();
//        ArrayList<String> dzp = ddz.getDiZhuPai();
//
//        ddz.createCards(cards);
//        ddz.shuffleCards(cards);
//        ddz.dealCards(cards, player0, player1, player2, dzp);
//        ddz.checkCards("player0", player0);
//        ddz.checkCards("player1", player1);
//        ddz.checkCards("player2", player2);
//        ddz.checkCards("地主牌", dzp);
        //创建牌盒
        HashMap<Integer, String> hm = new HashMap<>();

        //创建装有牌的编号的ArrayList
        ArrayList<Integer> array = new ArrayList<>();

        //创建TreeSet玩家
        TreeSet<Integer> player0 = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> dzp = new TreeSet<>();

        //定义花色数组
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义点数数组
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        //把牌存入牌盒HashMap
        int index = 0;
        for (String color : colors)
        {
            for (String num : numbers)
            {
                hm.put(index, color + num);
                //把牌放入HashMap的同时，把编号放入ArrayList
                array.add(index);
                index++;
            }
        }

        //不要忘记大小王
        hm.put(index, "Black Joker");
        array.add(index);
        index++;
        hm.put(index, "Color Joker");
        array.add(index);

        //洗牌
        Collections.shuffle(array);

        //发牌
        for (int i = 0; i < array.size(); i++)
        {
            int x = array.get(i);
            if (i >= array.size() - 3)
            {
                dzp.add(x);
            }
            else if (i % 3 == 0)
            {
                player0.add(x);
            }
            else if (i % 3 == 1)
            {
                player1.add(x);
            }
            else
            {
                player2.add(x);
            }
        }
        checkCards("player0", player0,hm);
        checkCards("player1", player1,hm);
        checkCards("player2", player2,hm);
        checkCards("地主牌", dzp,hm);

    }

    public static void checkCards(String name, TreeSet<Integer> treeSet, HashMap<Integer, String> hashMap)
    {
        System.out.println(name + "的牌是：");
        for (Integer i : treeSet)
        {
            String card = hashMap.get(i);
            System.out.print(card + " ");
        }
        System.out.println();
        System.out.println();
    }


}
