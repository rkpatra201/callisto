package org.dsa.examples.trees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_Queue {

    public List<Integer> traverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek();

            list.add(temp.data);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);

            queue.poll();
        }
        return list;
    }
}
