package com.sightcorner.www.solution;

import java.util.*;

/**
 * Created by Aaron Zheng<br>
 * Created at 3/1/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 3/1/2019
 */

/*

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

*/


public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * 做了一个窗口，通过i和j控制窗口的大小。已经比较过不重复的，则可以跳过不用比较
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(true) {
            if(s.length() == 0) {
                return 0;
            }
            if(map.containsKey(s.charAt(j))) {
                max = Math.max(max, j - i);
                i = map.get(s.charAt(j)) + 1;
                remove(map, s.charAt(j));
            } else {
                map.put(s.charAt(j), j);
                j++;
            }
            if(i == s.length() || j == s.length()) {
                break;
            }
        }
        max = Math.max(max, j - i);

        return max;
    }

    public void remove(Map<Character, Integer> map, Character c) {
        Integer num = map.get(c);
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue() <= num) {
                iterator.remove();
            }
        }
    }
}


