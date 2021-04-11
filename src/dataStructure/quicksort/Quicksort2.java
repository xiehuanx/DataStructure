package dataStructure.quicksort;

import java.util.Arrays;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/1/7
 * Describe:
 */
public class Quicksort2 {


    public static int partition(int[] arr, int low, int high) {

        //指定左指针i和右指针j
        int i = low;
        int j = high;

        //将第一个数作为基准值。挖坑
        int x = arr[low];

        //使用循环实现分区操作
        while (i < j) {//5  8
            //1.从右向左移动j，找到第一个小于基准值的值 arr[j]
            while (arr[j] >= x && i < j) {
                j--;
            }
            //2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
            while (arr[i] < x && i < j) {
                i++;
            }
            //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        //使用基准值填坑，这就是基准值的最终位置
        arr[i] = x;//arr[j] = y;
        //返回基准值的位置索引
        return i; //return j;
    }

    public static void Quicksort2(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            Quicksort2(arr, low, partition - 1);
            Quicksort2(arr, partition + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 1, 5, 21, 7, 4, 8};
        Quicksort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
