package java2021_4_14;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    //端口号
    public static final int port = 9003;
    public static final String ip = "127.0.0.1";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //创建tcp客户端
        Socket socket =  new Socket(ip,port);

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            )
        ){
            while(true){
                System.out.println("->");
                String msg = scanner.nextLine();

                writer.write(msg+"\n");
                writer.flush();
                System.out.println(reader.readLine());
            }



        }




    }
}
