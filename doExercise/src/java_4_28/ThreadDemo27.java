package java_4_28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo27 {
    private static Object object = new Object();
    //Thread pool
    /*
    一个任务描述Runnable 和 组织任务的数据结构BlockingQueue<Runnable> queue  new LinkedBlockingQueue<>()
    一个工作线程类 和 组织工作线程的数据结构list
     */

    static class Worker extends Thread{
        private int id = 0;//当前线程id

        BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue,int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while(!Thread.currentThread().isInterrupted()) {
                    Runnable command = queue.take();
                    synchronized (object) {//保证原子性：
                        System.out.print("Thread"+id+"在执行:");
                        command.run();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread"+id+"被终止~");
            }

        }
    }

    static class ThreadPool{
        //组织任务的队列
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        //组织工作线程的list
        List<Worker> workers = new ArrayList<>();

        private static final int maxCountWorker =10;//线程池中的线程数目


        public void execute(Runnable command) throws InterruptedException {
            //创建任务
            if(workers.size()<maxCountWorker){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        public void shutdown() throws InterruptedException {
            //销毁所有线程
            for (Worker worker:workers) {
                worker.interrupt();
            }

            for (Worker worker:workers) {
                worker.join();
            }
        }


    }
    static class Command implements Runnable {
        private int num = 0;
        public Command(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println("任务"+num);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Command(i));
        }

        Thread.sleep(2000);

        pool.shutdown();

    }


}
