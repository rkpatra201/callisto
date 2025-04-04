package org.dsa.examples.v1.trees.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_LevelOrder_Traversal_Queue {

    // print from bottom
    // left to right
    // root will be at last
    public List<Integer> traverse(TreeNode treeNode) {

        List<Integer> result = new ArrayList<>();
        _traverse(treeNode, result);
        Collections.reverse(result);
        return result;
    }

    private static void _traverse(TreeNode treeNode, List<Integer> results) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (treeNode == null)
            return;
        queue.add(treeNode);
        while (true) {
            if (queue.isEmpty())
                break;
            TreeNode current = queue.poll();
            results.add(current.data);
            if (current.right != null)
                queue.add(current.right);
            if (current.left != null)
                queue.add(current.left);

        }
    }
}
