package java_5_2;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    //直接插入
    public static void insertSort(int[] nums) {
        /**
         * 时间复杂度O(N^2);
         * 空间复杂度O(1);
         * 稳定性：稳定;
         * [o,bound)为已排序区间
         * [bound,size]为待排序区间
         */
        for (int bound = 1; bound < nums.length; bound++) {
            int val = nums[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (nums[cur] > val) {
                    int temp = nums[cur + 1];
                    nums[cur + 1] = nums[cur];
                    nums[cur] = temp;
                } else {
                    break;
                }
            }
            nums[cur + 1] = val;
        }
    }


    //希尔排序（缩小增量）
    public static void shellSort(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 1) {
            insertSort(nums, gap);
            gap /= 2;
        }
        insertSort(nums, gap);
    }

    public static void insertSort(int[] nums, int gap) {
        /**
         * 时间复杂度：O(N^1.3)~O(N^2);
         * 空间复杂度：O(1);
         * 稳定性：不稳定（发生跳着比较交换）
         * 增量len/2 len/4 len/6...1;
         */
        for (int bound = gap; bound < nums.length; bound += gap) {
            int val = nums[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (nums[cur] > val) {
                    int temp = nums[cur + gap];
                    nums[cur + gap] = nums[cur];
                    nums[cur] = temp;
                } else {
                    break;
                }
            }
            nums[cur + gap] = val;
        }
    }


    //选择排序
    public static void selectSort(int[] nums) {
        for (int bound = 0; bound < nums.length; bound++) {
            int cur = bound + 1;
            for (; cur < nums.length; cur++) {
                if (nums[cur] < nums[bound]) {
                    int temp = nums[cur];
                    nums[cur] = nums[bound];
                    nums[bound] = temp;
                }
            }
        }
    }


    //堆排序
    public static void heapSort(int[] nums) {
        /**
         * 升序：建立一个大堆，循环len-1次，每次将堆顶元素与末尾元素互换
         * 并从堆中除去末尾元素，在向下调整
         */
        createHeap(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            //将堆顶元素与末尾元素交换
            swap(nums, 0, nums.length - 1 - i);
            //待排序区间：[0,nums.length-i-1)
            //已排序区间：[num.length-i-1,nums.length)
            //待排序区间向下调整
            shiftDown(nums, nums.length - (i + 1), 0);//nums-(i+1):减去交换的次数i+1，因为i从0开始~~
        }
    }
    private static void createHeap(int[] nums) {
        //建堆
        for (int i = (nums.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(nums, nums.length, i);
        }
    }
    private static void shiftDown(int[] nums, int size, int index) {
        //向下调整
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && nums[child + 1] > nums[child]) {
                child = child + 1;
            }
            if (nums[child] > nums[parent]) {
                swap(nums, child, parent);
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    //冒泡排序
    public static void bubbleSort(int[] nums){
        int len = nums.length;
//        for (int i = 0; i < len-1; i++) {
//            int flag = 0;
//            for (int j = 1; j < len-i; j++) {
//                if(nums[j-1]>nums[j]){
//                    flag = 1;
//                    swap(nums,j-1,j);
//                }
//            }
//            if(flag==0) break;
//        }

        for (int i = 1; i < len; i++) {
            int flag = 0;
            for (int j = 0; j < len-i; j++) {
                if(nums[j+1]<nums[j]){
                    flag = 1;
                    swap(nums,j+1,j);
                }
            }
            if(flag==0) break;
        }


    }





    //直接插入  希尔排序  选择排序  冒泡排序  堆排序
    public static void insertSort1(int[] array){
        for (int i = 1; i < array.length; i++) {
            //循环该数组
            int temp = array[i];//保存本次循环的array[i]
            int j = i-1;//与当前下表前面的数据进行比较
            for (;j >= 0; j--) {
                if(array[j]>temp){//如果大于本次循环的array【i】就覆盖下一个下标的值，
                    // 直到找到小于等于array的值或者判断完前面所有数据，
                    // 退出循环，将array【i】赋值给array[j+1]
                    swap(array,j,j+1);
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public static void shellSort1(int[] array){
        int gap = array.length>>1;
        while(gap>=1){
            shellSortHelper(array,gap);
            gap = gap>>1;
        }

    }

    private static void shellSortHelper(int[] array, int gap) {
        for (int i = gap; i < array.length; i+=gap) {
            int temp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(array[j]>temp){
                    swap(array,j,j+gap);
                }else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }

    public static void chooseSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    swap(array,i,j);
                }
            }
        }
    }

    public static void bubbleSort1(int[] array){
        for (int i = 1; i < array.length; i++) {
//            int flag = 0;
            for (int j = 0; j < array.length-i; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
//                    flag = 1;
                }
            }
//            if(flag==0) break;
        }
    }

    public static void heapSort1(int[] array){
        createHeap1(array);
        for (int i = 0; i < array.length-1; i++) {
            swap(array,0,array.length-1-i);
            adjustDown(array,array.length-1-i,0);
        }
    }

    private static void createHeap1(int[] array) {
        int size = array.length;
        int index = (array.length-1)>>1;
        for (int i = index; i >= 0; i--) {
            adjustDown(array,size,index);
        }
    }

    private static void adjustDown(int[] array, int size,int index) {
        int parent = index;
        int child = parent*2+1;
        while(child<size){
            if(child+1<size&&array[child]<array[child+1]){
                child++;
            }
            if(array[parent]<array[child]) swap(array,parent,child);
            parent = child;
            child = parent*2+1;
        }
    }


    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length-1);

    }
    private static void quickSortHelper(int[] array, int left, int right) {
        //此时区间中有零个或一个元素，不需要排序
        if(left>=right) return;
        //找到基准点进行递归
        int index = partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        int pivot = array[end];
        //一最右边的数为基准：先从左边找到比他大的元素
        //在从右边找到比它小的元素，然后进行交换，知道left>=right
        while(beg<end){
            //从左到右找到比基准大的数
            while(beg<end&&array[beg]<=pivot){
                beg++;
            }
            //循环结束，要么beg和end重合 要么找到了比基准大的数字
            //重合时：end的值一定比pivot大 因为上一次交换时end的值是大于pivot的
            while(beg<end&&array[end]>=pivot){
                end--;
            }
            //重合时：end的值一定比pivot大，因为上面beg找的的是比pivot大的值
            swap(array,beg,end);
        }
        swap(array,beg,right);
        return beg;
    }


    public static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length-1);
    }

    private static void mergeSortHelper(int[] array, int beg, int end) {
        //区间只有一个或零个直接返回
        if(beg>=end) return;
        int mid = (beg+end)>>1;
        mergeSortHelper(array,beg,mid);
        mergeSortHelper(array,mid+1,end);
        merge(array,beg,mid,mid+1,end);
    }

    private static void merge(int[] array, int beg1, int end1,int beg2,int end2) {

        int[] temp = new int[end2-beg1+1];
        int index = 0;
        int pos = beg1;
        while(beg1<=end1&&beg2<=end2){
            if(array[beg1]<=array[beg2]){
                temp[index++] = array[beg1];
                beg1++;
            }else {
                temp[index++] = array[beg2];
                beg2++;
            }
        }
        while (beg1<=end1)temp[index++] = array[beg1++];
        while (beg2<=end2)temp[index++] = array[beg2++];
        for (int i = 0; i < temp.length; i++) {
            array[pos++] = temp[i];
        }
    }








    public static void insertSort2(int[] array){
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            int temp = array[i];
            for ( ; j >= 0; j--) {
                if(array[j]>temp){
                    swap(array,j,j+1);
                }else{
                    break;
                }
            }
            array[j+1] = temp;
        }
    }


    public static void shellSort2(int[] array){
        int gap = array.length>>1;
        //缩小增量：从数组长的一半开始取增量，之后依次取半
        while(gap>=1){
            //带有增量的插入排序
            shellSortHelper2(array,gap);
            gap = gap>>1;
        }
    }

    private static void shellSortHelper2(int[] array, int gap) {
        //找到《=当下需要插入元素的值，出入在他前面
        for (int i = gap; i < array.length; i++) {//i每次加一！！！！！！
            int temp = array[i];//保存的是需要插入值的下表i！！！！！！
            //保存i下标的值 便于和前面的数值进行对比 也方便之后的赋值
            int j = i-gap;
            for (; j >= 0 ; j-=gap) {
                if(array[j]>temp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }


    public static void selectSort2(int[] array){
        //打擂台的模式：每次确定一个第一牛逼的人 之后依次确定第二牛逼 第三第四等等~直到确认len-1牛逼的人
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[i]){
                    swap(array,i,j);//不稳定{3331}第一次交换就导致了不稳定
                }
            }
        }
    }


    public static void bubbleSort2(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            //每次确定一个最大值或最小值，将其冒泡
            int pos = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    pos = 1;
                }
            }
            if (pos == 0) {
                break;
            }
        }
    }



    public static void heapSort2(int[] array){
        /**
         * 建立一个大队
         * 依次将堆顶元素与末尾元素交换，并删除末尾元素
         */
        createHeap2(array);
        int size = array.length;
        while(size>1){
            swap(array,0,size-1);
            size--;
            shiftDown2(array,size,0);
        }
    }
    private static void createHeap2(int[] array) {
        shiftDown2(array,array.length,(array.length-1)>>1);
    }

    private static void shiftDown2(int[] array, int size, int index) {
        int parent = index;
        int child = parent*2+1;
        while(child<size){
            if(child+1<size&&array[child+1]>array[child]){
                child++;
            }
            if(array[child]>array[parent]){
                swap(array,child,parent);
            }
            parent = child;
            child = parent*2+1;
        }
    }


    public static void quickSort2(int[] array){
        /**、
         * 寻找基准pivot
         * 将区间分为而部分【beg，pivot】【pivot+1，end】
         * 进行递归重复
         */
        quickSortHelper2(array,0,array.length-1);


    }

    private static void quickSortHelper2(int[] array, int left, int right) {
        if(left>=right) return;//区间只剩1个或零个元素

        int pivot = partition2(array,left,right);
        quickSortHelper2(array,left,pivot-1);//递归左边区间[left,pivot-1]!!!!!!!!!!!!!!!!!
        quickSortHelper2(array,pivot+1,right);//递归👉边区间[pivot+1,right// ]!!!!!!!!!!!!!!!!!
    }

    private static int partition2(int[] array, int left, int right) {
        int pos = right;
        int temp = array[right];
        //每次冲区间右边取得一个基准值
        //然后从左到右寻找一个大于基准值的数  在从右到左寻找一个小于基准值的数
        //交换两束  直至下标重合
        while(left<right){
            while (left<right&&array[left]<=temp){
                //《=体现稳定性
                left++;
            }
            while(left<right&&array[right]>=temp){
                right--;
            }
            swap(array,left,right);
        }
        //最终找的的值一定大于基准值：若是循环1退出，则此时下标重复的值为上一循环结束时最左边找到的大于基准值的数
        //                      若是循环二退出，重复下标的值一定大于基准，因为上一次循环找到了大于基准值的数
        swap(array,left,pos);
        return left;
    }


    public static void mergeSort2(int[] array){
        /**
         * 现将数组分为两个区间
         * 在对这两个区间依次递归
         * 直到两个区间有一个或零个元素
         * 在对有序的两个区间进行合并
         */
        mergeSortHelper2(array,0,array.length);

    }

    private static void mergeSortHelper2(int[] array, int beg, int end) {
        if(end-beg<=1) return;//此时区间只有一个或零个元素

        int mid = (beg+end)>>1;
        mergeSortHelper2(array,beg,mid);
        mergeSortHelper2(array,mid,end);
        //此时左右区间为两个有序的区间 进行合并
        merge2(array,beg,mid,mid,end);

    }

    private static void merge2(int[] array, int beg1, int end1, int beg2, int end2) {
        int pos = beg1;
        int[] temp = new int[end2-beg1];
        int index = 0;
        while (beg1<end1&&beg2<end2){
            if(array[beg1]<=array[beg2]){
                temp[index++] = array[beg1++];
            }else {
                temp[index++] = array[beg2++];
            }
        }
        while(beg1<end1) temp[index++] = array[beg1++];
        while(beg2<end2) temp[index++] = array[beg2++];
        for (int i = 0; i < temp.length; i++) {
            array[pos++] = temp[i];
        }
    }
    public static void mergeSortByLoop(int[] array){
        for (int gap = 1; gap < array.length; gap*=2) {
            for (int i = 0; i < array.length; i+=gap*2) {
                int beg1 = i;
                int mid = i+gap;
                int end2 = i+2*gap;
                //防止下标越界
                if(mid>array.length) mid = array.length;
                if(end2>array.length) end2 = array.length;
                merge2(array,beg1,mid,mid,end2);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {9, 5, 2, 6, 7, 3, 6, 2, 8};
//        insertSort2(nums);
//        shellSort2(nums);
//        selectSort2(nums);
//        heapSort(nums);
//        bubbleSort1(nums);
//        quickSort2(nums);
        mergeSortByLoop(nums);
        System.out.println(Arrays.toString(nums));
        Random random = new Random();
        int[] nums1 = new int[88888];
        for (int i = 0; i < 88888; i++) {
            nums1[i] = random.nextInt(50000);
        }
        long begin = System.currentTimeMillis();
        heapSort(nums1);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        System.out.println(Arrays.toString(nums1));
    }
}
