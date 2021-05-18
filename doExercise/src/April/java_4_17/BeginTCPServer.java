package April.java_4_17;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BeginTCPServer {
    public static final int port = 9001;
    public static final String ip = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);


        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        )){

            for (int i = 0;i<10;i++) {
                writer.write("你好~"+"\n");
                writer.flush();
            }
        }
    }
}
