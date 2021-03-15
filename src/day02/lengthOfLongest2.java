package day02;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @auther 郭永钢
 * @data 2020/12/29 14:18
 * @desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class lengthOfLongest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            lengthOfLongest2 length = new lengthOfLongest2();
            System.out.println(length.lengthOfLongestSubstring(s));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
        int[] localtion = new int[128];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            left = Math.max(localtion[chars[i]]+1,left);
            max = Math.max(i-left+1,max);
            localtion[chars[i]] = i;
        }
        return max;
    }
}
