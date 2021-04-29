package java_4_28;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("消愁","毛不易");
        map.put("狐狸","薛之谦");
        map.put("老街","李荣浩");
        System.out.println(map.get("aa"));
        System.out.println(map.getOrDefault("兰亭序","周杰伦"));
        System.out.println(map);
        for (Map.Entry e : map.entrySet()
             )
            System.out.println(e);
        map.clear();
        System.out.println(map);

    }

    public static void main2 (String[] args) {
        int a = 1;
        float f = a;
        double d = a;
        a = (int)f+1;
        System.out.println(a+0.1);
        System.out.println(f);
        System.out.println(d);
//        int[] left = new int[]{0,7,1,6};
//        int[] right = {1,5,0,6};
//        int n = 4;
//        System.out.println(findMinimum(4,left,right));

    }
    public static int findMinimum1(int n, int[] left, int[] right) {

        int max1 = 0,max2 = 0;
        int min1 = 27,min2 = 27;//总手套数
        int i;
        for(i=0;i<n;i++){
            if(left[i] == 0){
                max1 = max1+right[i];
            }
            else{
                max1 = max1+left[i];
            }
            if(right[i] == 0){
                max2 = max2+left[i];
            }
            else{
                max2 = max2+right[i];
            }
            if(left[i]!=0 && right[i]!=0 && left[i]<min1){
                min1 = left[i];
            }
            if(right[i]!=0 && left[i]!=0 && right[i]<min2){
                min2 = right[i];
            }
        }
        max1 = max1-min1+2;
        max2 = max2-min2+2;
        return (max1<max2)?max1:max2;
    }

    public static int findMinimum(int n, int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < left.length; i++) {
            set.add(left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            set.add(right[i]);
        }
        return set.size()+1;
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println(findNumberOf1(num));
        }
    }
    private static int findNumberOf1(int num) {
        int ret = 0;
        while(num!=0){
            if(num%2==1) ret++;
            num/=2;
        }
        return ret;
    }
}
