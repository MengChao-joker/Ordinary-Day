package java_4_24;

public class ThreadDemo {
    private static long count = 1_0000_0000L;
    public static void main(String[] args) throws InterruptedException {
//        serial();
        concurrency();

    }

    private static void concurrency() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                long a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread thread2 = new Thread(()->{
            long b = 0;
            for (int i = 0; i < count; i++) {
                b++;
            }
        });
        thread1.join();
        thread2.join();
        thread1.start();
        thread2.start();
        long end = System.currentTimeMillis();
        System.out.println(end-beg);

    }

    private static void serial() {
        long beg = System.currentTimeMillis();
        long a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }
}
