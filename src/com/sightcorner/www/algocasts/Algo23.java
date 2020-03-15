package com.sightcorner.www.algocasts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Zheng<br>
 * Created at 15/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 15/3/2020
 */
public class Algo23 {

    /**
     * 这个题目说的是，给你一个数组，里面有一个数字出现的次数超过了一半，你要找到这个数字并返回。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 3, 1, 3, 1, 1,1 ,2};
        System.out.println(getOccurMax(array));
        System.out.println(getOccurMaxWithMooreVoting(array));
    }

    /**
     * Time: O(n), Space: O(n)
     * @param array
     * @return
     */
    private static int getOccurMax(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = -1;
        int maxNum = -1;
        for(int i = 0; i < array.length; i++) {
            Integer newCount = map.getOrDefault(array[i], 0) + 1;
            map.put(array[i], newCount);
            if(newCount > maxCount) {
                maxCount = newCount;
                maxNum = array[i];
            }
        }
        return maxNum;
    }

    /**
     * Moore Voting 摩尔投票法
     */
    private static int getOccurMaxWithMooreVoting(int[] array) {
        int count = 0;
        int num = -1;
        for(int i = 0; i < array.length; i++) {
            if(count == 0) {
                count = 1;
                num = array[i];
            } else if(num == array[i]) {
                count++;
            } else {
                count --;
            }
        }
        return num;
    }
}
