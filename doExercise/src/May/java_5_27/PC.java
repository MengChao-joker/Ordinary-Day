package May.java_5_27;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class PC {

    private int size;
    private int first;
    private int last;
    private int[] container;

    public PC(int size) {
        this.size = 0;
        first = 0;
        last = 0;
        container = new int[size];
    }


    //生产
    public synchronized void produce(int good) throws InterruptedException {
        if (size == container.length) {
            System.out.println("容器已满！");
            this.wait();
        }
        container[last++] = good;
        if (last == container.length) {
            last = 0;
            size++;
        }
        notify();
    }

    public synchronized int custom() throws InterruptedException {
        if (size == 0) {
            this.wait();
        }
        int ret = 0;
        ret = container[first++];
        if (first == container.length) {
            first = 0;
            size--;
        }
        notify();
        return ret;
    }



}

