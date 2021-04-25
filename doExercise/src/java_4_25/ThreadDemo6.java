package java_4_25;

public class ThreadDemo6 {
    public static void main(String[] args) {
        //获取线程状态
        for (Thread.State state:Thread.State.values()
             ) {
            System.out.println(state);

        }
    }
}
