package java_4_25;

public class ThreadDemo4 {

    public static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        //线程的终止：设立标记位，等run()方法执行完毕（比较温和）
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(!isQuit){
                    System.out.println("别烦我，我在思考人生！");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("思考被打断~~");
            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.join();//主线程等待，标记位不会改变，
        isQuit=true;
    }
}
