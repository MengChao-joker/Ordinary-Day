package May.java_5_18;

public class Test {
    /**
     * 对象优先分配在Eden区
     * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M
     * 新生代：  Eden区：8M  s1：1M   s2：1M
     * 老年代：  10M
     */
    private static  final int _1MB = 1024*1024;

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        //触发minorGC
        allocation4 = new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
