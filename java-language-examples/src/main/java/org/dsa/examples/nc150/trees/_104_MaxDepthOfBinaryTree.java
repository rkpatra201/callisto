package org.dsa.examples.nc150.trees; /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import java.util.*;

class _104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();

        int count = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            count++; // increment depth for each level

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    continue;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

        }

        return count;
    }
}