package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

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
public class Algo7 {

    /**
     * 这个题目说的是，给你一个二维数组 matrix，和一个目标值 target。你要在数组里找到这个目标值，然后返回它的行/列下标。如果找不到，则返回 [-1,-1]。
     * 这个数组的每一行都是从左向右递增，每一列都是从上到下递增。和「二维数组的二分搜索」不同，这道题目并不保证每一行的第一个数都比上一行的最后一个数要大。
     * @param args
     */
    public static void main(String[] args) {
        //
        //1, 3, 5
        //2, 4, 6
        int[][] array = {{1,3,5},{2,4,6},{11,14,16}};
        int target = 14;

        System.out.println(JSON.toJSONString(getTargetIndex(array, target)));
    }

    private static int[][] getTargetIndex(int[][] array, int target) {
        if(array == null || array.length <= 0 || array[0].length <= 0) return new int[][]{{-1},{-1}};
        int m = array.length;
        int n = array[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = n-1; j >= 0; j--) {
                if(array[i][j] == target) return new int[][]{{i},{j}};
                if(array[i][j] > target);
                if(array[i][j] < target) break;
            }
        }
        return new int[][]{{-1},{-1}};
    }
}
