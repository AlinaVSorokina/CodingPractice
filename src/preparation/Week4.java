package preparation;

import javafx.util.Pair;

import javax.print.DocFlavor;
import java.util.*;

public class Week4 {

    public static void main(String[] args) {

        day23run();

    }

    //------------Day 22

    /**
     * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
     * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
     * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
     * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
     */

    public static void day22run(){
        String[] dic1 = {"the", "quick", "brown", "fox"};
        String[] dic2 = {"bed", "bath", "bedbath", "and", "beyond"};
        String str1 = "thequickbrownfox";
        List<List<String>> res1 = day22(dic1, str1);
        System.out.println("");

    }

    public static List<List<String>> day22(String[] dic, String line){
        TreeSet<String> dictionary = new TreeSet<>();
        for (String str : dic) dictionary.add(str);
        Queue<Pair<Integer,List<String>>> workQueue = new LinkedList<>();
        List<List<String>> results = new ArrayList<>();
        char[] letters = line.toCharArray();
        Pair<Integer, List<String>> pair = new Pair<>(0, new ArrayList<>());
        workQueue.add(pair);
        while (!workQueue.isEmpty()) {
            Pair<Integer, List<String>> current = workQueue.poll();
            if (current.getKey() >= line.length()) {
                results.add(current.getValue());
            }
            List<String> nextWords = getNextWords(letters, current.getKey(), dictionary);
            for (String word : nextWords) {
                if (line.substring(current.getKey()).startsWith(word)) {
                    List<String> newStr = new ArrayList<>();
                    newStr.addAll(current.getValue());
                    newStr.add(word);
                    workQueue.add(new Pair<>(current.getKey() + word.length(), newStr));
                }
            }
        }
        return results;
    }

    public static List<String> getNextWords(char[] letters, int index, TreeSet<String> dictionary) {
        StringBuilder word = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (int i = index; i < letters.length; i++) {
            word.append(letters[i]);
            if (dictionary.contains(word.toString())) {
                NavigableSet<String> ns = dictionary.tailSet(word.toString(), true);
                String w = null;
                while (!ns.isEmpty() && (w = ns.pollFirst()).contains(word.toString())){
                    words.add(w);
                }
                return words;
            }
        }
        return words;
    }


    //------------Day 22

    /**
     * Given this matrix, a start coordinate, and an end coordinate,
     * return the minimum number of steps required to reach the end coordinate from the start.
     * If there is no possible path, then return null. You can move up, left, down, and right.
     * You cannot move through walls. You cannot wrap around the edges of the board.
     *
     */

    public static void day23run(){
        boolean[][] labyrinth = new boolean[4][4];

        labyrinth[0][0] = false;
        labyrinth[0][1] = false;
        labyrinth[0][2] = false;
        labyrinth[0][3] = false;

        labyrinth[1][0] = true;
        labyrinth[1][1] = true;
        labyrinth[1][2] = false;
        labyrinth[1][3] = true;

        labyrinth[2][0] = false;
        labyrinth[2][1] = false;
        labyrinth[2][2] = false;
        labyrinth[2][3] = false;

        labyrinth[3][0] = false;
        labyrinth[3][1] = false;
        labyrinth[3][2] = false;
        labyrinth[3][3] = false;

        Point start = new Point();
        start.x = 3;
        start.y = 0;

        Point end = new Point();
        end.x = 0;
        end.y = 0;

        day23(labyrinth, start, end);
    }

    public static int day23(boolean[][] labyrinth, Point start, Point end){
        Queue<Point> pointQueue = new LinkedList<>();
        start.step = 0;
        pointQueue.add(start);
        int endStep = -1;
        while (!pointQueue.isEmpty() && endStep < 0) {
            Point current = pointQueue.poll();
            if (current.equals(end)) endStep = current.step;
                List<Point> next = getNext(current, labyrinth, current.step);
                for (Point p : next) {
                    pointQueue.add(p);
                }
            labyrinth[current.x][current.y] = true;
        }
        return endStep;
    }

    public static List<Point> getNext(Point point, boolean[][] labyrinth, int step) {
        step++;
        int n = labyrinth.length;
        int m = labyrinth[0].length;
        List<Point> points = new ArrayList<>();

        int x = point.x - 1;
        int y = point.y;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x + 1;
        y = point.y;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x;
        y = point.y - 1;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x;
        y = point.y + 1;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        return points;
    }

    private static class Point {
        int x;
        int y;
        int step;

        boolean equals(Point p) {
            if (x == p.x && y == p.y) return true;
            return false;
        }

    }
 }
