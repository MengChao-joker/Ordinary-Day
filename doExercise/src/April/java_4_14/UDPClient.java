package April.java_4_14;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    //端口号
    private static final int port = 9005;
    //本地IP
    private static final String ip = "127.0.0.2";
    //接受容器的大小
    private static final int blong = 1024;
    public static void main(String[] args) throws IOException {
        //创建一个连接
        DatagramSocket socket =new DatagramSocket();
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print("->");
            String msg = s.nextLine();
            DatagramPacket packet = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            socket.send(packet);

            DatagramPacket resPocket = new DatagramPacket(
                    new byte[blong],
                    blong
            );
            socket.receive(resPocket);

            String serMsg = new String(resPocket.getData());

            System.out.println("服务器的响应为:"+serMsg);
        }

    }
}
