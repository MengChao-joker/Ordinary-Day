package java_4_25;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreadDemo6 {
    public static void main(String[] args) {
        //获取线程状态
        for (Thread.State state:Thread.State.values()
             ) {
            System.out.println(state);
        }
        System.out.println(Arrays.toString(Thread.State.values()));
    }
}
