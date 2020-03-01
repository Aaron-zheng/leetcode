package com.sightcorner.www.algocasts;

import java.util.Stack;

/**
 * Created by Aaron Zheng<br>
 * Created at 1/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 1/3/2020
 */
public class Algo14 {

    public static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 这个题目说的是，给你一个单链表表示的数，你要判断它是不是一个回文数字。回文数字就是正着读和反着读都相同的数字。
     * @param args
     */
    public static void main(String[] args) {
        LinkNode linkNode1 = new LinkNode(4, new LinkNode(2, new LinkNode(2, new LinkNode(4, null))));
        LinkNode linkNode2 = new LinkNode(4, new LinkNode(2, null));
        System.out.println(judgeInStack(linkNode1));
        System.out.println(judgeInStack(linkNode2));
        System.out.println(judgeInLink(linkNode1));
        System.out.println(judgeInLink(linkNode2));
    }

    public static boolean judgeInStack(LinkNode linkNode) {
        Stack<Integer> stack = new Stack<>();
        for(LinkNode l = linkNode; l != null; l = l.next) {
            stack.add(l.val);
        }
        for(LinkNode l = linkNode; l != null; l = l.next) {
            if(stack.pop() != l.val) {
                return false;
            }
        }
        return true;
    }


    public static boolean judgeInLink(LinkNode linkNode) {
        int len = 0;
        for(LinkNode l = linkNode; l != null; l = l.next) {
            len++;
        }
        LinkNode pre = null;
        LinkNode cur = linkNode;
        for(int i = 0; i < len/2; i++) {
            LinkNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if(len % 2 !=0) {
            cur = cur.next;
        }
        while(true) {
            if(null == pre || null == cur) {
                break;
            }
            if(pre.val != cur.val) {
                return false;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return true;
    }
}
