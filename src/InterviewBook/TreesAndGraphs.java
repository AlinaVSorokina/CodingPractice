package InterviewBook;

import Util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreesAndGraphs {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        t1.data = 1;
        TreeNode t2 = new TreeNode();
        t2.data = 2;
        TreeNode t3 = new TreeNode();
        t3.data = 3;
        TreeNode t4 = new TreeNode();
        t4.data = 4;
        TreeNode t5 = new TreeNode();
        t5.data = 5;
        TreeNode t6 = new TreeNode();
        t6.data = 6;
        TreeNode t7 = new TreeNode();
        t7.data = 7;
        TreeNode t8 = new TreeNode();
        t8.data = 8;
        t5.left = t3;
        t5.right = t7;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;
        t7.left = t6;
        t7.right = t8;


//        System.out.println(task1(null));
//        int[] arr = {};
//        TreeNode tr = task3(arr);
//        System.out.println();

//        List<List<TreeNode>> tres = task4(t1);
//        System.out.println();

        System.out.println(task5(t5));

    }

    private static boolean task1(TreeNode tree) {
        if (tree == null) return true;
        if (Math.abs(depth(tree.left) - depth(tree.right)) <= 1) return true;
        return false;
    }

    private static int depth(TreeNode tree) {
        if (tree == null) return 0;
        return Math.max(depth(tree.left), depth(tree.right)) + 1;
    }

    private static TreeNode task3(int[] arr) {
        if (arr.length == 0) return null;
        if (arr.length == 1) {
            TreeNode node = new TreeNode();
            node.data = arr[0];
            return node;
        }
        int midIndex = arr.length / 2;
        TreeNode root = new TreeNode();
        root.data = arr[midIndex];
        int[] left = new int[midIndex];
        System.arraycopy(arr, 0, left, 0, midIndex);
        root.left = task3(left);
        int rpart = arr.length - (midIndex + 1);
        if (rpart > 0) {
            int[] right = new int[rpart];
            System.arraycopy(arr, midIndex + 1, right, 0, arr.length - (midIndex + 1));
            root.right = task3(right);
        }
        return root;
    }

    private static List<List<TreeNode>> task4(TreeNode root) {
        if (root == null) return null;
        Queue<Wrapper> qu = new LinkedList<>();
        int level = 1;
        Wrapper wr = new Wrapper(root, 1);
        qu.add(wr);
        List<List<TreeNode>> ls = new LinkedList<>();
        List<TreeNode> crls = new LinkedList<>();
        while (qu.size() > 0) {
            Wrapper cr = qu.poll();
            if (cr.level != level) {
                level++;
                ls.add(crls);
                crls = new LinkedList<>();
            }
            crls.add(cr.node);
            if (cr.node.left != null) {
                qu.add(new Wrapper(cr.node.left, level + 1));
            }
            if (cr.node.right != null) {
                qu.add(new Wrapper(cr.node.right, level + 1));
            }
        }
        ls.add(crls);
        return ls;
    }

    private static class Wrapper {
        TreeNode node;
        int level;
        Wrapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static boolean task5(TreeNode root) {
        if (root == null) return true;
        boolean left = true;
        boolean right = true;
        if (root.left != null) left = (root.left.data <= root.data) && task5(root.left);
        if (root.right != null) right = (root.right.data > root.data) && task5(root.right);
        return left && right;
    }
}
