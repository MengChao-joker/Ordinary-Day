package java_4_13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP 服务器
 */

public class UDPServer {
    //服务器端口号
    private static final int port = 9001;
    //接受数据容器的大小
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //创建一个UDP服务器
        DatagramSocket socket = new DatagramSocket(port);
        while(true) {

            //客户端数据包
            DatagramPacket clientPocket = new DatagramPacket(
                    new byte[bleng],bleng
            );
            //接受客户端数据
            socket.receive(clientPocket);
            //取出数据包中消息
            String msg = new String(clientPocket.getData());
            System.out.println("服务器端收到的消息是："+msg);

            //给客户返回一个消息msg.replace("你","我").replace("吗？","。");
            String reMsg = msg.replace("你","我").replace("吗？","。");
            //服务器响应包
            DatagramPacket resPocket = new DatagramPacket(
                    reMsg.getBytes(),
                    reMsg.getBytes().length,
                    clientPocket.getAddress(),
                    clientPocket.getPort()
            );
            //发送响应
            socket.send(resPocket);
        }
    }
}
