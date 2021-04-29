package java_4_29;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Card{
    private String suit;
    private String point;

    public Card(String suit, String point) {
        this.suit = suit;
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "["+this.suit+this.point+"]";
    }
}
public class Poker {
    //扑克牌实现
    public static void main(String[] args) {
        List<Card> poker = buyPoker();
        System.out.println(poker);
        //洗牌
        Collections.shuffle(poker);
        //玩家数组
        List<List<Card>> players = new ArrayList<>();
        //玩家数量
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                player.add(poker.remove(0));
            }
        }
        System.out.println(players.get(0));
        System.out.println(players.get(1));
        System.out.println(players.get(2));

    }

    public static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();

        String[] suits = {"♥","♠","♣","♦"};

        for (int i = 0; i < 4; i++) {
            //这个循环处理四种花色
            for (int j = 2; j <= 10; j++) {
                //2~10数字
                poker.add(new Card(suits[i],""+j));
            }
            poker.add(new Card(suits[i],"A"));
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
        }
        return poker;


    }







}
