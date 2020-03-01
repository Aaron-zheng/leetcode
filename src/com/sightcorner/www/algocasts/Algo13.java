package com.sightcorner.www.algocasts;

/**
 * Created by Aaron Zheng<br>
 * Created at 1/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 1/3/2020
 */
public class Algo13 {


    /**
     * 这个题目说的是，给你一个整数，你要判断它是否是一个回文数字。
     * 所谓回文数字就是，你正着读和反着读都是同一个数字。
     * @param args
     */
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isRecNumber(n));
        n = -232;
        System.out.println(isRecNumber(n));
    }

    private static boolean isRecNumber(int number) {
        String str = String.valueOf(number);
        int i = 0;
        int j = str.length() - 1;
        while(true) {
            if(i > j) {
                break;
            }
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
