package java_5_6;

public class ThreadDemo4 {
    private static final long count = 100_0000_0000L;

    public static void main(String[] args) throws InterruptedException {
        System.out.print("多线程执行时间：");
        currency();
        System.out.print("串行化执行时间：");
        serial();
    }

    private static void serial() {
        long beg = System.currentTimeMillis();
        long a = 0;
        long b= 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beg);

    }

    private static void currency() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread thread = new Thread(){
            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        thread.join();
        thread.start();

        long end = System.currentTimeMillis();
        System.out.println(end - beg);

    }
}
