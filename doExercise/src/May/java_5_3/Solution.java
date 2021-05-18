package java_5_3;

import java.util.*;

public class Solution {

    //前K个高频单词
    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * 示例 1：
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     * 示例 2：
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     *     出现次数依次为 4, 3, 2 和 1 次。
     */
    public List<String> topKFrequent(String[] words, int k) {
        //k为字符串 v为出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (String word:words) {
            int count = map.getOrDefault(word,0);
            map.put(word,count+1);
        }
        //存储keySet的元素
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2)){
                    return o1.compareTo(o2);
                }else {
                    int val1 = map.get(o1);
                    int val2 = map.get(o2);
                    return val2-val1;
                }
            }
        });
        return list.subList(0,k);


    }






    //就键盘打字
    /**
     * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
     * 肯定坏掉的那些键。
     *
     * 输入
     * 7_This_is_a_test<br/>_hs_s_a_es
     * 输出
     * 7TI
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String expect = scanner.nextLine().toUpperCase();
            String actual = scanner.nextLine().toUpperCase();
            Set<Character> set = new HashSet<>();
            for (char act:actual.toCharArray()) {
                set.add(act);
            }

            Set<Character> bad = new HashSet<>();
            for (char exp:expect.toCharArray()) {
                if(set.contains(exp)){
                    continue;
                }
                if(bad.contains(exp))continue;
                System.out.print(exp);
                bad.add(exp);
            }
        }
    }


    //宝石与石头
    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头
     * 示例 1:
     * <p>
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        int ret = 0;
        for (char stone:stones.toCharArray()) {
            for (char jewel:jewels.toCharArray()) {
                if(stone==jewel)ret++;
            }
        }
        return ret;



//        Set<Character> set = new HashSet<>();
//        for (char jewel:jewels.toCharArray()) {
//            set.add(jewel);
//        }
//        int ret = 0;
//        for (char stone:stones.toCharArray()) {
//            if(set.contains(stone))ret++;
//        }
//        return ret;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //深拷贝一条带随机指针的链表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node ret = map.get(cur);
            ret.next = map.get(cur.next);
            ret.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //放入键值对第一次value为1   第二次为2...
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        /*//循环取出键值对Entry 判断value为1 则返回key
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if(entry.getValue().equals(1)) {
               return entry.getKey();
            }
        }*/

        //迭代器
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }


}
