package preparation;

import Util.LogStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Week3 {

    public static void main(String[] args) {
        day18run();
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

    //------------Day 18
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

    //------------Day 19

    //------------Day 20

    //------------Day 21



}
