package preparation;

import Util.TreeNode;

public class Day89 {
    /*
        Determine whether a tree is a valid binary search tree
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4, n2, n5);

        System.out.println(isBinarySearch(n4, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private static boolean isBinarySearch(TreeNode tree, int left, int right) {
        if (tree == null) return  true;

        if (tree.data > left && right >= tree.data) {
            boolean leftT = isBinarySearch(tree.left, left, tree.data);
            boolean rightT = isBinarySearch(tree.right, tree.data, right);
            return leftT && rightT;
        } else {
            return false;
        }
    }
}
