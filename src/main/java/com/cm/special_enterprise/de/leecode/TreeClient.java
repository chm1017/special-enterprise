package com.cm.special_enterprise.de.leecode;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class TreeClient {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        System.out.println(preorderTraversal(root));
        System.out.println(maxTree(root));
        ArrayList<ArrayList<Integer>> arrayLists = sequenceTraversal(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                list.add(integer);
            }
        }
        System.out.println(list);
        int[] a = new int[]{1,5,8};
        int[] b = new int[]{2, 4, 6};
        System.out.println(packArray(a, 3, b, 3));


    }

    private static ArrayList<Integer> preList = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preList.add(root.val);
        }
        if (root.left != null) {
            preorderTraversal(root.left);
        }

        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return preList;
    }

    public static int maxTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxTree(root.left) + 1, maxTree(root.right )+ 1);
    }



    public static  ArrayList<ArrayList<Integer>> sequenceTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(row);
        }

        return res;
    }

    public static ArrayList<Integer> packArray(int a[], int m, int b[], int n) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                integers.add(a[i]);
                i++;
            } else {
                integers.add(b[j]);
                j++;
            }
        }
        while (i < m) {
            integers.add(a[i]);
            i++;
        }
        while (j < n) {
            integers.add(b[j]);
            j++;
        }
        return integers;
    }


    public class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null) return true;
            //判断左子树和右子树是否符合规则，且深度不能超过2
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(deep(root.left) - deep(root.right)) < 2;
        }
        //判断二叉树深度
        public int deep(TreeNode root) {
            if (root == null) return 0;
            return Math.max(deep(root.left), deep(root.right)) + 1;
        }
        //双栈实现队列
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.size() <= 0) {
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }




}
