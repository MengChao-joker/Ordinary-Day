class Solution2 {
    //双循环时间复杂都过高！！
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;
    }

    // //使用Set集合的add方法，筛选出唯一重复的数字；
    // public int findDuplicate(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     int num = 0;
    //     for(int i=0;i<nums.length;i++){
    //         num = nums[i];
    //         if(!set.add(num)){
    //             break;
    //         }
    //     }
    //     return num;
    // }
}