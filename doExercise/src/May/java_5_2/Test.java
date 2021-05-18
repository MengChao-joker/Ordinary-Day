package java_5_2;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        System.out.println(queue.toString());
    }
}
