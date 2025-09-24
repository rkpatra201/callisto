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
class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        // TreeNode l = root.left;
        // TreeNode r = root.right;

        // TreeNode t = l;
        // l = r;
        // r = t;

         TreeNode temp = root.left;  // swap with root intact
      root.left = root.right;
      root.right = temp;
      
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}