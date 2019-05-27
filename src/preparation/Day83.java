package preparation;

import Util.TreeNode;

/**
 * Created by alina on 05.05.19.
 */
public class Day83 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3, n1, n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5, n4, null);
        TreeNode n6 = new TreeNode(6, n3, n5);

        TreeNode rev = turn(n6);
        System.out.println("");

    }

    private static TreeNode turn(TreeNode head) {
        if (head == null) return  head;

        TreeNode left = turn(head.right);
        TreeNode right = turn(head.left);

        head.left = left;
        head.right = right;

        return head;
    }
}
