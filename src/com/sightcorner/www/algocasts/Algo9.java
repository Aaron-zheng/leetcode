package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

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
public class Algo9 {

    private static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 这个题目说的是，给你一个单链表，你需要反转它，然后返回。
     * @param args
     */
    public static void main(String[] args) {
        LinkNode root = new LinkNode(1, new LinkNode(2, new LinkNode(3, new LinkNode(4, new LinkNode(5, null)))));
        LinkNode output = root;
        while(true) {
            if(null == output) break;
            System.out.print(output.val);
            output = output.next;
        }
        System.out.println();
        output = getReverse(root);
        while(true) {
            if(null == output) break;
            System.out.print(output.val);
            output = output.next;
        }
    }

    private static LinkNode getReverse(LinkNode node) {
        if(null == node) return null;
        //
        LinkNode pre = null;
        LinkNode cur = node;
        LinkNode next;
        //
        while(true) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next == null) {
                break;
            }
        }
        return pre;

    }
}
