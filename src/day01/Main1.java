package day01;

import sun.applet.Main;

import java.util.HashMap;

/**
 * @auther 郭永钢
 * @data 2020/12/7 15:48
 * @desc: 1. 两数之和
 */

public class Main1 {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 13};
        for (int i : new Solution().twoSum(a, 9)) {
            System.out.print(i);
        }
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }
            return null;
        }

        //HashMap实现
        public int[] twoSum2(int[] nums, int target) {
            int temp = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                temp = target - nums[i];
                if (map.containsKey(temp)){
                    return new int[]{map.get(temp),i};
                }else {
                    map.put(nums[i],i);
                }
            }
            return null;
        }
    }
}
