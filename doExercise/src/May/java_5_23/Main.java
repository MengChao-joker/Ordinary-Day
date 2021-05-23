package May.java_5_23;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                //run()方法是线程开始工作后所要完成的任务代码块，在start方法后才能执行
                System.out.println("线程开始工作中");
            }
        };
        System.out.println("start()前："+thread.getState());
        thread.start();
        //start()方法后，线程从NEW态-》RUNNABLE态
        System.out.println("start()后："+thread.getState());
    }
}
