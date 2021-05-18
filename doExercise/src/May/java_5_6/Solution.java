package java_5_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < sentence.length();i++){
            set.add(sentence.charAt(i));
        }
//        for(int i = 0;i < 26;i++){
//            char temp = Character.'i';
//            if(!set.contains('a'+){
//                return false;
//            }
//        }
        return true;

    }
        public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for(int i=1;i<s.length();i+=2){
            chars[i] = (char) (chars[i-1]+(chars[i]-'0'));

        }
        return new String(chars);
    }
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);
        System.out.println(a+1);
//        int a = 97;
//        System.out.println(Character.charCount(a));
    }


    public static int arraySign(int[] nums) {
        long temp = 1;
        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
        }
        if (temp == 0) {
            return 0;
        } else if (temp > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main2(String[] args) {
        int[] nums = new int[]{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24};
        System.out.println(arraySign(nums));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int ret = 0;
        for (char stone : stones.toCharArray()
        ) {
            for (char jewel : jewels.toCharArray()
            ) {
                if (jewel == stone) ret++;
            }
        }
        return ret;


//        int ret = 0;
//        Set<Character> set = new HashSet<>();
//        for (char jewel:jewels.toCharArray()
//             ) {
//            set.add(jewel);
//        }
//        for (char stone:stones.toCharArray()
//             ) {
//            if(set.contains(stone)) ret++;
//        }
//        return ret;


    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;

//        int[] ret = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int temp = 0;
//            for (int j = 0; j <= i; j++) {
//                temp += nums[j];
//            }
//            ret[i] = temp;
//        }
//        return ret;
    }


    public static void main1(String[] args) {
//        int[] nums = {1,2,3,4,5,6};
//        System.out.println(Arrays.toString(runningSum(nums)));
        String string = "asdfg";
        //从后往前找
        System.out.println(string.lastIndexOf("fg"));
        //从前往后找
        System.out.println(string.indexOf("fg"));
        char[] chars = {'a', 's'};
        System.out.println(chars);
        String s = new String(chars);
        System.out.println(s);
    }


}
