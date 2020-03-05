package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

/**
 * Created by Aaron Zheng<br>
 * Created at 5/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 5/3/2020
 */
public class Algo19 {

    /**
     * 这个题目说的是，给你两个递增排序的数组，你要把第二个数组合并到第一个，并使其仍然保持递增排序。
     * 两个数组中的元素个数会显式地给出，并且第一个数组的大小可以容纳下两个数组中所有的元素。
     * @param args
     */
    public static void main(String[] args) {
        int[] a1 = new int[]{2,4,-1,-1};
        int[] a2 = new int[]{1,3};

        System.out.println(JSON.toJSONString(getMerge(a1, 2, a2, 2)));
    }

    private static int[] getMerge(int[] a1, int m, int[] a2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(true) {
            if(k < 0) {
                break;
            }
            if(i < 0) {
                a1[k] = a2[j];
                j--;
            } else if(j < 0) {
                a1[k] = a1[i];
                i--;
            } else if(a1[i] > a2[j]) {
                a1[k] = a1[i];
                i--;
            } else {
                a1[k] = a2[j];
                j--;
            }

            k--;
        }
        return a1;
    }
}
