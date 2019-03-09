package preparation.week5;

import java.util.*;

public class Day34 {

    public static void main(String[] args) {
        String res = getShortestPalindrome("abgltt");
        System.out.println(res);
    }

    public static String getShortestPalindrome(String s) {
        TreeSet<String> polis = new TreeSet<>();
        Queue<ArrayList<Character>> queue = new LinkedList<>();
        ArrayList<Character> word = new ArrayList<>();
        for (char c : s.toCharArray()) {
            word.add(c);
        }
        queue.add(word);
        int minSteps = 0;
        while (!queue.isEmpty()) {
            ArrayList<Character> line = queue.poll();
            if (minSteps == 0 || line.size() <= s.length() + minSteps) {
                int start = 0;
                int finish = line.size() - 1;
                boolean needNext = true;
                while (needNext) {
                    if (start > finish) {
                        minSteps = line.size() - s.length();
                        StringBuilder str = new StringBuilder();
                        line.forEach(let -> str.append(let));
                        polis.add(str.toString());
                        needNext = false;
                    } else if (line.get(start).equals(line.get(finish))) {
                        start++;
                        finish--;
                    } else {
                        int first = start;
                        int last = finish == line.size() - 1 ? line.size() : finish + 1;
                        ArrayList<Character> line1 = new ArrayList<>(line);
                        line1.add(first, line.get(finish));
                        ArrayList<Character> line2 = new ArrayList<>(line);
                        line2.add(last, line.get(start));
                        queue.add(line1);
                        queue.add(line2);
                        needNext = false;
                    }
                }
            } else {
                queue.clear();
            }
        }
        return polis.first();
     }
}
