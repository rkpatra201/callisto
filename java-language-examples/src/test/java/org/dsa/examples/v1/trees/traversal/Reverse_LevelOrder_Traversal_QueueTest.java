package org.dsa.examples.v1.trees.traversal;

import org.dsa.examples.v1.trees.traversal.LevelOrderTraversal_Queue;
import org.dsa.examples.v1.trees.traversal.Reverse_LevelOrder_Traversal_Queue;
import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class Reverse_LevelOrder_Traversal_QueueTest {

    @Test
    public void traverse() {
        TreeNode treeNode = TreeUtils.getTree();
        LevelOrderTraversal_Queue l = new LevelOrderTraversal_Queue();
        l.traverse(treeNode).forEach(System.out::println);
        System.out.println("**********************");
        Reverse_LevelOrder_Traversal_Queue r = new Reverse_LevelOrder_Traversal_Queue();
        r.traverse(treeNode).forEach(System.out::println);
    }
}