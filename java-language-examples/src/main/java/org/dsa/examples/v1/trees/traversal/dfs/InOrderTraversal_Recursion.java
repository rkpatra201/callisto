package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal_Recursion {

    public List<Integer> traverse(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        _traverse(treeNode, list);
        return list;
    }

    private void _traverse(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null)
            return;
        _traverse(treeNode.left, list);
        list.add(treeNode.data);
        _traverse(treeNode.right, list);
    }
}
