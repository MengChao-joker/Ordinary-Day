package April.java_4_15;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static final int port = 9001;
    private static final String ip = "127.0.0.88";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //创建一个TCP客户端
        Socket socket = new Socket(ip,port);
            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream()))
            ){
                while(true){
                System.out.println("->");
                String msg = scanner.nextLine();
                writer.write(msg+"\n");
                writer.flush();

                String resMsg = reader.readLine();
                System.out.println(msg+":"+resMsg);
            }
        }


    }





}
