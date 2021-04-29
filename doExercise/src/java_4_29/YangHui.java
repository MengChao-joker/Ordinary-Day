package java_4_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows==0) return ret;

        for (int i = 1; i <= numRows; i++) {
            List<Integer> curCow = new ArrayList<>();
            curCow.add(1);
            for (int j = 2; j < i; j++) {
                curCow.add(ret.get(i-1-1).get(j)+ret.get(i-1-1).get(j-1));
            }
            curCow.add(1);
            ret.add(curCow);
        }
        return ret;
    }
    Queue<Integer> queue = new LinkedList<>();
}
