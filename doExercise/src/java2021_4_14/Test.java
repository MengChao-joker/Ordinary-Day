package java2021_4_14;

import java.util.*;

public class Test {
    public static int getMid(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            boolean pos = true;
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    int tem = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] =tem;
                    pos = false;
                }
            }
            if(pos){
                break;
            }
        }
        return nums[nums.length/2];
    }
    public static int find(int[] nums){
        //数组中出现次数超过数组长度一半的数字
        int mid = getMid(nums);
        int tem = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==mid){
                tem++;
            }
        }
        if(tem>nums.length/2){
            return mid;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        //数组中出现次数超过数组长度一半的数字

        int[] nums = {1,3,4,1,2,1,1};
        System.out.println(find(nums));
    }
    public static void main1(String[] args) {
        //字符串中找出连续最长字串
        StringBuilder res = new StringBuilder();
        String max = "";
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str = s.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>=48&&str.charAt(i)<=57){
                    res.append(str.charAt(i));
                }else {
                    res.delete(0,res.length());
                }
                max = res.length()>max.length()?res.toString():max;
            }
            System.out.println(max);
        }
    }
}
