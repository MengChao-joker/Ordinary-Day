package java_4_26;

public class ThreadDemo13 {
//wait()方法：Object中的方法

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();

        synchronized (o) {
            System.out.println("等待前~");
            o.wait();//释放锁并进入Waiting状态（原子性的操作->解决了竞态条件问题），等待notify通知
            System.out.println("等待后~");
        }

    }
}
