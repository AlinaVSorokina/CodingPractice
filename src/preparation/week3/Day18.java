package preparation.week3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *    10 = max(10, 5, 2)
 *    7 = max(5, 2, 7)
 *    8 = max(2, 7, 8)
 *    8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
public class Day18 {
    public static void main(String[] args) {
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
}
