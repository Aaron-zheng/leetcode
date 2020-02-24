package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

/**
 * Created by Aaron Zheng<br>
 * Created at 25/2/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 25/2/2020
 */
public class Algo3 {

    /**
     * 这个题目说的是，给你一个整数数组，并且这个数组是按递增排序的，
     * 你要找到数组中的两个整数，它们的和等于给定的目标值，然后返回它们的下标。
     * 题目假设给你的数组总是有且只有一个解，而且同一个元素不能使用两次。
     * 另外，返回结果的下标要从 1 开始。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 6, 8, 11};
        int target = 10;
        System.out.println(JSON.toJSONString(findTarget(array, target)));
    }

    private static int[] findTarget(int[] source, int target) {
        int i = 0;
        int j = source.length - 1;
        while(true) {
            if(i > j) {
                return new int[]{-1, -1};
            }
            int head = source[i];
            int tail = source[j];
            if(target == head + tail) {
                return new int[]{i+1, j+1};
            }
            if(head + tail > target) {
                j--;
            }
            if(head + tail < target) {
                i++;
            }
        }
    }
}
