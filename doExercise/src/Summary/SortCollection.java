package Summary;

import sun.misc.Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeArray.shift;

public class SortCollection {


    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 6, 4, 8, 7, 9, 1};
//        insertSort(nums);
//        heapSort(nums);
//        shellSort(nums);
        maoPaoSort(nums);
        System.out.println(Arrays.toString(nums));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Random random = new Random();
        int[] array = new int[88888];
        long s = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            queue.offer(random.nextInt(88888));
//            array[i] = random.nextInt(88888);
        }
        long e = System.currentTimeMillis();
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(e-s);
        long start = System.currentTimeMillis();
//        insertSort(array);
        shellSort(array);
//maoPaoSort(array);
//        Arrays.sort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(array));
    }

    private static void maoPaoSort(int[] nums) {
        /*for (int i = nums.length - 1; i > 0; i--) {
            int pos = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[pos] < nums[j]) {
                    pos = j;

                }
            }

            swap(nums, i, pos);

        }*/
        for (int i = 0; i < nums.length ; i++) {
            int temp = i;
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[j]<nums[temp]){
                    temp = j;
                }
            }
            swap(nums,i,temp);
        }

        /*for (int i = 0; i < nums.length; i++) {
            int flg = 0;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j+1]) {
                    flg = 1;
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
            if(flg == 0) {
                break;
            }
        }*/
    }

    private static void shellSort(int[] nums) {
        int len = nums.length >> 1;
        while (len > 0) {
            shellSortHelper(nums, len);
            len /= 2;
        }
    }

    private static void shellSortHelper(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (nums[j] > temp) {
                    swap(nums, j, j + gap);
                } else {
                    break;
                }
            }
            nums[j + gap] = temp;
        }
    }

    private static void heapSort(int[] nums) {
        creatTree(nums);
        for (int i = 0; i < nums.length-1; i++) {
            swap(nums,0,nums.length-1);
        }

    }

    private static void shift(int[] nums,int len,int size) {
        int parent = len;
        int child = parent*2+1;
        if(child+1<size&&nums[child+1]>nums[child]){
            swap(nums,parent,child);
        }
    }

    private static void creatTree(int[] nums) {
        int len = (nums.length-1)/2;
        while (len>=0){
            shift(nums,len,nums.length);
            len--;
        }
    }


    private static void insertSort(int[] nums) {
        //直接插入
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    swap(nums, j, j + 1);
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
