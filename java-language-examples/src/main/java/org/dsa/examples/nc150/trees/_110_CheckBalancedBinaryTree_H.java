package org.dsa.examples.nc150.trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class _110_CheckBalancedBinaryTree_H {

    private boolean result = true;
    private boolean checkBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int h = height(root.right);

        int absoluteDiff = Math.abs(l - h);
        // if the absolute difference is more than 1, then it's not balanced
        // balanced tree means the height of two subtrees of any node never differ by more than one

        if (checkBalanced && absoluteDiff <= 1) {
            result = true;
        } else {
            // not balanced because the difference is more than 1
            checkBalanced = false;
            result = false;
        }

        return Math.max(l, h) + 1; // return the height of the tree
    }
}