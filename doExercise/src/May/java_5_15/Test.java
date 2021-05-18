package java_5_15;

import sun.applet.AppletClassLoader;
import sun.plugin2.applet.Applet2ClassLoader;

import java.net.URL;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class MyClassLoader extends AppletClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);

    }

    protected MyClassLoader(URL url) {
        super(url);
    }
}
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            int[][] helper = new int[s1.length()][s2.length()];
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    if(s1.charAt(i) == s2.charAt(j)){
                        if(i==0||j==0){
                            helper[i][j] = 1;
                        }else{
                            helper[i][j] = helper[i-1][j-1]+1;
                        }
                    }
                }
            }
            int maxLen = 0;
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    maxLen = Math.max(maxLen,helper[i][j]);
                }
            }
            System.out.println(maxLen);
        }
    }
    public static void main3(String[] args) {
        String s = "456";
        System.out.println(s.intern());
    }


    public static void main2(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String input = s.nextLine();
            Stack<Character> stack = new Stack<>();
            for (Character c:input.toCharArray()){
                stack.push(c);
            }
            StringBuilder ret = new StringBuilder();
            while (!stack.isEmpty()){
                ret.append(stack.pop());
            }
            System.out.println(ret.toString());
        }
    }
    public static void main1(String[] args) {
        System.out.println(new MyClassLoader(null).getParent());
        System.out.println(new MyClassLoader(null).getParent().getParent());
        System.out.println(new MyClassLoader(null).getParent().getParent().getParent());

    }
}
