package June.java_6_8;

import java.util.Random;

class Solution {
    public static void main(String[] args) {
        int[] arrs = {0,10};
        System.out.println(smallestRangeI(arrs, 2));
    }
    public static int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int cur:nums){
            max = Math.max(cur,cur-k);
            min = Math.max(cur,cur+k);
        }
        return Math.max(0,max-min-2*k);

    }
}
