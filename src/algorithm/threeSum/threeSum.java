package algorithm.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author :xie
 * Email: 1487471733@qq.com
 * Date: 2020/4/19 14:44
 * Describe: 三数相加等于0
 */
public class threeSum {

    public static void main(String[] args) {
        int[] a={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    /**
     * 初版 超时
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int x=nums[i] + nums[j];
                if (x>0) {
                    break;
                }
                int abs = Math.abs(x);
                if (list.contains(abs)) {
                    List<Integer> integerList=new ArrayList<>();
                    integerList.add(nums[i]);
                    integerList.add(nums[j]);
                    integerList.add(abs);
                    lists.add(integerList);
                }
            }
        }
        return lists;
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

}
