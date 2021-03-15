package day02;

import java.util.Scanner;

/**
 * @auther 郭永钢
 * @data 2021/3/15 15:16
 * @desc: 7. 整数反转
 * 思路：采用转字符串的方法，再转int类型，捕获异常，异常就是超出int
 * 的范围，直接输出0.
 */

public class Main007 {
    public static void main(String[] args) {
        Main007 main007 = new Main007();
        System.out.println(main007.reverse(2147483647));
    }

    public int reverse(int x) {

        try {
            String s = String.valueOf(x);
            String re;
            if (s.charAt(0) == '-') {
                re = s.substring(1, s.length());
                s = "";
                for (char c : re.toCharArray()) {
                    s = c + s;
                }
                s = "-" + s;
                return Integer.parseInt(s);
            } else {
                re = s;
                s = "";
                for (char c : re.toCharArray()) {
                    s = c + s;
                }
                return Integer.parseInt(s);

            }
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
