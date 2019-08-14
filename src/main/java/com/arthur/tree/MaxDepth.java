package com.arthur.tree;

import org.junit.Test;

public class MaxDepth {

    @Test
    public void testMaxDepth() {
        TreeNode node5 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20);
        node3.left = node5;
        node3.right = node4;
        TreeNode node2 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = node2;
        root.right = node3;

        int depth = maxDepth(root);
        System.out.println(depth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = Math.max(left, right);
        return ++depth;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

