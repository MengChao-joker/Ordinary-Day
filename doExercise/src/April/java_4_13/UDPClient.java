package April.java_4_13;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
public class UDPClient {
    //服务器IP
    private static final String ip = "127.0.0.1";
    //服务器端口号
    private static final int port = 9001;
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner s = new Scanner(System.in);

        while(true){
            System.out.print("->");
            String msg = s.nextLine();
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            socket.send(datagramPacket);

            DatagramPacket resPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );

            socket.receive(resPacket);

            System.out.println("服务器端的消息是："+new String(resPacket.getData()));



        }
    }
}
