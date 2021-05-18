package April.java_4_14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerByCN {
    //端口号
    public static final int port = 9003;

    public static void main(String[] args) throws IOException {
        //创建一个服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("英译汉服务器启动成功！");
        //登陆服务器的链接
        Socket client = serverSocket.accept();
        System.out.println(String.format("有客户端连接了，客户端ip：%s，客户端端口号：%d",
                client.getInetAddress().getHostAddress(), client.getPort()));
            //try_resource
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream()));
                 BufferedReader bufferedReader = new BufferedReader(
                         new InputStreamReader(client.getInputStream()))
            ) {
                while (true) {
                String msg = bufferedReader.readLine();
                if (msg != null && !msg.equals("")) {
                    System.out.println("客户端的信息是：" + processData(msg));
                }

                bufferedWriter.write("我收到了！" + "\n");
                bufferedWriter.flush();
            }
        }
    }


    private static String processData(String en) {
        //todo:调用数据库，更新更多信息
        String cn = "未知！";
        switch (en) {
            case "cat":
                cn = "猫";
                break;
            case "dog":
                cn = "狗";
                break;
            case "bird":
                cn = "鸟";
                break;
            case "hello":
                cn = "你好";
                break;
//            case "cat":cn= "猫";
//            case "cat":cn= "猫";
//            case "cat":cn= "猫";

        }
        return cn;
    }

}
