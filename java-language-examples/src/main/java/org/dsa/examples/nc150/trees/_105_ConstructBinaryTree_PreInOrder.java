package org.dsa.examples.nc150.trees;

import java.util.*;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; } // Constructor for the TreeNode class
// }

public class _105_ConstructBinaryTree_PreInOrder {
    private int preIndex = 0; // To keep track of the current index in the preorder traversal
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>(); // Map to quickly get the index of an element in inorder

    // Main function that is used to construct the binary tree from preorder and inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map of value to its index for quick look-up in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1); // Start the tree construction
    }

    // Recursive function to construct the tree
    private TreeNode constructTree(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null; // Base condition

        // Create the root node
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // If the tree has only one node
        if (inStart == inEnd) return root;

        // Divide the inorder list into two halves and recursively build each half
        int inIndex = inorderIndexMap.get(root.val);
        root.left = constructTree(preorder, inStart, inIndex - 1);
        root.right = constructTree(preorder, inIndex + 1, inEnd);

        return root;
    }

    // Function to print the tree in level-order traversal without trailing nulls
    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of elements at the current level
            boolean isLastLevel = true;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (curr != null) {
                    // Print the value of the current node
                    System.out.print(curr.val + " ");
                    queue.add(curr.left);
                    queue.add(curr.right);
                    // If any of the children is not null, this is not the last level
                    if (curr.left != null || curr.right != null) {
                        isLastLevel = false;
                    }
                } else {
                    System.out.print("null ");
                }
            }
            // After finishing a level, if it's the last level, break out of the loop
            if (isLastLevel) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTree_PreInOrder sol = new _105_ConstructBinaryTree_PreInOrder();
        TreeNode root = sol.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        printTree(root); // Expected output: 3 9 20 null null 15 7
    }
}
