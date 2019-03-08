package preparation.week1;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */

public class Day2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] res = multiple(a);
        for (int i : res) System.out.print(i + " ");
    }

    public static int[] multiple(int[] numbers) {
        if(numbers.length < 2) return (new int[0]);
        int[] forw = new int[numbers.length];
        int[] backw = new int[numbers.length];
        forw[0] = numbers[0];
        for (int i = 1; i < numbers.length - 1; i++) {
            forw[i] = forw[i - 1] * numbers[i];
        }
        backw[numbers.length - 1] = numbers[numbers.length - 1];
        for (int i = numbers.length - 2; i > 0; i--) {
            backw[i] = backw[i + 1] * numbers[i];
        }
        int[] res = new int[numbers.length];
        for (int i = 0; i< numbers.length - 2; i++) {
            res[i + 1] = forw[i] * backw[i + 2];
        }
        res[0] = backw[1];
        res[numbers.length -1] = forw[numbers.length - 2];
        return res;
    }
}
