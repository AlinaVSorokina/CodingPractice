package preparation.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */

public class Day1 {
    public static void main(String[] args) {
        int[] a = {10, 15, 3, 7};
        System.out.println(containsSum(a, 17));
    }

    public static boolean containsSum(int[] numbers, int sum) {
        Set<Integer> remains = new HashSet<>();
        for (int num : numbers) {
            if (remains.contains(num)) return true;
            remains.add(sum - num);
        }
        return false;
    }
}
