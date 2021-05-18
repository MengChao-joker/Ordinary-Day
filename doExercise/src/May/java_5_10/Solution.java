package java_5_10;

public class Solution {
    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     * @param s
     * @return
     */
    public static void main(String[] args) {
        System.out.println(countSubstrings("aba"));
    }
    public static int countSubstrings(String s) {
        int ret = s.length();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j+i <= s.length(); j++) {
                ret += isHW(s.substring(j,j+2))?1:0;
            }
        }
        return ret;

    }
    private static boolean isHW(String substring) {
        int left = 0;
        int right = substring.length()-1;
        while(left<right){
            if(substring.charAt(left)==substring.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
