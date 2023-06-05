package com.sightcorner.www.leetcode.leetcode.editor.cn;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9210 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if(null == s) {
            return 0;
        }
        int length = s.length();
        Set<Character> sets = new HashSet<>();
        int maxLength = 0;
        int previousLength = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        for(int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if(sets.contains(c)) {
                if(previousLength > maxLength) {
                    maxLength = previousLength;
                }
                while(true) {
                    Character first = linkedList.pop();
                    sets.remove(first);
                    previousLength = previousLength - 1;
                    if(first.equals(c)) {
                        break;
                    }
                }
            }
            sets.add(c);
            linkedList.add(c);
            previousLength = previousLength + 1;
        }
        if(previousLength > maxLength) {
            maxLength = previousLength;
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
