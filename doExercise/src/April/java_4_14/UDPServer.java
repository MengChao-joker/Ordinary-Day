package April.java_4_14;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UDPServer {
    //端口号
    private static final int port = 9005;
    //接受容器的大小
    private static final int blong = 1024;

    public static void main(String[] args) throws IOException {
        //创建一个连接
        DatagramSocket socket = new DatagramSocket(port);
        Scanner s = new Scanner(System.in);
        while(true) {
            DatagramPacket packet = new DatagramPacket(
                    new byte[blong],
                    blong
            );
            socket.receive(packet);
            System.out.println("客户端发送的消息是：" + new String(packet.getData()));

            //返回一个响应给客户端
            String msg = new String(packet.getData()).replace("你","我").replace("吗？","。");
            DatagramPacket resPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    packet.getAddress(),
                    packet.getPort()
            );
            socket.send(resPacket);
        }
    }
}
