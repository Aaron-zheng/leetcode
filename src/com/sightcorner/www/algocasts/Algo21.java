package com.sightcorner.www.algocasts;

/**
 * Created by Aaron Zheng<br>
 * Created at 11/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 11/3/2020
 */
public class Algo21 {

    /**
     * 这个题目说的是，给你一个非空整数数组，你要找到和最大的连续子序列，然后返回它的和。
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{2, -8, 3, -2, 4, -10};
        System.out.println(getMaxConsistent(a));

    }

    private static int getMaxConsistent(int[] a) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < a.length; i++) {
            cur += a[i];
            if(cur > max) {
                max = cur;
            }
            if(cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
