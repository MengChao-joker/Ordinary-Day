package April.java_4_14;

import java.net.DatagramPacket;
import java.net.UnknownHostException;

public class TestDemo {
    private static final int port = 9001;
    private static final String ip = "127.0.0.1";

    public static void main(String[] args) {
        char[] a = {'s'};
        int[] nums = new int[10];
        char[] b = new char[2];
//        System.out.println(a+b==a+b);
//        String s = new String(" ");
        System.arraycopy(a,0,b,1,1);
        System.out.println(b[0]);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }
    public static void main2(String[] args) throws UnknownHostException {
        String s = new String(" ");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        DatagramPacket packet = new DatagramPacket(
                new byte[1024],
                1024
        );
        System.out.println(packet.getAddress());
    }
    public static void main1(String[] args) {
        /*//字符码ascii 比较大小
        String s = "asdf";
        System.out.println(s.charAt(0)>97);*/

        /*//引用的赋值：该引用指向了新的对象
        StringBuilder res = new StringBuilder();
        StringBuilder tem = new StringBuilder();
        res = tem;
        res.append(1);
        System.out.println(tem.toString());*/

        /*//Map:getDefault方法：获取value或没有则设置默认值
        Map<Integer,Integer> map = new HashMap<>();
        int count = map.getOrDefault(1,5)+1;
        map.put(1,count);
        System.out.println(map.getOrDefault(1, 0)+1);*/
    }
}
