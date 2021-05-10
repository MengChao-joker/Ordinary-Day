package java_5_6;

public class ThreadDemo5 {

    static class Counter{
        private int a = 0;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public synchronized void increase() throws InterruptedException {
            a++;
            Thread.sleep(5000);
        }
        public synchronized void discrease() throws InterruptedException {
            a--;
            Thread.sleep(5000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true) {
                    try {
                        counter.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("加了1，休息会");
                }
            }
        };
        thread.start();

        while (true){
            counter.increase();
            System.out.println("减了1，休息会");
        }

    }

}
