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
public class Algo15 {

    /**
     * 这个题目说的是，从 0 到 n 这 n+1 个整数中去掉一个，然后把剩下的 n 个整数放进一个长度为 n 的数组，
     * 给你这个数组，你要找到那个去掉的整数。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 0, 2};
        System.out.println(getMissingNum(array));
    }

    private static int getMissingNum(int[] nums) {
        int result = nums.length;
        for(int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }
}
