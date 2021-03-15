package day02;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @auther 郭永钢
 * @data 2020/12/29 14:36
 * @desc:
 */

public class Test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String s = scanner.nextLine();
//        System.out.println("dwd=="+s+"==dda");

        ///////////////////////

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(3);
        set.add(2);

        set.forEach(k->{
            System.out.println(k);
        });
    }
}
