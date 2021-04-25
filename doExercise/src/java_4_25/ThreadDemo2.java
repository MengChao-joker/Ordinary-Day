package java_4_25;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread("mby"){
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while(true){}
        }
    };
    thread.start();
    }
}
