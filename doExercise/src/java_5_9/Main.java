package java_5_9;

import java.util.Arrays;

public class Main {
    abstract class A{

        private void b(){};
    }

    public static void main(String[] args) {
        String str = "asdf";
        System.out.println(str.substring(0,4));
    }


    public static void main1(String[] args) {
        int nums[] = new int[10];
        System.out.println(Arrays.toString(nums));
    }
}
