package com.sightcorner.www.algocasts;

import com.alibaba.fastjson.JSON;

/**
 * Created by Aaron Zheng<br>
 * Created at 4/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 4/3/2020
 */
public class Algo18 {

    private static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkNode linkNode1 = new LinkNode(1, new LinkNode(3, null));
        LinkNode linkNode2 = new LinkNode(2, new LinkNode(4, new LinkNode(6, null)));
        LinkNode linkNode3 = getMerge(linkNode1, linkNode2);
        while(linkNode3 != null) {
            System.out.println(linkNode3.val);
            linkNode3 = linkNode3.next;
        }

    }


    private static LinkNode getMerge(LinkNode l1, LinkNode l2) {
        LinkNode root = new LinkNode(0, null);
        LinkNode current = root;
        while(true) {
            if(null == l1 && null == l2) {
                break;
            }
            if(null == l1) {
                current.next = l2;
                current = l2;
                l2 = l2.next;

            } else if(null == l2) {
                current.next = l1;
                current = l1;
                l1 = l1.next;

            } else if(l1.val > l2.val) {
                current.next = l2;
                current = l2;
                l2 = l2.next;

            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;

            }
        }

        return root.next;
    }
}
