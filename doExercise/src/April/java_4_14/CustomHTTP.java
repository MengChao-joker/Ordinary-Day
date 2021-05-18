package April.java_4_14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomHTTP {
    private static final int port = 9004;
    public static void main(String[] args) throws IOException {
        //创建一个服务器

        ServerSocket serverSocket = new ServerSocket(port);


        //2等待客户端的连接
        Socket socket = serverSocket.accept();

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))
        ) {
            while (true) {
                String firstLine = bufferedReader.readLine();
                if (firstLine != null && !firstLine.equals("")) {
                    String[] fLine = firstLine.split(" ");
                    // 请求类型
                    String method = fLine[0];
                    //url
                    String url = fLine[1];
                    //Http版本号
                    String httpVer = fLine[2];
                    System.out.println(String.format("方法类型：%s，url：%s，版本号：%s",
                            method,url,httpVer));
                    //业务处理：响应信息给前端
                    String content = "<h1>未知</h1>";
                    if(url.contains("404")){
                        content = "<h1>没有找到此页面！</h1>";
                    }else if(url.contains("200")){
                        content = "<h1>你好，世界~~</h1>";
                    }

                    //首行信息
                    bufferedWriter.write(httpVer+" 200 ok\n");

                    bufferedWriter.write("content-type: text/html;charset=utf-8\n");
                    bufferedWriter.write("Content-length: "+ content.getBytes().length+"\n");

                    bufferedWriter.write(("\n"));
                    bufferedWriter.write(content);
                    bufferedWriter.flush();

                }

            }
        }
    }
}
