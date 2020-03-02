package com.sightcorner.www.algocasts;

import java.util.Stack;

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
public class Algo8 {

    private static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    /**
     * 这个题目说的是，给你两个二叉树，你要判断它们是否相同。这里所谓相同，指的是两棵树结构相同，并且相应节点上的数值相等。
     * @param args
     */
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(8, null, null)),
                new TreeNode(2, new TreeNode(8, null, null), new TreeNode(4, null, null))
        );
        TreeNode treeNode2 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(8, null, null)),
                new TreeNode(2, new TreeNode(8, null, null), new TreeNode(4, null, null))
        );
        TreeNode treeNode3 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(8, null, null)),
                new TreeNode(2, new TreeNode(8, null, null), new TreeNode(4, null, null))
        );
        TreeNode treeNode4 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(8, null, null)),
                new TreeNode(2, new TreeNode(8, null, null), null)
        );

        System.out.println(isTreeEquals(treeNode1, treeNode2));
        System.out.println(isTreeEquals(treeNode3, treeNode4));
    }

    private static boolean isTreeEquals(TreeNode treeNode1, TreeNode treeNode2) {
        if(null == treeNode1 && null == treeNode2) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode1);
        stack.add(treeNode2);
        while(!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if(t1 != null && t2 != null && t1.val == t2.val) {
                stack.add(t1.left);
                stack.add(t2.left);
                stack.add(t1.right);
                stack.add(t2.right);
            } else if(t1 == null && t2 == null) {
                //
            } else {
                return false;
            }
        }
        return true;
    }
}
