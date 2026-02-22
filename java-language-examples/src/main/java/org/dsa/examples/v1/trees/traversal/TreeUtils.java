package org.dsa.examples.v1.trees.traversal;

public class TreeUtils {


  /**
   * <pre>
   *                            40
   *                    20             60
   *               10       30     50      80
   * </pre>
   */
  public static TreeNode getTree() {
    TreeNode treeNode1 = new TreeNode(40);
    TreeNode treeNode2 = new TreeNode(20);
    TreeNode treeNode3 = new TreeNode(60);
    TreeNode treeNode4 = new TreeNode(10);
    TreeNode treeNode5 = new TreeNode(30);
    TreeNode treeNode6 = new TreeNode(50);
    TreeNode treeNode7 = new TreeNode(80);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;

    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;

    treeNode3.left = treeNode6;
    treeNode3.right = treeNode7;

    return treeNode1;
  }

  /**
   *  h = 0, for single node
   *  h = -1 when node is null
   *
   *  h is number of edges from root to farther leaf node
   * @param root
   * @return
   */
  public int height(TreeNode root) {
    if (root == null)
      return -1; // ( we should not return 0 here, to adhere number of nodes = 2^(h+1) -1 )

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;

  }
}
