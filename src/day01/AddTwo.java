package day01;

import java.util.Scanner;

/**
 * @auther 郭永钢
 * @data 2020/12/28 12:45
 * @desc:
 */

public class AddTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split("");
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();

        ListNode temp = null;
        boolean flag = true;
        int size1 = 0, size2 = 0, size = 0;
        for (String s : split) {
            if (s.equals("+")) {
                flag = false;
                temp = null;
            }

            if (s.matches("[0-9]")) {
                ListNode listNode = new ListNode(Integer.parseInt(s));
                if (temp == null) {
                    if (flag) {
                        temp = node1;
                    } else {
                        size1 = size;
                        size = 0;
                        temp = node2;
                    }
                    temp.next = listNode;
                } else {
                    temp.next = listNode;
                }
                temp = temp.next;
                size++;
            }
        }

        AddTwo addTwo = new AddTwo();
        ListNode listNode = addTwo.addTwoNumbers(node1, node2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //固定头节点，一般头节点是不存储的，但是这个题目头节点需要存储
        ListNode node = null;
        //每次开始移动的节点
        ListNode first = null;
        //每次新建的节点，写在外面减少内存消耗
        ListNode temp = null;

        //res:a+b的结果，step：进位
        int a = 0, b = 0, res = 0, step = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
            }
            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
            }
            res = a + b + step;
            if (res >= 10) {
                res = res % 10;
                step = 1;
            } else {
                step = 0;
            }
            temp = new ListNode(res);
            if (first == null) {
                first = temp;
                node = first;
            } else {
                first.next = temp;
                first = first.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (step != 0) {
            first.next = new ListNode(step);
        }
        return node;
    }
}

