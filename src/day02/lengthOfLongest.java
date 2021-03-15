package day02;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @auther 郭永钢
 * @data 2020/12/29 14:18
 * @desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class lengthOfLongest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            lengthOfLongest length = new lengthOfLongest();
            System.out.println(length.lengthOfLongestSubstring(s));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left=0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                max = max > i-left ? max : i-left;
                left = left > map.get(chars[i]) + 1 ? left : map.get(chars[i]) + 1;
                map.put(chars[i], i);

            } else {
                map.put(chars[i], i);
            }
        }
        max = max>chars.length-left?max:chars.length-left;
        return max;
    }
}
