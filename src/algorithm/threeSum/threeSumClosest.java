package algorithm.threeSum;

import java.util.Arrays;

/**
 * author :xie
 * Email: 1487471733@qq.com
 * Date: 2020/4/19 16:41
 * Describe:
 */
public class threeSumClosest {

    public static void main(String[] args) {
        int[] a={-1,2,1,-4};
        int threeSumClosest = threeSumClosest(a, 1);
        System.out.println(threeSumClosest);
    }
    /**
     * 暴力for循环
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int sum=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int z = j+1; z < nums.length; z++) {
                    int x=nums[i]+nums[j]+nums[z];
                    int abs = Math.abs(target - x);
                    if (abs<min) {
                        sum=x;
                        min=abs;
                    }

                }
            }
        }
        return sum;

    }
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if(sum > target) {
                    end--;
                } else if(sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

}
