package June.java_6_6;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


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
