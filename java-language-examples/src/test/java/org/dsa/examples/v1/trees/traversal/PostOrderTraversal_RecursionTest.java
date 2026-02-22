package org.dsa.examples.v1.trees.traversal;

import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.dsa.examples.v1.trees.traversal.dfs.PostOrderTraversal_Recursion;
import org.junit.Test;

import java.util.List;

public class PostOrderTraversal_RecursionTest {

    @Test
    public void traverse() {
        TreeNode root = TreeUtils.getTree();
        PostOrderTraversal_Recursion helper = new PostOrderTraversal_Recursion();
        List<Integer> result = helper.traverse(root);
        System.out.println(result);
    }
}