package com.arthur.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTest {

    private List<List<Integer>> result = new ArrayList<>();

    @Test
    public void testLevelOrder() {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(15);
        TreeNode node5 = new TreeNode(20);
        node5.left = node6;
        node5.right = node7;
        TreeNode node4 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        node3.left = node4;
        node4.right = node5;
        List<List<Integer>> lists = levelOrder(node3);
        System.out.println(lists);

    }

    public void helper (TreeNode node, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }

        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }


}
