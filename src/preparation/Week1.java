package preparation;

import Util.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Week1 {

    public static void main(String[] args) {

        day2run();

//        int[] a = {-6, 23, 15, -7, 0};
//        int sum = 17;
//
//        System.out.println(containsSun(a, sum));

//        int[] a = {4, 5};
//        int[] res = multiple(a);
//        System.out.println();

//        TreeNode t1 = new TreeNode();
//        t1.data = 1;
//        TreeNode t3 = new TreeNode();
//        t3.data = 3;
//        TreeNode t4 = new TreeNode();
//        t4.data = 4;
//        TreeNode t5 = new TreeNode();
//        t5.data = 5;
//        TreeNode t6 = new TreeNode();
//        t6.data = 6;
//        TreeNode t7 = new TreeNode();
//        t7.data = 7;
//        TreeNode t9 = new TreeNode();
//        t9.data = 9;
//        TreeNode t0 = new TreeNode();
//        t0.data = 0;
//        t6.left = t9;
//        t6.right = t4;
//        t9.left = t5;
//        t9.right = t1;
//        t5.right = t0;
//        t4.right = t3;
//        t3.left = t7;

//        String tl = serializeTree(t6);
//        TreeNode root = deserializeTree(tl);
//        System.out.println(tl);

//        System.out.println(countEncodings("623"));

    }

    public static int countEncodings(String message) {
        if (message.length() == 0) return 0;
        if (message.length() == 1) return 1;
        char[] chrs = message.toCharArray();
        int counter = 1;

        for (int i = 1;  i < message.length(); i++) {
            int d = Character.getNumericValue(chrs[i-1]);
            int e = Character.getNumericValue(chrs[i]);
            int last = d * 10 + e;
            if (last < 27) counter++;
        }
        return counter;
    }

//------------Day 1 OK
    public static boolean containsSum(int[] numbers, int sum) {
        Set<Integer> remains = new HashSet<>();
        for (int num : numbers) {
            if (remains.contains(num)) return true;
            remains.add(sum - num);
        }
        return false;
    }

//------------Day 2 OK
    /**
     * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
     For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     Follow-up: what if you can't use division?
     */

    public static void day2run() {
        int[] a = {1, 2, 3, 4, 5};
        int[] res = multiple(a);
        for (int i : res) System.out.print(i + " ");
    }

    public static int[] multiple(int[] numbers) {
        if(numbers.length < 2) return (new int[0]);
        int[] forw = new int[numbers.length];
        int[] backw = new int[numbers.length];
        forw[0] = numbers[0];
        for (int i = 1; i < numbers.length - 1; i++) {
            forw[i] = forw[i - 1] * numbers[i];
        }
        backw[numbers.length - 1] = numbers[numbers.length - 1];
        for (int i = numbers.length - 2; i > 0; i--) {
            backw[i] = backw[i + 1] * numbers[i];
        }
        int[] res = new int[numbers.length];
        for (int i = 0; i< numbers.length - 2; i++) {
            res[i + 1] = forw[i] * backw[i + 2];
        }
        res[0] = backw[1];
        res[numbers.length -1] = forw[numbers.length - 2];
        return res;
    }

//------------Day 3 reimplement
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

    //------------Day 4

    //------------Day 5

    //------------Day 6

    //------------Day 7

}
