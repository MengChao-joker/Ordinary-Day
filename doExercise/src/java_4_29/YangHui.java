package java_4_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows==0) return ret;
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if(j=1) {
                    list.add(1);
                }else {
                    list.add(ret.get(i - 1).get(j)+ret.get(i-1).get(j-1));
                }
            }
            list.add(1);
            ret.add(list);
        }
        return ret;
    }
}
