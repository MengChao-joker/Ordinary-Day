package java_4_25;

public class ThreadDemo5 {
    public  static  int flag = 0;
    public static void main(String[] args) throws InterruptedException {
        //线程终止:interrupt方法 不管线程是否执行完毕 强制终止(比较暴力)
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("别烦我！我在思考人生~~");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        flag = 1;
                        break;//此线程两个时期run()方法和sleep()当sleep()时期被打断是也应该终止线程
                    }
                }
                if(flag==1){
                    System.out.println("异常中断！");
                }else {
                    System.out.println("循环条件中止！");
                }

            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();//终止线程
    }
}
