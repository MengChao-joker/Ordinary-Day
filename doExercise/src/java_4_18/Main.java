package java_4_18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.abs(4 - 9));
    }
    public static void main3(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("asd");
        list.add("qwe");
        System.out.println(list.get(1));
        System.out.println(list.getLast());
        System.out.println(list.getFirst());
        System.out.println(list.toString());
    }
    public static void main2(String[] args) {
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) {
            System.out.println(nums[i]);
        }
        String str = "asd";
        System.out.println(str.charAt(1));
    }
    public static void main1(String[] args) {
        Integer i =1;
        System.out.println(i==1);
    }
}
