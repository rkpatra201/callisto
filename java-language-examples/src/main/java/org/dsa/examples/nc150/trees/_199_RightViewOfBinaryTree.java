package org.dsa.examples.nc150.trees; /**
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
 import java.util.*;
class _199_RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
           int count = q.size();

           TreeNode last = null;

           for(int i = 0; i< count; i++){
             last = q.poll();
             if(last.left!=null){
                q.add(last.left);
             }
             if(last.right!=null){
                q.add(last.right);
             }
           }
           result.add(last.val); 
        }

        return result;
    }
}