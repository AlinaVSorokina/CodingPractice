package preparation;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 27.05.19.
 */
public class Day110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        List<Integer> start = new ArrayList<Integer>();
        start.add(root.data);

        List<List<Integer>> paths = getPaths(root, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
        System.out.print("");

    }

    public static List<List<Integer>> getPaths(TreeNode root, List<List<Integer>> paths, List<Integer> path) {

        if (root == null) {
            return paths;
        }
        path.add(root.data);
        paths.add(path);

        if (root.left != null) {
            List<Integer> leftPath = new ArrayList<>();
            leftPath.addAll(path);
            getPaths(root.left, paths, leftPath);
        }
        if (root.right != null) {
            List<Integer> rightPath = new ArrayList<>();
            rightPath.addAll(path);
            getPaths(root.right, paths, rightPath);
        }

        return paths;

    }
}
