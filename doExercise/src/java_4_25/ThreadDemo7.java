package java_4_25;

public class ThreadDemo7 {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().isInterrupted());//当前实例的终止状态
                    System.out.println(Thread.interrupted());//Thread中静态方法，调用完后清除标记为位false;
                }
            }
        };
        thread.start();
        thread.interrupt();
    }
}
