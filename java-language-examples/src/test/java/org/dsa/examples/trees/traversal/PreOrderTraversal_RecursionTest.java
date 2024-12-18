package org.dsa.examples.trees.traversal;

import org.dsa.examples.trees.traversal.dfs.PreOrderTraversal_Recursion;
import org.junit.Test;

import java.util.List;

public class PreOrderTraversal_RecursionTest {

    @Test
    public void traverse() {
        TreeNode root = TreeUtils.getTree();
        PreOrderTraversal_Recursion helper = new PreOrderTraversal_Recursion();
        List<Integer> result = helper.traverse(root);
        System.out.println(result);
    }
}