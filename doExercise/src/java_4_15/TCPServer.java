package java_4_15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    //定义端口号
    private static final int port = 9001;

    public static void main(String[] args) throws IOException {
        //创建一个服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动~~");

        //接受客户端数据的数据包
        Socket socket = serverSocket.accept();
        System.out.println(String.format("客户端的端口号为：%d，IP为：%s",
                socket.getPort(),socket.getInetAddress().getHostAddress()));
            try(BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()))
            ){
                while(true){
                String msg = reader.readLine();
                if(msg!=null&&!msg.equals("")) {
                    System.out.println("客户端发送的消息为：" + msg);
                };
                String resMsg = "我收到了~~";
                writer.write(resMsg+"\n");
                writer.flush();
             }

        }


    }


}
