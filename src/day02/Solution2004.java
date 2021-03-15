package day02;

/**
 * @auther 郭永钢
 * @data 2021/1/25 15:33
 * @desc: 给定两个大小为 m 和 n 的正序（从小到大）数组
 * nums1 和 nums2。请你找出并返回这两个正序数组的中位数
 */

public class Solution2004 {

    public static void main(String[] args) {
        Solution2004 solution004 = new Solution2004();
        int[] a = {2};
        int[] b = {};
        System.out.println(solution004.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = 0, t = 0;
        if (len%2==0){

        }else {

        }
        while (len > 0) {
            len = len / 2;

        }
        return 0;
    }

}
