package java_4_27;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {

        public static void main1(String[] args){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            for (int i = 0; i < 10; i++) {
                list.add(i + 10);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(list.get(i));
            }
            System.out.println(list.toString());
        }
    }
