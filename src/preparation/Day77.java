package preparation;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alina on 21.04.19.
 */
public class Day77 {
    public static void main(String[] args) {
        List<Pair> ps = new ArrayList<>();
        Pair p1 = new Pair();
        p1.a = 1;
        p1.b = 3;
        Pair p2 = new Pair();
        p2.a = 5;
        p2.b = 7;
        Pair p3 = new Pair();
        p3.a = 6;
        p3.b = 8;
        Pair p4 = new Pair();
        p4.a = 2;
        p4.b = 4;
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        List<Pair> res = merge(ps);

        System.out.print(ps);

    }

    private static List<Pair> merge(List<Pair> in) {
        if (in.size() < 2) return in;
        List<Pair> out = new ArrayList<>();
        Collections.sort(in);
        int index = 1;
        Pair cp = in.get(0);
        while (index < in.size()) {
            Pair second = in.get(index);
            if (second.a <= cp.b) {
                cp.b = second.b;
                index++;
            } else {
                out.add(cp);
                cp = second;
                index++;
            }
        }
        out.add(cp);
        return out;
    }

    private static class Pair implements Comparable<Pair> {
        int a;
        int b;

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(a, o.a);
        }
    }


}
