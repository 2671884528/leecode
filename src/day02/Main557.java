package day02;

/**
 * @auther 郭永钢
 * @data 2021/3/13 17:55
 * @desc: 反转字符串中的单词 III
 *
 */

public class Main557 {
    public static void main(String[] args) {
        Main557 main557 = new Main557();
        System.out.println(main557.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {

        String re = "", t1 = "", t2 = "", sl = "", sr = "";
        int i = 0, j =  s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != 32) {
                t1 = s.charAt(i) + t1;
            } else {
                sl += t1 + " ";
                t1 = "";
            }
            i++;
            if(i>j){
                break;
            }
            if (s.charAt(j) != 32) {
                t2 = t2 + s.charAt(j);
            } else {
                sr = " " + t2 + sr;
                t2="";
            }
            j--;
        }
        re=sl+t2+t1+sr;
        return re;
    }
}
