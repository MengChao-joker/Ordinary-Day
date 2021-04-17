package java_4_15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomHTTP {
    private static final int port = 9009;

    public static void main(String[] args) throws IOException {
        //创建服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("创建服务器成功~~");
        //获取客户端信息
        Socket socket = serverSocket.accept();
        //处理业务逻辑
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            )
        ){
            //获取首航信息CONNECT hectorstatic.baidu.com:443 HTTP/1.1
            String msg = reader.readLine();
            String status = "400 未知\n";
            String[] fLine = msg.split(" ");
            String method = fLine[0];
            String url = fLine[1];
            String version = fLine[2];
            System.out.println(String.format("客户端的首行信息:请求方法：%s，url：%s，版本号：%s",
                    method,url,version));
            String content = "<H1>未知~~</H1>";
            if(url.contains("200")){
                content = "<H1>你好，世界~~</H1>";
                status = "200 ok\n";
            }
            if(url.contains("404")){
                content = "<H1>没有找到此页面~~</H1>";
                status = "404 not found\n";
            }
            writer.write(version+" "+status);
            writer.write("content-type: text/html;charset=utf-8\n");
            writer.write("Content-length: "+content.getBytes().length+"\n");
            writer.write(("\n"));
            writer.write(content);
            writer.flush();






        }
    }

}
