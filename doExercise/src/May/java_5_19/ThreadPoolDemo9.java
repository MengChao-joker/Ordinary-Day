package May.java_5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo9 {
    static class OOM {
        public byte[] _1MB = new byte[2 * 1024 * 1024];
    }
    //7.异步提交的线程
    public static void main(String[] args) {

        ExecutorService service = Executors.newWorkStealingPool();

        for (int i = 0; i < 1000; i++) {
            int Temp = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Temp);
                    OOM oom = new OOM();
                }
            });
        }
        while(!Thread.interrupted()){

        }


    }


}
