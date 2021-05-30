package everday_practice;

import java.util.Arrays;

public class Solution {
    static int[] dx = {1, 0, -1, 0};//一个点的上下左右
    static int[] dy = {0, 1, 0, -1};

    //商品折扣后的最终价格
    public static int islandPerimeter(int[][] grid) {
        //1格子每紧邻一个1格子，它的权值减一，初始为4；
        int m = grid.length, n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x == m || y < 0 || y == n || grid[x][y] == 0) {
                            cnt++;
                        }
                    }
                    ret += cnt;
                }
            }
        }
        return ret;

    }

    //商品折扣后的最终价格

    /**
     * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
     * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
     * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     * @param prices
     * @return
     */
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int old = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]<=old){
                    prices[i] = old-prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main1(String[] args) {
        int[] arr = {8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(arr)));

    }


    //判断能否形成等差数列

    /**
     * 给你一个数字数组 arr 。
     *
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     *
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     * @param 需要判断的一组数据
     * @return
     */
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(searchInsert(arr,1));
        System.out.println(canMakeArithmeticProgression(arr));
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<3) return true;
        Arrays.sort(arr);
        int gap = arr[1]-arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i]!=gap){
                return false;
            }
        }
        return true;
    }

    public static int searchInsert1(int[] nums, int target) {
        int i = 0;
        int len = nums.length;
        for (; i < len; i++) {
            if(nums[i]>=target) break;
        }
        return i;


    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;//数组长度
        int l = 0;//左边界
        int r = len-1;//右边界
        int pos = len;//保证target需要查到len位置
        while(l<=r){
            //二分查找：查询第一个大于等于target的值
            int mid = (r-l)/2+l;
            if(target<=nums[mid]){//target在mid+1之前
                pos=mid;
                r = mid-1;
            }else {//target在mid之后
                l = mid+1;
            }
        }
        return pos;

    }
}
