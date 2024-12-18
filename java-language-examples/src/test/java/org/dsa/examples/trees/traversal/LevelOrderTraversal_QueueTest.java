package org.dsa.examples.trees.traversal;

import org.junit.Test;

import java.util.List;

public class LevelOrderTraversal_QueueTest {

    @Test
    public void traverse() {
        TreeNode root = TreeUtils.getTree();
        LevelOrderTraversal_Queue helper = new LevelOrderTraversal_Queue();
        List<Integer> list = helper.traverse(root);
        System.out.println(list);

    }
}