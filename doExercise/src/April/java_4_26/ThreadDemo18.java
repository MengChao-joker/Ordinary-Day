package java_4_26;

public class ThreadDemo18 {
//阻塞队列：生产者—消费者模型
   /* 1.阻塞队列
    2.消费者线程
    3.生产者线程*/

    static class BlockingQueue {
        //阻塞队列实现 基于数组
        private int[] array = new int[1000];
        //队列的头
        private int head = 0;
        //队列的尾
        private int tail = 0;
        //队列中的数据量:有内存可见性问题
        private volatile int size = 0;

        //入队列操作
        public void put(int value) throws InterruptedException {
            synchronized (this) {
                while (size == 1000) {//判断队列是否为满：while优于if—》若wait被notify唤醒，还可以判断是否再次进入阻塞等待
                    //等待队列中有空缺未知
                    this.wait();
                }
                //插入元素
                this.array[this.tail] = value;
                this.tail++;
                if(tail==array.length) tail = 0;
                this.size++;
                this.notify();
            }

        }

        //出队列操作
        public int take() throws InterruptedException {
            synchronized (this) {
                while (size == 0) {//判断队列是否为空
                    //等待有元素插入
                    this.wait();
                }
                //返回队首元素
                int ret = this.array[this.head];
                this.head++;
                if(head==array.length) head = 0;
                this.size--;
                this.notify();
                return ret;
            }
        }

    }


    public static void main(String[] args) {

        BlockingQueue blockingQueue = new BlockingQueue();

        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        System.out.println("生产者生产了" + i);
                        blockingQueue.put(i);
//                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread customer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int value = blockingQueue.take();
                        System.out.println("消费者消费了" + value);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread customer2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int value = blockingQueue.take();
                        System.out.println("消费者2消费了" + value);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        producer.start();
        customer.start();
        customer2.start();

    }
}
