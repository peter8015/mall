package com.macro.mall.algorithm;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BFS {

    @Test
    public void t1() {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);

        BFS(node1);

    }

    @Test
    public void t2() {
        TreeNode node = null;

//        Objects.requireNonNull(node);
        Objects.isNull(node);

        String s = null;

        Strings.isBlank(s);

    }

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static <T> T requireNonNull(T obj) {
        if(obj == null)
            throw new NullPointerException();
        return obj;
    }


    /**
     * BFS
     * @param root
     */
    public void BFS(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }

        Queue<TreeNode> queue = Lists.newLinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(!Objects.isNull(node.left)) {
                queue.add(node.left);
            }
            if(!Objects.isNull(node.right)) {
                queue.add(node.right);
            }
        }
    }
}

/**
 * 二叉树数据结构定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

