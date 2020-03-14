package com.sightcorner.www.algocasts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Aaron Zheng<br>
 * Created at 14/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 14/3/2020
 */
public class Algo22 {

    private static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val, Node right, Node left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    /**
     * 这个题目说的是，给你一棵二叉树，你要找到从根节点到最远叶子节点的深度。
     * @param args
     */
    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, null, null), new Node(4, new Node(8, null, null), new Node(16, new Node(32, null, null), null)));
        System.out.println(deepRec(node));
        System.out.println(deep(node));
    }

    private static int deepRec(Node node) {
        if(null == node) return 0;
        return Math.max(deepRec(node.left), deepRec(node.right)) + 1;
    }

    private static int deep(Node node) {
        if(null == node) return 0;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        int h = 0;
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                Node n = stack.pop();
                if(n != null) {
                    if(n.left != null) {
                        stack.add(n.left);
                    }
                    if(n.right != null) {
                        stack.add(n.right);
                    }
                }
            }
            h++;
        }
        return h;
    }
}
