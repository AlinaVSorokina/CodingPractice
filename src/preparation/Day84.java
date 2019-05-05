package preparation;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day84 {
    public static void main(String[] args) {

        int[][] arr = new int[6][5];
        int[] a1 = {0, 0, 0, 0, 0};
        int[] a2 = {0, 0, 1, 1, 0};
        int[] a3 = {0, 1, 1, 0, 0};
        int[] a4 = {0, 0, 0, 0, 0};
        int[] a5 = {1, 1, 0, 0, 1};
        int[] a6 = {1, 1, 0, 0, 1};
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        arr[3] = a4;
        arr[4] = a5;
        arr[5] = a6;


        System.out.println(count(arr, 6, 5));
    }

    private static int count(int[][] field, int n, int m) {

        int count = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> point = queue.poll();
                        if (field[point.getKey()][point.getValue()] == 1) {
                            queue.addAll(getNeighbours(point.getKey(), point.getValue(), n, m));
                            field[point.getKey()][point.getValue()] = 2;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static List<Pair<Integer, Integer>> getNeighbours(int x, int y, int n, int m) {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        if (in(x - 1, 0, n - 1)) res.add(new Pair<>(x - 1, y));
        if (in(x + 1, 0, n - 1)) res.add(new Pair<>(x + 1, y));
        if (in(y - 1, 0, m - 1)) res.add(new Pair<>(x, y - 1));
        if (in(y + 1, 0, m - 1)) res.add(new Pair<>(x, y + 1));
        if (in(x - 1, 0, n - 1) && in(y - 1, 0, m - 1)) res.add(new Pair<>(x - 1, y - 1));
        if (in(x - 1, 0, n - 1) && in(y + 1, 0, m - 1)) res.add(new Pair<>(x - 1, y + 1));
        if (in(x + 1, 0, n - 1) && in(y - 1, 0, m - 1)) res.add(new Pair<>(x + 1, y - 1));
        if (in(x + 1, 0, n - 1) && in(y + 1, 0, m - 1)) res.add(new Pair<>(x + 1, y + 1));
        return res;
    }

    private static boolean in (int num, int left, int right) {
        return num >= left && num <= right;
    }
}
