package preparation.week1;

import Util.TreeNode;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */
public class Day3 {
    public static String serializeTree1(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<Pair<String,TreeNode>> nodes = new LinkedList<>();
        nodes.add(new Pair<>("", root));
        while (nodes.size() > 0) {
            Pair<String,TreeNode> node = nodes.poll();
            builder.append(node.getKey()).append(":").append(node.getValue().data).append(";");
            if (node.getValue().left != null) {
                nodes.add(new Pair<>(node.getKey()+"0", node.getValue().left));
            }
            if (node.getValue().right != null) {
                nodes.add(new Pair<>(node.getKey()+"1", node.getValue().right));
            }
        }
        return builder.toString();
    }

    public static TreeNode deserializeTree1(String tree) {
        String[] nodes = tree.split(";");
        Map<String, String> nodeValues = new HashMap<>();
        for (String n : nodes) {
            String[] v = n.split(":");
            nodeValues.put(v[0], v[1]);
        }
        Queue<Pair<String,TreeNode>> nodeQ = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.data = Integer.parseInt(nodeValues.get(""));
        nodeQ.add(new Pair<>("", root));
        while (nodeQ.size() > 0) {
            Pair<String,TreeNode> node = nodeQ.poll();
            String left = node.getKey()+"0";
            String right = node.getKey()+"1";
            if (nodeValues.containsKey(left)) {
                TreeNode nV = new TreeNode();
                nV.data = Integer.parseInt(nodeValues.get(left));
                node.getValue().left = nV;
                nodeQ.add(new Pair<>(left, nV));
            }
            if (nodeValues.containsKey(right)) {
                TreeNode nV = new TreeNode();
                nV.data = Integer.parseInt(nodeValues.get(right));
                node.getValue().right = nV;
                nodeQ.add(new Pair<>(right, nV));
            }
        }

        return root;
    }
    public static String serializeTree(TreeNode root) {
        return writeTree(root,"");
    }

    public static String writeTree(TreeNode node, String str) {
        if (node == null) return str;
        str = str + ";" + node.data;
        str = str + writeTree(node.left, str);
        str = str + writeTree(node.right, str);
        return str;
    }

    public static TreeNode deserializeTree(String tree) {
        String[] nodes = tree.split(";");
        Map<String, String> nodeValues = new HashMap<>();
        for (String n : nodes) {
            String[] v = n.split(":");
            nodeValues.put(v[0], v[1]);
        }
        Queue<Pair<String, TreeNode>> nodeQ = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.data = Integer.parseInt(nodeValues.get(""));
        nodeQ.add(new Pair<>("", root));
        while (nodeQ.size() > 0) {
            Pair<String, TreeNode> node = nodeQ.poll();
            String left = node.getKey() + "0";
            String right = node.getKey() + "1";
            if (nodeValues.containsKey(left)) {
                TreeNode nV = new TreeNode();
                nV.data = Integer.parseInt(nodeValues.get(left));
                node.getValue().left = nV;
                nodeQ.add(new Pair<>(left, nV));
            }
            if (nodeValues.containsKey(right)) {
                TreeNode nV = new TreeNode();
                nV.data = Integer.parseInt(nodeValues.get(right));
                node.getValue().right = nV;
                nodeQ.add(new Pair<>(right, nV));
            }
        }

        return root;
    }
}
