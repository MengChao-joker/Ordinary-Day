package java_5_6;

public class ThreadDemo6 {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread t = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(10);
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                System.out.println(t.getState());
            }
            object.notify();
        }
        t.interrupt();
        while (t.isAlive()) {

            System.out.println(t.getState());
        }
    }
}
