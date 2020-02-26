package com.sightcorner.www.algocasts;

/**
 * Created by Aaron Zheng<br>
 * Created at 26/2/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 26/2/2020
 */
public class Algo12 {

    /**
     * 这个题目说的是，给你一个字符串，你要计算出它所包含的回文子串个数。
     * 只要起始下标或终止下标不同，即使子串相同，我们也认为是不同的回文子串。
     * @param args
     */
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(cal(s));
        s = "aba";
        System.out.println(cal(s));
    }

    private static int cal(String s) {
        int length = s.length();
        int[][] array = new int[length][length];
        int count = 0;
        for(int i = length - 1; i >= 0; i--) {
            for(int j = i; j < length; j++) {
                if(i == j) array[i][j] = 1;
                else if(i + 1 == j) array[i][j] = (s.charAt(i) == s.charAt(j) ? 1 : 0);
                else array[i][j] = ((s.charAt(i) == s.charAt(j) && array[i+1][j-1] == 1) ? 1 : 0);
                if(array[i][j] == 1) count++;
            }
        }
        return count;
    }
}
