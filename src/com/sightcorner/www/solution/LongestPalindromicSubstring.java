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

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
*/

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccc"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babaa"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(""));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cccccb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaa"));
    }


    public String longestPalindrome(String s) {
        int length = s.length();
        if(s.length() == 0) {
            return "";
        }
        String maxString = "";

        for(int i = 0; i < length; i++) {
            String newString = this.getMaxString(s, i, i);
            if(newString.length() > maxString.length()) {
                maxString = newString;
            }
            newString = this.getMaxString(s, i, i+1);
            if(newString.length() > maxString.length()) {
                maxString = newString;
            }
        }

        return maxString;
    }

    private String getMaxString(String s, int left, int right) {
        String maxString = "";
        while(true) {
            if(left < 0) {
                break;
            }
            if(right > s.length() -1) {
                break;
            }

            if(s.charAt(left) == s.charAt(right)) {
                maxString = s.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }

        return maxString;
    }
}
