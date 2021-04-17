package java_4_17;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BeginTCP {
    public static final int port = 9001;

    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(port);

        Socket clientSocket = serverSocket.accept();

//        byte[] bytes = new byte[1024];
//
//        try(InputStream inputStream = clientSocket.getInputStream()){
//
//            int res = inputStream.read(bytes,0,bytes.length);
//            if(res>0){
//                clientSocket.getInputStream().;
//            }
//        }
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        )) {
            while (true) {
                if(reader.readLine()!=null&&!reader.readLine().equals("")) {
                    System.out.println(reader.readLine());
                }
            }
        }


    }



}
