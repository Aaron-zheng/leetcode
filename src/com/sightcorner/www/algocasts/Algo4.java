package com.sightcorner.www.algocasts;


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
public class Algo4 {

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
     *     1
         /   \
         2     2
         / \   / \
         4   8 8   4
     */

    /**
     * 这个题目说的是，给你一个二叉树，你要判断它是否沿中轴线对称。
     *
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
                new TreeNode(2, new TreeNode(8, null, null), null)
        );

        System.out.println(isSymmetry(treeNode1));
        System.out.println(isSymmetry(treeNode2));
    }

    private static boolean isSymmetry(TreeNode treeNode) {
        if(null == treeNode) return true;
        return isSymmetry(treeNode.left, treeNode.right);
    }

    private static boolean isSymmetry(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        if(left.val != right.val) return false;
        return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
    }
}
