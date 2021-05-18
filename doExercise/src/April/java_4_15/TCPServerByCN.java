package April.java_4_15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerByCN {
    private static  final  int port = 9001;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("英译汉服务器已启动~~");
        Socket socket = serverSocket.accept();
        System.out.println(String.format("当前连接的客户端ip为：%s，端口号为：%d",
                socket.getInetAddress().getHostAddress(),socket.getPort()));
        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            )){
            while(true){
                String msg = reader.readLine();
                System.out.println("客户端的请求为："+msg);
                String resMsg = tl(msg);

                writer.write(resMsg+"\n");
                writer.flush();
            }

        }

    }

    private static String tl(String msg) {
        String res = "未知~~";

        switch(msg){
            case "dog":
                res = "狗~~";
                break;
            case "cat":
                res = "猫~~";
                break;
                case "bird":
                res = "鸟~~";
                break;
                case "tree":
                res = "树~~";
                break;
                case "flower":
                res = "花儿~~";
                break;
        }
        return res;
    }

}

