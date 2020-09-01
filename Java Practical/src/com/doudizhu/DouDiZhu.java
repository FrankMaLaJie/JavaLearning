package com.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class DouDiZhu
{
    /*
            - 创建牌盒，也就是定义一个集合对象，
                - 用ArrayList集合实现
            - 往牌盒里面装牌
            - 洗牌，也就是把牌打散
              - 用Collections的shuffle()方法实现
            - 发牌，也就是遍历集合，给三个玩家发牌
            - 看牌，也就是三个玩家分别遍历自己的牌
     */
    //创建牌盒
    private HashMap<Integer,String> hm = new HashMap<>();

    //创建装有牌的编号的ArrayList
    private ArrayList<Integer> array = new ArrayList<>();

    //创建玩家
    private ArrayList<String> player0 = new ArrayList<>();
    private ArrayList<String> player1 = new ArrayList<>();
    private ArrayList<String> player2 = new ArrayList<>();
    private ArrayList<String> diZhuPai = new ArrayList<>();

    public DouDiZhu()
    {
    }



    //装牌
    public ArrayList<String> createCards(ArrayList<String> arr)
    {
        /*
            ♠2，♠3，♠4.....♠K，♠A
            ♥2...
            ♣2...
            ♦2...
        */

        //定义花色数组
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义点数数组
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        //花色点数组合，并且添加到牌盒中，包括大小王
        for (String color : colors)
        {
            for (String num : numbers)
            {
                arr.add(color + num);
            }
        }
        arr.add("Black Joker");
        arr.add("Color Joker");

        return arr;
    }

    //洗牌
    public void shuffleCards(ArrayList<String> arr)
    {
        Collections.shuffle(arr);
    }

    //发牌
    public void dealCards(ArrayList<String> arr, ArrayList<String> player0, ArrayList<String> player1,
                          ArrayList<String> player2, ArrayList<String> diZhuPai)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            String card = arr.get(i);
            if (i >= arr.size() - 3)
            {
                diZhuPai.add(card);
            }
            else if (i % 3 == 0)
            {
                player0.add(card);
            }
            else if (i % 3 == 1)
            {
                player1.add(card);
            }
            else
            {
                player2.add(card);
            }
        }
    }

    //看牌
    public void checkCards(String name, ArrayList<String> arr)
    {

        System.out.println(name + "的牌是：");

        for (String card : arr)
        {
            System.out.print(card + " ");
        }

        //换行
        System.out.println();
    }

}
