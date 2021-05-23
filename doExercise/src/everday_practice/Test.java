package everday_practice;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String s = "asad";
        System.out.println(s.replace(s.charAt(1), s.charAt(2)));
        System.out.println(s);
    }
    public static void main3(String[] args) {
       /* public synchronized void addElement(E obj) {
            modCount++;
            ensureCapacityHelper(elementCount + 1);//保证容量充足
            elementData[elementCount++] = obj;
        }

        private void ensureCapacityHelper(int minCapacity) {
            // overflow-conscious code
            if (minCapacity - elementData.length > 0)//判断师傅需要扩容
                grow(minCapacity);
        }

        private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

        private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                    capacityIncrement : oldCapacity);//capacityIncrement不大于零就二倍扩容，
                                                              否则扩容capacityIncrement大小
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)//超过MAX_ARRAY_SIZE,再次扩容为Integer最大
                newCapacity = hugeCapacity(minCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        private static int hugeCapacity(int minCapacity) {
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return (minCapacity > MAX_ARRAY_SIZE) ?//Integer扩容为最大值
                    Integer.MAX_VALUE :
                    MAX_ARRAY_SIZE;
        }*/

        Stack<Integer> stack = new Stack<>();//数组实现：二倍扩容 最大Integer_Max_VALUE
        Queue<String> queue = new LinkedList<>();//linkedList：链表实现
        Queue<Integer> queue1 = new PriorityQueue<>();//数组
    }

    public static void main2(String[] args) {
        System.out.println(Math.round(2.50002));//小数点后一位四舍五入
        System.out.println(Math.round(-2.5005));
        double d = Math.pow(2,1022);
        System.out.println(d);
    }
    public static void main1(String[] args) {
        System.out.printf("%05d",12);//输出五位数字（不足左边以0补全）
        System.out.println();
        System.out.printf("%055d",12);//输出55位数字（不足左边以0补全）
    }
}
