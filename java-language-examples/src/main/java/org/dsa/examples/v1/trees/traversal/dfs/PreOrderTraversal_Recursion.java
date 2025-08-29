package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal_Recursion {
    public List<Integer> traverse(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        _traverse(treeNode, list);
        return list;
    }

    private void _traverse(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null)
            return;
        list.add(treeNode.data);
        _traverse(treeNode.left, list);
        _traverse(treeNode.right, list);
    }
}
