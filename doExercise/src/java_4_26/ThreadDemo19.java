package java_4_26;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo19 {
    //定时器实现
    /*1.Timer定时器类
    2.Task类描述一个任务
    3.一个阻塞优先队列来组织任务
    4.一个Worker工作扫描线程
    5.一个schedule方法安排任务
    */

    static class Task implements Comparable<Task>{
        //2.一个任务类
        //Runnable中有一个run()方法，借助这个方法来指派任务
        private Runnable command;
        //time表示一个绝对时间，任务开始时间距离当下时间time
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }
        public void run(){
            this.command.run();
        }
        @Override
        public int compareTo(Task o) {
            //时间小的先执行
            return (int) (this.time-o.time);
        }
    }
    static class Worker extends Thread{
        Object object = new Object();
        //将任务组传入工作线程
        private PriorityBlockingQueue<Task> queue = null;

        public Worker(PriorityBlockingQueue<Task> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //扫描任务组
            while(true){
                synchronized (object) {
                    try {
                        //取出优先级最高的任务
                        Task task = queue.take();
                        if(task.time>System.currentTimeMillis()){
                            //当前时间还没到，等待到任务时间，或被notify唤醒
                            queue.put(task);
                            object.wait(task.time-System.currentTimeMillis());
                        }else {
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }

        }
    }

    static class Timer{
        //一个优先级队列:任务组
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //构造方法中构造一个工作线程并启动
        public Timer() {
            Worker worker = new Worker(queue);
            worker.start();
        }

        //安排任务的方法
        public void schedule(Runnable command,long after){
            queue.put(new Task(command,after));
        }


    }


    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时器实现了~~");
                timer.schedule(this,2000);
            }
        },2000);



    }
}
