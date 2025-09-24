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
class _124_MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     recursive(root);
     return maxSum;
    }

    public int recursive(TreeNode root){
    if(root == null){
        return 0;
      }  

     int l = Math.max(0, recursive(root.left));
     int r = Math.max(0, recursive(root.right));

     maxSum = Math.max(maxSum, l+r+root.val);

     return Math.max(l,r) + root.val;
    }
}