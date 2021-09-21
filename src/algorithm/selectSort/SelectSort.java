package algorithm.selectSort;

import java.util.Arrays;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/9/21
 * Describe:
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{6,3,1,2,7,9,4};
        selectSort(ints);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }


    public  static <T extends Comparable<T>> void selectSort(T[] datas) {
        for (int i = 0; i <= datas.length-1; i++) {
            int local = i;
            for (int j = i; j <= datas.length-1; j++) {
                if (datas[local].compareTo(datas[j]) < 0) {
                    local = j;
                }
            }
            if (local != i) {
                T x = datas[local];
                datas[local] = datas[i];
                datas[i] = x;
            }
        }
    }
}
