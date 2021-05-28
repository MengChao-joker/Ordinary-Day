package May.java_5_24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static boolean judgeCircle(String moves) {
        int a = 0;
        int b = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            switch(c){
                case 'L':a--; break;
                case 'R':a++; break;
                case 'U':b++; break;
                case 'D':b--; break;
            }
        }
        if(a==0&&b==0){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        String s = "UD";
        System.out.println(judgeCircle(s));
    }
    public String destCity(List<List<String>> paths) {
        if(paths==null) return null;
        Map<String,String> map = new HashMap<>();
        for(List<String> list:paths){
            map.put(list.get(0), list.get(1));
        }
        String start = paths.get(0).get(0);
        while(map.get(start)!=null){
            start = map.get(start);
        }
        return start;
    }
    public static int diagonalSum(int[][] mat) {
        if(mat==null) return 0;
        int sum = 0;
        int len = mat[0].length;
        for(int i=0;i<len;i++){
            sum+=mat[i][i];
        }
        int left = 0;
        int right = len-1;
        for(int i=0;i<len;i++){
            if(left!=right){
                sum += mat[left++][right--];
            }else {
                left++;
                right--;
            }
        }
        return sum;
    }

    public static void main1(String[] args) {
        int[][] nums = new int[3][3];
        int flag = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = flag++;
            }
        }
        System.out.println(diagonalSum(nums));

    }
}
