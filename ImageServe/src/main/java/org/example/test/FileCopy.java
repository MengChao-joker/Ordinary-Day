package org.example.test;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\image\\dog.png");
        FileOutputStream fos = new FileOutputStream("D://image//test.png");

        byte[] bytes = new byte[1024];
        int len;
        while((len=is.read())!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        is.close();

    }
}
