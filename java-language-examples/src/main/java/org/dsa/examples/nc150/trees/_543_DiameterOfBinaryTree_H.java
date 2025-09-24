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
class _543_DiameterOfBinaryTree_H {

    public int diameterOfBinaryTree(TreeNode root) {
       traverse(root);
       return d;
    }
    
    private int d = 0;
    private int traverse(TreeNode root){
      if(root == null){ // height of null is 0
        return 0;
       }
     
       int l = traverse(root.left);
       int h = traverse(root.right);
       d = Math.max(d, l+h);
       return Math.max(l,h) + 1; // +1 because of root, this is height of tree formula
    }
}