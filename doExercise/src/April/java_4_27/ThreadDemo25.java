package java_4_27;

import java.util.HashSet;
import java.util.Set;

public class ThreadDemo25 {
    //生产者消费者模型
    static class BlockingQueue{
        private int head = 0;
        private int tail = 0;
        private volatile int size = 0;
        int[] goods = null;

        public BlockingQueue() {
            this.goods = new int[1000];
        }

        public void put(int value) throws InterruptedException {
            synchronized (this) {
                if(size==1000){
                    System.out.println("仓库已满！请等有空缺~");
                    wait();
                }
                goods[tail] = value;
                tail++;
                if(tail==1000) tail = 0;
                size++;
                notify();
            }
        }

        public int take() throws InterruptedException {
            synchronized (this) {
                if(size==0){
                    System.out.println("没货了！请等等~");
                    wait();
                }
                int ret = goods[head];
                head++;
                if(head==1000) head = 0;
                size--;
                notify();
                return ret;
            }
        }
    }




    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new BlockingQueue();

        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    try {
                        queue.put(i);
                        System.out.println("producer生产了"+i);
//                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        Thread customer = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        int ret = queue.take();
                        System.out.println("customer消费了"+ret);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        customer.start();
        customer.join();
        customer.join();
    }

}
