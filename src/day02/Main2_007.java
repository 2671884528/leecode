package day02;

/**
 * @auther 郭永钢
 * @data 2021/3/15 15:50
 * @desc: 7. 整数反转
 * 采用除法，数字溢出
 */

public class Main2_007 {
    public static void main(String[] args) {

        System.out.println(reverse(123456));
        System.out.println(reverse(-123456000));
        System.out.println(reverse(0));
        System.out.println(reverse(2147483641));
        System.out.println(reverse(2147483647));
    }
    public static int reverse(int x) {
        int re = 0;
        while (x!=0){
            //判断溢出
            if (re * 10 / 10 != re) {
                re=0;
                break;
            }
            re=re*10+x%10;
            x=x/10;
        }
        return re;
    }
}
