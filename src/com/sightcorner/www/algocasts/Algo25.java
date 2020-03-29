package com.sightcorner.www.algocasts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Zheng<br>
 * Created at 30/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 30/3/2020
 */
public class Algo25 {

    /**
     * 这个题目说的是，给你一个字符串，你要找到没有重复字符的最长子串，然后返回它的长度。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "wabcdefgabcuuijasdfl";
        String s3 = "ddd";
        System.out.println(getLengthWithoutDuplicate(s1));
        System.out.println(getLengthWithoutDuplicate(s2));
        System.out.println(getLengthWithoutDuplicate(s3));
    }

    // time: O(n), Space: O(m)
    private static int getLengthWithoutDuplicate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        int i = 0;
        int j = 0;
        for(; i < s.length(); i++) {
            for(; j < s.length(); j++) {
                Character c = s.charAt(j);
                if(map.containsKey(c) && map.get(c) > 0) {
                    break;
                } else {
                    int add = map.get(c) == null ? 1 : map.get(c) + 1;
                    map.put(c, add);
                }
            }
            maxLength = Math.max(maxLength, j - i);
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        return maxLength;
    }


    private static int getLengthWithoutDuplicateOptimize(String s) {
        Map<Character, Integer> map = new HashMap<>();
        return -1;
    }
}
