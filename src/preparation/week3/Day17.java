package preparation.week3;

import Util.Dir;

import java.util.HashMap;
import java.util.Map;

public class Day17 {
    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(day17(s));
        //todo not finished
    }

    public static String day17(String s) {
        String[] elems = s.split("\n");
        Dir head = null;
        Map<Integer, Dir> last = new HashMap<>();
        for (String sub : elems ) {
            String[] ind = sub.split("\t");
            int indentation = ind.length - 1;
            String name = ind[indentation];
            if (indentation == 0) {
                head = new Dir();
                head.name = name;
                last.put(0, head);
            } else {
                Dir node = new Dir();
                node.name = name;
                last.get(indentation - 1).children.add(node);
                last.put(indentation, node);
            }
        }
        getLongest(head);
        return "";
    }

    public static String getLongest(Dir head) {
        if (head == null) return ";";
        String path = head.name;
        if (head.children.size() == 0) return path;
        for (Dir ch : head.children){
            if (ch.name.contains(".")) {
                path = path + ch.name;
            } else {
                path = path + ch.name + getLongest(ch);
            }
        }
        return path;
    }
}
