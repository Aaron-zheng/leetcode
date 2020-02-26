package com.sightcorner.www.algocasts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class Algo11 {

    /**
     * 这个题目说的是，给你一个整数数组，并且数组中没有重复元素，你要返回这个数组所有可能的排列。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[] {0,1,2};
        System.out.println(getAll(array));
    }


    private static List<List<Integer>> getAll(int[] array) {
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        //
        for(int i : array) {
            input.add(i);
        }
        //
        sort(input, 0, output);
        return output;
    }

    private static void sort(List<Integer> input, int start, List<List<Integer>> output) {
        if(input.size() == start) {
            output.add(new ArrayList<>(input));
        } else {
            for(int i = start; i < input.size(); i++) {
                Collections.swap(input, start, i);
                sort(input, start + 1, output);
                Collections.swap(input, start, i);
            }
        }
    }
}
