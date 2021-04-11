package dataStructure;

import java.util.Arrays;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/5
 * Describe:
 */
public class Quicksort2 {

    public static int partition(int[] arr, int low, int high) {
        int i = low;

        int j = high;

        int x = arr[low];

        while (i < j) {

            while (arr[j] > x && i < j) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (arr[i] < x && i < j) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;
        return i;
    }

    public static void Quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            Quicksort(arr, low, partition - 1);
            Quicksort(arr, partition + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 1, 5, 21, 7, 4, 8};
        Quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
