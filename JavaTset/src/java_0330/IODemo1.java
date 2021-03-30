package java_0330;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/test_dir");
//        System.out.println("文件是否存在："+file.exists());//判断存在
//        System.out.println("文件是否是普通文件"+file.isFile());
//        System.out.println("文件是否是目录"+file.isDirectory());
//        file.mkdirs();
//        File[] files = file.listFiles();
//        for (File f : files) {
//            System.out.println(f);
//        }
        listAllFiles(file);

    }
    public static void listAllFiles(File f){
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for (File file:files) {
                listAllFiles(file);
            }
        }else {
            System.out.println(f);
        }
    }
}
