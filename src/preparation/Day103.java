package preparation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alina on 16.05.19.
 */
public class Day103 {

    public static void main(String[] args) {

        String st = "figehaeci";
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        System.out.print(findSubstring(st, set));

    }

    public static String findSubstring(String line, Set<Character> letters) {
        Map<Character, Integer> toCheck = new HashMap<>();
        letters.forEach(let -> toCheck.put(let, 0));

        int start = -1;
        char[] abc = line.toCharArray();
        for (int i = 0; i < abc.length; i++) {
            if (toCheck.containsKey(abc[i])){
                toCheck.put(abc[i], i);
                if (start == -1) start = 1;
            }
        }

        if (start == -1) return null;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer v : toCheck.values()) {
            if (v > max) max = v;
            if (v < min) min = v;
        }

        if (min == 0) return null;

        return line.substring(start, max);

    }
}
