package java_0328;

//生产者—消费者模型
public class ThreadDemo9 {
    static class BlockingQueue{
        //基于数组实现BlockingQueue
        private int[] array = new int[100];
        private int head = 0;
        private int tail = 0;
        private volatile int size = 0;
        //入队列操作:生产行为
        public void put(int value) throws InterruptedException {
            synchronized (this) {
                if(size == array.length){
                    wait();
                }
                this.array[tail] = value;
                tail++;
                if(tail==array.length){
                tail = 0;
                }
            size++;
            notify();
            }
        }
        //出队列操作：消费行为
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                if(size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if(head==array.length){
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue();
        Thread producer = new Thread() {//生产者1线程
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        System.out.println("1放入的是"+i);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
//        Thread producer2 = new Thread(){//生产者2线程
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    try {
//                        System.out.println("2放入的是"+i);
//                        queue.put(i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
        Thread consumer = new Thread(){
            @Override
            public void run() {
                try {
                    int ret = queue.take();
                    System.out.println("取出的是"+ret);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//        producer2.start();
        consumer.start();
    }

}
