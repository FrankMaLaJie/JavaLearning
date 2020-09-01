package com.doudizhu;

import java.util.ArrayList;

public class DemoDDZ
{
    public static void main(String[] args)
    {
        DouDiZhu ddz = new DouDiZhu();
        ArrayList<String> cards = ddz.getArr();
        ArrayList<String> player0 = ddz.getPlayer0();
        ArrayList<String> player1 = ddz.getPlayer1();
        ArrayList<String> player2 = ddz.getPlayer2();
        ArrayList<String> dzp = ddz.getDiZhuPai();

        ddz.createCards(cards);
        ddz.shuffleCards(cards);
        ddz.dealCards(cards, player0, player1, player2, dzp);
        ddz.checkCards("player0", player0);
        ddz.checkCards("player1", player1);
        ddz.checkCards("player2", player2);
        ddz.checkCards("地主牌", dzp);


    }


}
