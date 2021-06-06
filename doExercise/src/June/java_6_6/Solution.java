package June.java_6_6;

import java.util.*;


class CQueue {
    Stack<Integer> A = null;
    Stack<Integer> B = null;


    public CQueue() {
        this.A = new Stack<>();
        this.B = new Stack<>();
    }

    public void appendTail(int value) {
        A.push(value);

    }

    public int deleteHead() {
        if(B.isEmpty()){
            while (!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.pop();
    }
}
public class Solution {
    //1030. 距离顺序排列矩阵单元格
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*C+j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = dist(arr1[0], arr1[1], r0, c0);
            int d2 = dist(arr2[0], arr2[1], r0, c0);
            return Integer.compare(d1, d2);
        });

        return re;
    }

    private int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    //1732. 找到最高海拔
    public int largestAltitude(int[] gain) {
        int ret = 0;
        int temp = 0;
        for(int cur:gain){
            temp+=cur;
            ret = Math.max(ret,temp);
        }
        return ret;
    }

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c:chars){
            if(!set.add(c)){
                return false;
            }
        }
        return true;

    }

}
