package com.sightcorner.www.algocasts;

import java.util.LinkedList;
import java.util.Queue;

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
public class Algo16 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 这个题目说的是，给你一棵二叉树，你要找到从根节点到最近的叶子节点的深度。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(4, new TreeNode(8, null, null), new TreeNode(16, null, null))
                );
        TreeNode treeNode2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4, null, null), null), null), null);

        System.out.println(depthInLoop(treeNode1));
        System.out.println(depthInLoop(treeNode2));
        System.out.println(depthNoLoop(treeNode1));
        System.out.println(depthNoLoop(treeNode2));
    }

    private static int depthInLoop(TreeNode treeNode) {
        if(null == treeNode) return 0;
        if(null == treeNode.left && null == treeNode.right) return 1;
        if(null != treeNode.left && null == treeNode.right) return depthInLoop(treeNode.left) + 1;
        if(null == treeNode.left && null != treeNode.right) return depthInLoop(treeNode.right) + 1;
        return Math.min(depthInLoop(treeNode.left), depthInLoop(treeNode.right)) + 1;
    }

    private static int depthNoLoop(TreeNode treeNode) {
        if(null == treeNode) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int length = 1;
        while(true) {
            if(queue.isEmpty()) {
                break;
            }
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if(null == t.left && null == t.right) {
                    return length;
                }
                if(null != t.left) {
                    queue.add(t.left);
                }
                if(null != t.right) {
                    queue.add(t.right);
                }
            }
            length++;
        }
        return -1;
    }
}
