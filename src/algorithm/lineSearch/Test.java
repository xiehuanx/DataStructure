package algorithm.lineSearch;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/9/13
 * Describe:线性查找
 * 线性查找原理：
 *       循环数据，每次都进行比较，时间最长用时为n，时间最短为1
 */
public class Test {

    public static void main(String[] args) {
        int search = search(null, 2);
        System.out.println(search);
    }


    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
