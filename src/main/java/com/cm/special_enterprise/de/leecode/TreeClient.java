package com.cm.special_enterprise.de.leecode;

import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class TreeClient {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        System.out.println(preorderTraversal(root));
        System.out.println(maxTree(root));
        ArrayList<ArrayList<Integer>> arrayLists = sequenceTraversal(root);
        System.out.println(cbt(root)+"CBT");
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
    private static ArrayList<Integer> inorderList = new ArrayList<>();

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

    public static List<Integer> inorderTranversal(TreeNode root) {
        if (root.left != null) {
            inorderTranversal(root.left);
        }
        if (root != null) {
            inorderList.add(root.val);
        }
        if (root.right != null) {
            inorderTranversal(root.right);
        }
        return inorderList;
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

    //是否为对称树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isEqual(root.left, root.right);
    }
    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
        if (left.val!= right.val) return false;
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    //是否为平衡二叉树
    public boolean isBalenceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalenceTree(root.left) && isBalenceTree(root.right) && Math.abs(maxTree(root.left) - maxTree(root.right))<2;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        findPath(root, p, path1);
        findPath(root, q, path2);
        return getLastCom(path1, path2);
    }

    //寻找指定节点到root的路径，保留在stack中
    public boolean findPath(TreeNode root, TreeNode node, Stack<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.push(root);
        if (root == node) {
            return true;
        }
        if (findPath(root.left, node, path)) {
            return true;
        }
        if (findPath(root.right, node, path)) {
            return true;
        }
        path.pop();

        return false;
    }

    //找到两个路径中第一个相等的节点
    public TreeNode getLastCom(Stack<TreeNode> pathLeft, Stack<TreeNode> pathRight) {
        while (pathLeft.size() != pathRight.size()) {
            if (pathLeft.size() > pathRight.size()) {
                pathLeft.pop();
            } else {
                pathRight.pop();
            }
        }
        while (!pathRight.isEmpty()) {
            TreeNode popleft = pathLeft.pop();
            TreeNode popRight = pathRight.pop();
            if (popleft == popRight) return popleft;
        }
        return null;
    }

    public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        findPathTest(root, p, path1);
        findPathTest(root, q, path2);
        return getCom(path1, path2);
    }

    public boolean findPathTest(TreeNode root, TreeNode node, Stack<TreeNode> path) {
        if (root == null){ return false;}

        path.push(root);
        if (root == node){ return true;}

        if (findPath(root.left, node, path)) {
            return true;
        }
        if (findPath(root.right, node, path)) {
            return true;
        }
        path.pop();
        return false;
    }

    public TreeNode getCom(Stack<TreeNode> pathLeft, Stack<TreeNode> pathRight) {
        while (pathLeft.size() != pathRight.size()) {
            if (pathLeft.size() > pathRight.size()) {
                pathLeft.pop();
            } else {
                pathRight.pop();
            }
        }
        while (!pathLeft.isEmpty()) {
            TreeNode popLeft = pathLeft.pop();
            TreeNode popRight = pathRight.pop();
            if (popLeft == popRight) {
                return popLeft;
            }
        }
        return null;
    }




    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int treeHeight = height(root, 1);
        return count(root, treeHeight, 1);
    }

    /**
     * @param treeHeight 原始树的高度
     * @param cur        当前节点在第几层
     */
    public int count(TreeNode root, int treeHeight, int cur) {
        if (cur == treeHeight) {
            return 1;
        }
        int right = height(root.right, cur + 1);
        if (right == treeHeight) { //右节点的最左能到底，说明左子树是满的
            return (1 << (treeHeight - cur)) + count(root.right, treeHeight, cur + 1);
        } else { //不然右子树是满的
            return (1 << (treeHeight - cur - 1)) + count(root.left, treeHeight, cur + 1);
        }

    }

    //cur表示当前节点在第几层
    public int height(TreeNode root, int cur) {
        while (root != null) {
            cur++;
            root = root.left;
        }
        return cur - 1;
    }

    public int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            for (int j = 0; j < deque.size(); j++) {
                TreeNode popNode = deque.pop();
                i++;
                if (popNode.left != null) {
                    deque.push(popNode.left);
                }
                if (popNode.right != null) {
                    deque.push(popNode.right);
                }
            }
        }
        return i;
    }

    //判断是否是完全二叉树
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leafStart = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left == null && right != null) {//不符合条件，直接返回false
                return false;
            }
            if (leafStart && (left != null || right != null)) {//开始都是叶子节点了
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if ((left != null && right == null) || (left == null && right == null)) {//开始都是叶子节点了
                leafStart = true;
            }
        }
        return true;
    }
    public static boolean  cbt(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leafStart = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left == null && right != null) {
                return false;
            }
            if (leafStart && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if ((left != null && right == null) || (left == null && right == null)) {
                leafStart = true;
            }
        }
        return true;
    }


    public boolean hasPathSum (TreeNode root, int sum) {
        //空节点找不到路径
        if(root == null)
            return false;
        //叶子节点，且路径和为sum
        if(root.left == null && root.right == null && sum - root.val == 0)
            return true;
        //递归进入子节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null & sum - root.val == 0) {
            return true;
        }
        return hasPath(root.right, sum - root.val) || hasPath(root.right, sum - root.val);
    }



}
