package java_4_26;

import java.sql.Time;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo21 {
    //计时器：
    // Task类
    // queue 优先级队列-》任务组
    // Worker扫描线程
    // Timer类
    // schedule方法安排任务
    static class Task implements Comparable<Task> {
        private Runnable command;
        private long time;

        public Task(Runnable command, long after) {
            //安排任务内容和时间
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        public void run() {
            //执行任务
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            //比较器
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread {
        Object locker = new Object();

        PriorityBlockingQueue<Task> queue = null;

        public Worker(PriorityBlockingQueue<Task> queue) {
            //将工作表给扫描线程
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (locker) {
                    try {
                        Task task = queue.take();
                        if (task.time > System.currentTimeMillis()) {
                            queue.put(task);
                            locker.wait(task.time - System.currentTimeMillis());
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

    static class Timer {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        public Timer() {
            Worker worker = new Worker(queue);
            worker.start();
        }


        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
        }
    }


    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时器实现了~~");
                timer.schedule(this, 2000);
            }
        }, 2000);


    }

}
