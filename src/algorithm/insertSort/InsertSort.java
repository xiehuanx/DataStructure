package algorithm.insertSort;

import java.util.Arrays;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/9/22
 * Describe:
 *
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{6,3,1,2,7,9,4};
        insertSort(ints);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }


    public  static <T extends Comparable<T>> void insertSort(T[] data) {
        for (int i = 0; i <= data.length-1; i++) {
            for (int j = i; j -1 >=0; j--) {
                if (data[j].compareTo(data[j-1]) < 0) {
                    T x = data[j-1];
                    data[j-1] = data[j];
                    data[j] = x;
                } else {
                    break;
                }
            }
        }
    }
}
