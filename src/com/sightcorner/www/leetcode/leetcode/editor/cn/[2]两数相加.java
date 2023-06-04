package com.sightcorner.www.leetcode.leetcode.editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9639 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode start = null;
        ListNode previous = null;
        int previousNum = 0;
        do {
            int v1 = 0;
            if(null != c1) {
                v1 = c1.val;
            }
            int v2 = 0;
            if(null != c2) {
                v2 = c2.val;
            }
            int v3 = v1 + v2 + previousNum;
            ListNode result;
            if(v3 < 10) {
                result = new ListNode();
                result.val = v3;
                previousNum = 0;
            } else {
                result = new ListNode();
                result.val = v3 - 10;
                previousNum = 1;
            }

            if(null == previous) {
                start = result;
                previous = result;
            } else {
                previous.next = result;
                previous = result;
            }
            if(null != c1) {
                c1 = c1.next;
            }
            if(null != c2) {
                c2 = c2.next;
            }

            if(null == c1 && null == c2) {
                if(previousNum != 0) {
                    ListNode end = new ListNode();
                    end.val = 1;
                    previous.next = end;
                }
                break;
            }
        } while(true);
        //
        return start;
    }

}


//leetcode submit region end(Prohibit modification and deletion)
