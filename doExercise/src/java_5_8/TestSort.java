package java_5_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TestSort {
    public static void main1(String[] args) {
        int[] temp = new int[10];
//        Arrays.fill(temp,0);
        System.out.println(Arrays.toString(temp));
    }
    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 4, 2, 3, 5, 7, 6, 8};
//        insert(array);
//        shellSort(array);
//        selectSort(array);
//        maoPao(array);

        selectSort(array);
        System.out.println(Arrays.toString(array));


        Random random = new Random();
        int[] array1 = new int[88888];
        for (int i = 0; i < 88888; i++) {
            array1[i] = random.nextInt(88888);
        }
        long beg = System.currentTimeMillis();
//        insert(array1);
//        shellSort(array1);
//        selectSort(array1);
//        maoPao(array1);
//        quickSort(array1);
//        mergeSort(array1);
//        heapSort(array1);
//        jiShuSort(array1);
        selectSort(array1);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间:" + (end - beg));
        System.out.println(Arrays.toString(array1));
    }
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }


    private static void jiShuSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max,array[i]);
        }
        int[] temp = new int[max+1];
        Arrays.fill(temp,0);
        for (int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            while(temp[index]==0){
                index++;
            }
            array[i] = index;
            temp[index]--;
        }
    }


    private static void heapSort(int[] array) {
        /**
         * 1.建一个大堆/小堆  来进行 升序/降序
         * 2.吧堆顶元素和尾巴元素交换，并进行堆调整
         */
        createHeap(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftUp(array, array.length - 1 - i,0);//调整

        }
    }
    private static void createHeap(int[] array) {
        int size = array.length;
        int parent = (array.length - 1-1) >> 1;
        for (int i = parent; i >= 0; i--) {
            //向上调整
            shiftUp(array, size, i);
        }
    }
    private static void shiftUp(int[] array, int size, int parent) {
        int child = parent * 2 + 1;
        while(child<size){
            if(child+1<size&&array[child]<array[child+1]) {
                child++;
            }
            if(array[parent]<array[child]) {
                swap(array,child,parent);
            }
            parent = child;
            child = parent*2+1;
        }
    }

    private static void mergeSort(int[] array) {
        int len = array.length - 1;

        mergeSortHelper(array, 0, len);
    }

    private static void mergeSortHelper(int[] array, int i, int len) {
        if (len - i < 1) return;
        int mid = (i + len) >> 1;
        mergeSortHelper(array, i, mid);
        mergeSortHelper(array, mid + 1, len);
        merge(array, i, mid, mid + 1, len);

    }

    private static void merge(int[] array, int s1, int e1, int s2, int e2) {
        int[] temp = new int[e2 - s1 + 1];
        int pos = s1;
        int index = 0;

        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                temp[index++] = array[s1++];
            } else {
                temp[index++] = array[s2++];
            }
        }
        while (s1 <= e1) temp[index++] = array[s1++];
        while (s2 <= e2) temp[index++] = array[s2++];
        for (int value : temp) {
            array[pos++] = value;
        }
    }

    private static void quickSort(int[] array) {
        /**
         * 找基准，将当前数组分为两部分大于基准和小于基准的
         * 递归执行每一个子数组
         *  O(nlogn) 不稳定
         */
        int len = array.length - 1;
        quickSortHelp(array, 0, len);

    }

    private static void quickSortHelp(int[] array, int s, int e) {
        if (e - s < 1) {
            return;
        }
        int pivot = povit(array, s, e);
        quickSortHelp(array, s, pivot - 1);
        quickSortHelp(array, pivot + 1, e);
    }

    private static int povit(int[] array, int s, int e) {
        int temp = array[e];
        int index = e;
        while (e > s) {
            while (e > s && array[s] <= temp) {
                s++;
            }
            while (e > s && array[e] >= temp) {
                e--;
            }
            swap(array, s, e);
            /*while(e>s&&array[s]<=temp){
                s++;
            }
            swap(array,s,e);
            while (e>s&&array[e]>=temp){
                e--;
            }
            swap(array,s,e);*/
        }
        swap(array, s, index);
        return s;
    }


    private static void maoPao(int[] array1) {
        //双层循环：每次将一个最大/最小的数放在最后(13500ms左右)
        //优化：加标记位判断是否有序
        for (int i = 1; i < array1.length; i++) {
            int pos = 1;
            for (int j = 0; j < array1.length - i; j++) {
                if (array1[j] > array1[j + 1]) {
                    swap(array1, j, j + 1);
                    pos = 0;
                }
            }
            if (pos == 1) {
                break;
            }
        }

    }

    private static void selectSort(int[] array1) {
        //选择排序：从前往后遍历，为每一个下表找到适合的值(20000ms左右)
        //O(n^2) 不稳定{3，3，1}
        for (int i = 0; i < array1.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array1.length; j++) {
                if (array1[j]<array1[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array1,i,minIndex);
        }
    }


    private static void insert(int[] array) {
        //直接插入:双重循环，为每一个元素在它前面的数组中选出合适位置(2000~3000ms)
        //O(n^2);稳定
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    swap(array, j, j + 1);
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    private static void shellSort(int[] array) {
        //希尔排序：缩小增量+直接插入(17ms~18ms)
        //O(n^1.3~n^2)不稳定
        int len = array.length;
        while (len >= 1) {
            shellSortHelper(array, len);
            len /= 2;
        }
    }

    private static void shellSortHelper(int[] array, int len) {
        for (int i = len; i < array.length; i++) {
            int temp = array[i];
            int j = i - len;
            for (; j >= 0; j -= len) {
                if (array[j] > temp) {
                    swap(array, j, j + len);
                } else {
                    break;
                }
            }
            array[j + len] = temp;
        }


    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
