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
class _100_IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p == null && q == null){
        return true;
       } 
       if(p == null || q == null){
        return false;
       }
       boolean sameValue = p.val == q.val;
       if(sameValue){
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
       }
       return false;
    }
}