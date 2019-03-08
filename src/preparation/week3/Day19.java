package preparation.week3;

/**
 * A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.
 */
public class Day19 {
    public static void main(String[] args) {
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
}
