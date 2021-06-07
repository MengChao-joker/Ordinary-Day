package June.java_6_7;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
        int[] n = {};
        for (int num : n) {
            System.out.println(num);
        }
    }

    //27. 移除元素
    public static int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r - 1];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    //167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                ret[0] = l + 1;
                ret[1] = r + 1;
                return ret;
            }
        }
        return ret;
        // for(int i = 0;i<numbers.length;i++){
        //     for(int j = i+1;j<numbers.length;j++){
        //         if(numbers[i]+numbers[j]==target){
        //             ret[0] = i+1;
        //             ret[1] = j+1;
        //             return ret;
        //         }
        //     }
        // }
        // return ret;
    }


    /*//559. N 叉树的最大深度
    // //广度优先DFS
    // public int maxDepth(Node root) {
    //     if(root==null) return 0;//判空
    //     Queue<Node> queue = new LinkedList<>();
    //     queue.offer(root);
    //     int depth = 0;
    //     while(!queue.isEmpty()){
    //         depth++;//每层只要有节点就加一
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             Node cur = queue.poll();
    //             for (Node child:cur.children){
    //                 queue.offer(child);
    //             }
    //         }
    //     }
    //     return depth;
    // }
    //深度优先DFS
    public int maxDepth(Node root) {
        if(root==null) return 0;//判空
        // if(root.children.isEmpty()){
        //     return 1;//终止条件
        // }
        int ret = 1;
        for(Node cur:root.children){
            ret = Math.max(ret,maxDepth(cur)+1);
        }
        return ret;
    }*/
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ret = 0;
        for (int n1 : arr1) {
            int len = arr2.length - 1;
            while (len >= 0) {
                if (Math.abs(n1 - arr2[len]) <= d) {
                    break;
                }
                len--;
            }
            if (len == -1) ret++;
        }
        return ret;
    }

    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        int ret = 0;
        for (int n1 : arr1) {
            int pos = 0;
            for (int n2 : arr2) {
                if (Math.abs(n1 - n2) <= d) {
                    pos = 1;
                    break;
                }
            }
            if (pos == 0) ret++;
        }
        return ret;
    }
}

