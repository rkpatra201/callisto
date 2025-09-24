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
class _230_KthSmallestInBst {
    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        dfs(root,k);
        return result;
    }

    private int pos = 1; // k value starts from 1
    private int result = -1;
    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }


        dfs(root.left,k);

        // k matches pos and result is not set
        // result should be set only once
        if(k == pos && result == -1){
            result = root.val;
            System.out.println(result);
            return;
        }
        pos++; // increment position as we consumed one element

        dfs(root.right,k);



        // return result;

    }
}