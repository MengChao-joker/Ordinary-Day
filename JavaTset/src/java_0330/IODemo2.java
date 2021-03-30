package java_0330;

import java.io.*;

public class IODemo2 {
    //复制操作
    public static void main(String[] args) throws IOException {
        copyFile("D:/test_dir/test.jpg","d:/test_dir/new1.jpg");
//        File file = new File("D:/test_dir/new1.txt");
//        file.delete();

    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        //先打开文件
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //读取srcpath的文件
        byte[] bytes = new byte[1024];
        int len = -1;
        while((len=fileInputStream.read(bytes))!=-1) {
            /* 写入复制内容 */
            fileOutputStream.write(bytes,0,len);
        }

        //关闭文件

    }
}
