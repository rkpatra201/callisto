package org.dsa.examples.trees.traversal;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data +"-"+super.hashCode();
    }
}
