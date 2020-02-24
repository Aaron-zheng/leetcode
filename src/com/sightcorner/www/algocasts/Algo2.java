package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

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
public class Algo2 {

    /**
     * 这个题目说的是，给你一个整数数组和一个目标值，你要找到数组里两个整数，
     * 它们的和等于目标值。然后返回这两个整数的下标。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 6, 8, 11};
        int target = 10;

        System.out.println(JSON.toJSONString(findTarget(array, target)));
    }

    private static int[] findTarget(int[] source, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < source.length; i++) {
            int need = target - source[i];
            Integer index = map.get(need);
            if(null == index) {
                map.put(source[i], i);
                continue;
            }
            return new int[]{i, index};
        }

        return new int[]{-1, -1};
    }
}
