package preparation;

/**
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling
 * that stock once. You must buy before you can sell it.
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars
 * and sell it at 10 dollars.
 */
public class Day47 {
    public static void main(String[] args) {
        int[] in = {9, 11, 8, 5, 7, 10};

        int res = getMax(in);
        System.out.print(res);
    }

    public static int getMax(int[] values) {
        if (values.length < 2) return 0;
        int p1 = 0;
        int p2 = 1;
        int max = Integer.MIN_VALUE;
        while (p2 < values.length) {
            if (values[p1] < values[p2]) {
                max = max >= (values[p2] - values[p1]) ? max : values[p2] - values[p1];
            } else if (values[p1] >= values[p2]) {
                p1 = p2;
            }
            p2++;
        }
        return max;
    }


}
