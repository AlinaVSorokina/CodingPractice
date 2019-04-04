package preparation;

import java.util.TreeMap;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class Day21 {
    public static void main(String[] args) {
        int[][] times = new int[3][2];
        times[0][0] = 30;
        times[0][1] = 75;

        times[1][0] = 0;
        times[1][1] = 50;

        times[2][0] = 60;
        times[2][1] = 150;

        System.out.println(day21(times));
    }

    public static int day21(int[][] intervals) {
        TreeMap<Integer, Integer> times = new TreeMap<>();
        int max = 0;
        for (int[] pair : intervals) {
            times.computeIfPresent(pair[0], (k, v) -> v + 1);
            times.computeIfAbsent(pair[0], (v) -> 1);
            times.computeIfPresent(pair[1], (k, v) -> v - 1);
            times.computeIfAbsent(pair[1], (v) -> -1);
        }
        int sum = 0;
        for (Integer key : times.keySet()) {
            sum += times.get(key);
            if (sum > max) max = sum;
        }
        return max;
    }
}
