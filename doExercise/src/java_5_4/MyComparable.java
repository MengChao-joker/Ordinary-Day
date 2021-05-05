package java_5_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MyComparable {
    static class MyComparator implements Comparator<Card>{

        @Override
        public int compare(Card o1, Card o2) {
            if(o1==o2) return 0;
            if(o1==null) return -1;
            if(o2==null) return 1;
            return getVal(o1)-getVal(o2);
        }
        private int getVal(Card card) {
            if (card.val.equals("J")) {
                return 11;
            } else if (card.val.equals("Q")) {
                return 12;
            } else if (card.val.equals("K")) {
                return 13;
            } else if (card.val.equals("A")) {
                return 14;
            } else {
                return Integer.parseInt(card.val);
            }
        }
    }
    static class Card implements Comparable<Card> {
        private String val;
        private String suit;

        public Card(String val, String suit) {
            this.val = val;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "val='" + val + '\'' +
                    ", suit='" + suit + '\'' +
                    '}';
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }


        private int getSuit(Card card){
            if(card.suit=="♠"){
                return 4;
            }else if(card.suit=="♥"){
                return 3;
            }else if(card.suit=="♣"){
                return 2;
            }else {
                return 1;
            }
        }


        private int getVal(Card card) {
            if (card.val.equals("J")) {
                return 11;
            } else if (card.val.equals("Q")) {
                return 12;
            } else if (card.val.equals("K")) {
                return 13;
            } else if (card.val.equals("A")) {
                return 14;
            } else {
                return Integer.parseInt(card.val);
            }
        }

        @Override
        public int compareTo(Card o) {
            Card card = (Card) o;
            if (o == null) return -1;
            if (this.getVal() != card.getVal()) {
                return getVal(this) - getVal((Card) o);
            }else {
                return getSuit(this)-getSuit(card);
            }
        }
    }

    public static void main(String[] args) {
        Card card = new Card("A", "♥");
        Card card2 = new Card("A", "♣");
        Card card1 = new Card("10", "♠");
        System.out.println(card.compareTo(card2));
        System.out.println(card.compareTo(card1));
    }


    public static void main2(String[] args) {
        Integer i = 0;
        Integer i1 = new Integer(0);
        int i3 = new Integer(3);
        int i4 = 3;
        i3 = i.intValue();

    }


    public static void main1(String[] args) {
        String str1 = "jack";
        String str2 = new String("rose");
        String str3 = "rose";
//        System.out.println(str2 == str3);
//        System.out.println(str2.equals(str3));
//        System.out.println(str1.compareTo(str2));
        List<String> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) return 0;
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

}
