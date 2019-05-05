package Util;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int d) {
        this.data = d;
    }

    public TreeNode(int d, TreeNode l, TreeNode r) {
        this.data = d;
        this.left = l;
        this.right = r;
    }
}
