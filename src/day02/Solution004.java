package day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @auther 郭永钢
 * @data 2021/1/25 15:33
 * @desc: 给定两个大小为 m 和 n 的正序（从小到大）数组
 * nums1 和 nums2。请你找出并返回这两个正序数组的中位数
 */

public class Solution004 {

    public static void main(String[] args) {
        Solution004 solution004 = new Solution004();
        int[] a = {2};
        int[] b = {};
        System.out.println(solution004.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = 0, t = 0;
        int[] rs = new int[len];
        for (int i = 0; i < len; i++) {
            if (k < nums1.length && t < nums2.length) {
                rs[i] = nums1[k] < nums2[t] ? nums1[k++] : nums2[t++];
            }else if (k>=nums1.length){
                rs[i] = nums2[t++];
            }else {
                rs[i] = nums1[k++];
            }
        }
        System.out.println();
//        new BigDecimal().setScale(5, 4).toString();
       return len % 2 == 0 ? ((rs[len / 2 - 1] + rs[len / 2]) / 2.0) : rs[len / 2];
    }

}
