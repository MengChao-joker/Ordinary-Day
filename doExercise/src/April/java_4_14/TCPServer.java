package April.java_4_14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    //端口号
    public static final int port = 9002;
    public static void main(String[] args) throws IOException {
        //创建一个服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器启动成功！");
        //登陆服务器的链接
        Socket client = serverSocket.accept();
        System.out.println(String.format("有客户端连接了，客户端ip：%s，客户端端口号：%d",
                client.getInetAddress().getHostAddress(), client.getPort()));
//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            //拿到读取对象
//            bufferedReader = new BufferedReader(
//                    new InputStreamReader(client.getInputStream()));
//            //接收客户端信息
//            String msg = bufferedReader.readLine();
//
//            //回复客户端
//            bufferedWriter = new BufferedWriter(
//                    new OutputStreamWriter(client.getOutputStream()));
//            String serMsg = "我收到了！";
//            bufferedWriter.write(serMsg+"\n");
//            bufferedWriter.flush();
//
//        } finally {
//            if(bufferedReader!=null){
//                bufferedReader.close();
//            }
//            if(bufferedWriter!=null){
//                bufferedWriter.close();
//            }
//        }
        //try_resouce
        while (true) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream()));
                 BufferedReader bufferedReader = new BufferedReader(
                         new InputStreamReader(client.getInputStream()))
            ) {
                String msg = bufferedReader.readLine();
                if (msg != null && msg.equals("")) {
                    System.out.println("客户端的信息是：" + msg);
                }

                bufferedWriter.write("我收到了！" + "\n");
                bufferedWriter.flush();
            }
        }
    }
}
