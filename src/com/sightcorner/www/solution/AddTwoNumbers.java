package com.sightcorner.www.solution;

import java.util.List;

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

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/



public class AddTwoNumbers {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode tmp = null;
        Integer last = null;
        while(true) {
            if(null == l1 && null == l2) {
                if(null != last) {
                    ListNode current = new ListNode(last);
                    tmp.next = current;
                }
                return first;
            }
            int v1 = (null == l1) ? 0 : l1.val;
            int v2 = (null == l2) ? 0 : l2.val;
            int v3 = v1 + v2 + ((null == last) ? 0 : last);
            if(v3 >= 10) {
                last = 1;
                v3 = v3 - 10;
            } else {
                last = null;
            }
            ListNode current = new ListNode(v3);

            if(null == tmp) {
                tmp = current;
                first = current;
            } else {
                tmp.next = current;
                tmp = current;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }

    }

}
