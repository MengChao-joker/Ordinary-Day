package java_4_28;

import javafx.concurrent.Worker;

import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo26 {
    //定时器：
    /*
    工作扫描线程
    任务类
    优先阻塞队列
    定时器类
     */

    static class Task implements Comparable<Task>{

        private Runnable command = null;
        private long time = 0;


        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }

        public void run(){
            this.command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time-o.time);
        }
    }

    static class Worker extends Thread{

        Object object = new Object();

        private PriorityBlockingQueue<Task> queue = null;

        public Worker(PriorityBlockingQueue<Task> queue) {
            this.queue = queue;
            this.start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {//wait早在锁代码块内
                        Task task = queue.take();
                        if(task.time>System.currentTimeMillis()){
                            queue.put(task);
                            object.wait(task.time-System.currentTimeMillis());
                        }else {
                            task.run();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }

        }

    }

    static class Timer{
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        public Timer() {
            Worker worker = new Worker(queue);
        }

        public void schedule(Runnable command, long after){
                Task task = new Task(command,after);
                queue.put(task);
        }

    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时器实现了~");
                timer.schedule(this,2000);
            }
        },2000);

    }
}
