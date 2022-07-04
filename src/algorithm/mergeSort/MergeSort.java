package algorithm.mergeSort;

import java.util.Arrays;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/9/25
 * Describe:
 * 归并排序
 */
public class MergeSort {


    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int middle = l + (r - l) / 2;
        sort(arr, l, middle);
        sort(arr, middle + 1, r);
        // 因为需要排序，所以如果左边最大的，都比右边最小的小，那么说明了左边和右边已经是有序的，不需要在进行merge了
        if (arr[middle].compareTo(arr[middle + 1]) > 0) {
            merge(arr, l, middle, r);
        }
    }


    /**
     * 合并arr[l,middle]和arr[middle+1, r],排序
     *
     * @param arr
     * @param l
     * @param middle
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int middle, int r) {
        //1. 复制一个arr的备份，叫做temp
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        //2. 选好标记点
        int i = l, j = middle + 1;
        //3. 利用temp来重新给arr[l,r]区间的位置重新赋值
        for (int k = l; k <= r; k++) {
            //当i大于了middle，说明了左边的数组已经遍历完了，那么剩下的数据直接从右边取出来就可以了
            if (i > middle) {
                arr[k] = temp[j - l];
                j++;
            }
            //当j大于r的时候，说明了右边的数据已经遍历完了，那么剩下的数据直接从左边取出来
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
            //否则的话，i和j都还在数组界限里面，比较两个对应的值的大小，小的那个就是
            else if (arr[i - l].compareTo(arr[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }


    }



}
