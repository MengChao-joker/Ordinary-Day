package java_4_29;

public class MyQueueByArray {

    private int[] data = new int[10];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void offer(int value){
        if(size==data.length){
            throw new RuntimeException("队列已满~");
        }
        data[tail] = value;
        tail++;
        size++;
        if(tail>=data.length){
            tail=0;
        }
    }
    public int poll(){
        if(size==0){
            throw new RuntimeException("队里为空~");
        }
        int ret = data[head++];
        if(head>=data.length) head = 0;
        size--;
        return ret;
    }

    public int peek(){
        if(size==0){
            throw new RuntimeException("队里为空~");
        }
        return data[head];
    }

}
