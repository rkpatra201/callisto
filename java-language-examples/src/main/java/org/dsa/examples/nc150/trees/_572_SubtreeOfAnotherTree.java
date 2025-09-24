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
class _572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(subRoot == null) return true; // empty tree is subtree of any tree
      if(root == null) return false; // non-empty tree can't be subtree of empty tree
      
      boolean same = isSameTree(root, subRoot); // for every node in root, check if same as subRoot
      if(same) return true; // once you find a match, return true
      
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

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