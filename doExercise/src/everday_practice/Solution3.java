package everday_practice;

import java.util.*;
import java.lang.*;

public class Solution3 {
        public static void main(String[] args){
            Scanner scanner =new Scanner(System.in);
            while(scanner.hasNext()){
                int n=scanner.nextInt();
                int a=0;

                for(int i=2;i<=n/2;i++){
                    if(SuShu(i)){
                        if(SuShu(n-i)){
                            a=i;
                        }
                    }
                }
                System.out.println(a);
                System.out.println(n-a);
            }
        }
        //判断质数的方法
        public static boolean SuShu(int n){
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
}
