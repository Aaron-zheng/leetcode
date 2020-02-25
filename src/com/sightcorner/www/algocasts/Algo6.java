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
public class Algo6 {

    /**
     * 这个题目说的是，给你一个非空的整数数组，这个数组中有一个整数只出现了一次，
     * 其它的整数都出现两次，你要找出这个只出现一次的整数。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 5, 6, 6};
        System.out.println(getSingleNumber(array));
    }

    public static int getSingleNumber(int[] array) {
        int result = array[0];
        for(int i = 1; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }
}
