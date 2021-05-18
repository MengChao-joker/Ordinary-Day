package java_4_26;

public class ThreadDemo12 {
//volatile关键字：保证内存可见性
    //解决一个线程读一个线程写的问题：读操作可能被优化，只读一次并将其存储再CPU寄存器上，
    //                          导致写操作完成后，不能读到更新的值
    static class Counter {
        public volatile int flag = 1;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (counter.flag == 1){

                }
                System.out.println("循环结束！");
            }
        };

        thread.start();
        Thread thread1 = new Thread(()->{
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            counter.flag=0;
            System.out.println("flag修改成功！");
        });
        thread1.start();
    }
}
