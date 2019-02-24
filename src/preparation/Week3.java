package preparation;

import Util.ListNode;
import Util.LogStructure;
import org.w3c.dom.NodeList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Week3 {

    public static void main(String[] args) {
        day21run();
    }

    //------------Day 15

    //------------Day 16
    public static void day16() {
        LogStructure ls = new LogStructure(5);
        ls.record(1);
        ls.record(2);
        ls.record(3);
        ls.record(4);
        ls.record(5);
        ls.record(6);
        ls.record(7);
        System.out.println(ls.get(3));
    }
    //------------Day 17


    //------------Day 18 OK

    /**
     * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k
     */
    public static void day18run() {
        int[] a = {10, 5, 2, 7, 8, 7};
        int k = 3;
        day18_1(a, k);
    }

    public static void day18(int[] numbers, int k) {
        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            sorted.put(numbers[i],null);
        }
        System.out.print(sorted.lastKey() + " ");
        for (int i = k; i < numbers.length; i++) {
            sorted.remove(numbers[i - k]);
            sorted.put(numbers[i], null);
            System.out.print(sorted.lastKey() + " ");
        }
    }

    public static void day18_1(int[] numbers, int k) {
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deq.isEmpty() && numbers[deq.peekLast()] < numbers[i])
                deq.pollLast();
            deq.addLast(i);
        }
        System.out.print(numbers[deq.getFirst()] + " ");

        for (int i = k; i < numbers.length; i++) {
            if (!deq.isEmpty() && i - deq.peekFirst() + 1 > k) deq.pollFirst();
            while (!deq.isEmpty() && numbers[deq.peekLast()] < numbers[i])
                deq.pollLast();
            deq.addLast(i);
            System.out.print(numbers[deq.getFirst()] + " ");
        }
    }

    //------------Day 19 OK

    /**
     * A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
     * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.
     */

    public static void day19run() {
        int[][] houses = new int[3][3];
        houses[0][0] = 1;
        houses[0][1] = 2;
        houses[0][2] = 3;

        houses[1][0] = 5;
        houses[1][1] = 4;
        houses[1][2] = 7;

        houses[2][0] = 3;
        houses[2][1] = 3;
        houses[2][2] = 2;

        System.out.print(day19(houses, 3, 3));

    }

    public static int day19(int[][] houses, int n, int k) {
        int lowest = 0;
        int secondLowest = 0;
        int lowestInd = -1;

        for (int i = 0; i < n; i++) {
            int newLowest = Integer.MAX_VALUE;
            int newSecondLowest = Integer.MAX_VALUE;
            int newLowestInd = -1;
            for (int j = 0; j < k; j++) {
                int prevLowest = j == lowestInd ? secondLowest : lowest;
                int cost = prevLowest + houses[i][j];
                if (cost < newLowest) {
                    newSecondLowest = newLowest;
                    newLowest = cost;
                    newLowestInd = j;
                } else if (cost < newSecondLowest) {
                    newSecondLowest = cost;
                }
            }
            lowest = newLowest;
            lowestInd = newLowestInd;
            secondLowest = newSecondLowest;
        }
        return lowest;

    }

    //------------Day 20 OK
    /**For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
    * In this example, assume nodes with the same value are the exact same node objects.
    * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
    */

    public static void day20run() {

    }

    public static ListNode getCommonPoint(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        int firstLength = 1;
        ListNode head1 = list1;
        while (head1.next != null) {
            firstLength++;
            head1 = head1.next;
        }
        int secondLength = 1;
        ListNode head2 = list2;
        while (head2.next != null) {
            secondLength++;
            head2 = head2.next;
        }
        head1 = list1;
        head2 = list2;
        if (secondLength > firstLength) {
            int diff = secondLength - firstLength;
            for (int i = diff; i > 0; i--) {
                head2 = head2.next;
            }
        }
        if (secondLength < firstLength) {
            int diff = firstLength - secondLength;
            for (int i = diff; i > 0; i--) {
                head1 = head1.next;
            }
        }
        while (head1 != null) {
            if (head1.next == head2.next) return head1.next;
        }
        return null;
    }

    //------------Day 21

    /**
     * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
     * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
     */

    public static void day21run() {
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
