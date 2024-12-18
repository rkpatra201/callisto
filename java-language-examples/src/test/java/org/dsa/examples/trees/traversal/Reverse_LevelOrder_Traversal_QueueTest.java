package org.dsa.examples.trees.traversal;

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