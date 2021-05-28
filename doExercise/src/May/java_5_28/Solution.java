package May.java_5_28;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[][] A = new int[3][3];

        A[0]= new int[]{1, 1, 1};
        A[1]= new int[]{1, 1, 1};
        A[2]= new int[]{1, 1, 1};
        A = flipAndInvertImage(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }

//        String s = "RLRRLLRLRL";
//        System.out.println(balancedStringSplit(s));
    }

    //打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n)-1;
        int[] ret = new int[max];
        for(int i=0;i<max;i++){
            ret[i] = i+1;
        }
        return ret;

    }

    //最高海拔
    public int largestAltitude(int[] gain) {
        int highest = 0;
        for(int num:gain){
            highest+=num;
        }
        if(highest>0){
            return highest;
        }else {
            return 0;
        }
    }

    /**
     * 输入：[[1,1,0],[1,0,1],[0,0,0]]
     * 输出：[[1,0,0],[0,1,0],[1,1,1]]
     * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            reverseArr(arr);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==0){
                    A[i][j] = 1;
                }else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    private static void reverseArr(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    /**
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     *
     * @param
     * @return
     */
    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int ret = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            int help = 1;
            char pos = stack.pop();
            if (pos == 'L') {
                while (!stack.isEmpty()) {
                    if (stack.pop() == 'R') {
                        help--;
                    }else{
                        help++;
                    }
                    if(help==0){
                        flag = 1;
                        break;
                    }
                }
            } else {
                while (!stack.isEmpty()) {
                    if (stack.pop() == 'L') {
                        help--;
                    }else {
                        help++;
                    }
                    if(help==0){
                        flag = 1;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()||flag==1) {
                ret++;
            }
        }
        return ret;

    }
}
