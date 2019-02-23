package preparation;

import Util.ListNode;
import Util.LogStructure;
import org.w3c.dom.NodeList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Week3 {

    public static void main(String[] args) {
        day19run();
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



}
