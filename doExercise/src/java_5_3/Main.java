package java_5_3;

import java.util.*;

class Card implements Comparable<Card> {
    public String val;
    public String suit;
    public Card(String val, String suit) {
        this.val = val;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        //按照值来进行比较
        //1.自己和自己进行比较
        if(this==o) return true;
        //2.o为null或者o不是当前Card类型
        if(o==null||!(o instanceof Card)) return false;
        Card card = (Card)o;
        //3.真正的内容比较
        return this.suit.equals(card.suit)&&this.val.equals(card.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, suit);
    }

    @Override//实现comparable，重写compareTo方法
    public int compareTo(Card o) {
        //this>o 返回值大于零
        //this=o 返回值等于零
        //this<o 返回值小于零
        if(o==null) return -1;
        int val1 = getValue(this.val);
        int val2 = getValue(o.val);
        return val1 - val2;
    }
    private int getValue(String val) {
        if("J".equals(val)){
            return 11;
        }else if("Q".equals(val)){
            return 12;
        }else if("K".equals(val)){
            return 13;
        }else if("A".equals(val)){
            return 14;
        }else {
            return Integer.parseInt(val);
        }
    }
}

class CardComparator implements Comparator<Card>{
    //comparator比较器 两个对象的比较 耦合性bijiaod
    @Override
    public int compare(Card o1, Card o2) {
        if(o1==o2) return 0;
        if(o1 == null) return -1;
        if(o2 == null) return 1;
        int val1 = getValue(o1.val);
        int val2 = getValue(o2.val);
        return val1-val2;
    }

    private int getValue(String val) {
        if("J".equals(val)){
            return 11;
        }else if("Q".equals(val)){
            return 12;
        }else if("K".equals(val)){
            return 13;
        }else if("A".equals(val)){
            return 14;
        }else {
            return Integer.parseInt(val);
        }
    }
}



public class Main {
    static class Test implements Comparable<Test>{

        @Override
        public int compareTo(Test o) {
            return 0;
        }
    }


    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

    }


    public static void main2(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,4);
        map.put(4,8);
        map.put(5,10);

        //迭代器遍历map
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //foreach
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }



    }

    public static void main1(String[] args) {
        Card card1 = new Card("3","♠");
        Card card2 = new Card("3","♥");
        Card card3 = new Card("3","♥");
        Card card4 = new Card("4","♥");
        System.out.println(card1.equals(card2));
        System.out.println(card2.equals(card3));
        System.out.println(card1.compareTo(card4));
        CardComparator comparator = new CardComparator();
        System.out.println(comparator.compare(card4, card2));

    }
}


//    static class Animal {
//
//    }
//
//    static class dog extends Animal {
//
//    }
//
//    static class bird extends Animal {
//
//    }
