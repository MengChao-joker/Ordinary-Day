package java_4_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyStack {
    private int[] data = new int[100];
    private int top = 0;
    private int size = 0;


    public void add(int value) {
        if (data.length == size) {
            throw new RuntimeException("栈已满~");
        }
        data[top] = value;
        top++;
        size++;
    }

    public int get() {
        if (size == 0) {
            throw new RuntimeException("栈为空");
        }
        size--;
        return data[top--];
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("栈为空");
        }
        return data[top];
    }

}
