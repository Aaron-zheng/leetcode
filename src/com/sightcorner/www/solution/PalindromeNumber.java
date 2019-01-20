package com.sightcorner.www.solution;

/**
 * Created by Aaron Zheng<br>
 * Created at 21/1/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 21/1/2019
 */

/*
* 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
* */
public class PalindromeNumber {


    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while(true) {

            if(i >= j) {
                return true;
            }

            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
    }

}
