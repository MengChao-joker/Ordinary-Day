package java_4_27;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.List;

public class ThreadDemo24 {
    //阻塞队列：生产者-消费者模型

    static class BlockingQueue{
        private int head = 0;
        private int tail = 0;
        private volatile int size = 0;
        List<Integer> list = new ArrayList<>();

        public int getHead() {
            return head;
        }

        public int getTail() {
            return tail;
        }

        public int getSize() {
            return size;
        }

        public void put(int num) throws InterruptedException {
            synchronized (this) {
                while(size==1000){//内存可见性问题：加volatile关键字
                    this.wait();
                }
                list.set(tail,num);
                tail++;
                if(tail==1000) tail=0;
                this.size++;
                notify();
            }
        }

        public int take() throws InterruptedException {
            synchronized (this) {
                while(size==0){
                    this.wait();
                }
                int ret = list.get(this.head);
                this.head++;
                if(this.head==1000)
                {
                    this.head=0;
                }
                size--;
                notify();
                return ret;
            }

        }

    }
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<10000;i++ ) {
                    System.out.println("生产者生产了"+i);
                    try {
                        queue.put(i);
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
                while (true) {
                    try {
                        Thread.sleep(200);
                        int num = queue.take();
                        System.out.println("消费者消费了"+num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        producer.start();
        customer.start();

    }
}
