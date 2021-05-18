package java_5_8;


import java.util.*;

public class Main {
        public static void main(String[] args){
            Scanner s = new Scanner(System.in);
            while(s.hasNext()){
                String tp = s.nextLine();
                String normal = s.nextLine();
                char[] characters = normal.toCharArray();
                String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                };
                Set<Character> set = new HashSet<>();
                for (String s2:strings
                     ) {
                    set.add(s2.charAt(0));
                }
                int i = 0;
                int j = 0;
                int flag = 0;
                while(i<tp.length()&&j<normal.length()){
                    char c1 = tp.charAt(i);
                    char c2 = tp.charAt(j);
                    if(c1 == c2){
                        i++;
                        j++;
                    }else if(c1=='*')
                    {
                        if(set.contains(c2)){
                            j++;
                        }else {
                            i++;
                        }
                    }else if(c1=='?'){
                        i++;
                        j++;
                    }else {
                        flag = 1;
                        System.out.println(false);
                        break;
                    }
                }
                if(flag==0&&j==normal.length()){
                    System.out.println(true);
                }else {
                    System.out.println(false);
                }
            }
        }
}
