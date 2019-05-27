package interviewExp;

import Util.TreeNode;

import java.util.LinkedList;

/**
 * Created by alina on 11.05.19.
 */
public class TreeSpiralTraversal {
    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n7, n6);
        TreeNode n3 = new TreeNode(3, n5, n4);
        TreeNode n1 = new TreeNode(1, n2, n3);
        printTree(n1);
    }

    private static void printTree(TreeNode tree) {
        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();
        left.add(tree);
        System.out.print(tree.data + " ");
        while (!left.isEmpty() || !right.isEmpty()) {
            while (!right.isEmpty()) {
                TreeNode node = right.pollLast();
                if (node.right != null) {
                    System.out.print(node.right.data + " ");
                    right.add(node.right);
                }
                if (node.left != null) {
                    System.out.print(node.left.data + " ");
                    right.add(node.left);
                }
            }
            while (!left.isEmpty()) {
                TreeNode node = left.pollFirst();
                if (node.left != null) {
                    System.out.print(node.left.data + " ");
                    right.add(node.left);
                }
                if (node.right != null) {
                    System.out.print(node.right.data + " ");
                    right.add(node.right);
                }
            }
        }
    }
}
