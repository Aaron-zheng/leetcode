package com.sightcorner.www.solution;

/**
 * Created by Aaron Zheng<br>
 * Created at 20/1/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 20/1/2019
 */
/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(-123));

        //2147483647
        System.out.println(Integer.MAX_VALUE);
        //-2147483648
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        int push = 0;
        boolean positiveNum = true;
        if(x < 0) {
            positiveNum = false;
        }
        while(true) {
            int pop = x % 10;
            x = x / 10;

            if(positiveNum) {
                if(push > Integer.MAX_VALUE / 10 || (push == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
            } else {
                if(push < Integer.MIN_VALUE / 10 || (push == Integer.MIN_VALUE / 10 && pop < -8 )) {
                    return 0;
                }

            }

            push = push * 10 + pop;


            if(x == 0) {
                break;
            }
        }

        return push;
    }


    /**
     * 解法1，直接用了 string builder 的反转
     * @param x
     * @return
     */
    public int reverse2(int x) {
        boolean positiveNum = true;
        if(x < 0) {
            positiveNum = false;
        }
        String s = String.valueOf(x).replace("-", "");
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        try {
            return Integer.parseInt(sb.toString()) * (positiveNum ? 1 : -1);
        } catch (Exception ex) {
            return 0;
        }
    }

}
