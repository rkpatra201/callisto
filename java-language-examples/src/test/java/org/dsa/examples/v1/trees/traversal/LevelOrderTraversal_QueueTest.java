package org.dsa.examples.v1.trees.traversal;

import org.dsa.examples.v1.trees.traversal.LevelOrderTraversal_Queue;
import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
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