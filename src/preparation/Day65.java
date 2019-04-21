package preparation;

/**
 * Created by alina on 11.04.19.
 * Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
 */
public class Day65 {

    public static void main(String[] args) {
//        int[][] m = new int[4][5];
        int[][] m = {{1,  2,  3,  4,  5},
                     {6,  7,  8,  9,  10},
                     {11, 12, 13, 14, 15},
                     {16, 17, 18, 19, 20}};

        print(m, 4, 5);

    }

    public static void print(int[][] matrix, int n, int m) {
        int direction = 0;
        int high = n;
        int width = m;
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        while (high + width > 0) {
            switch (direction){
                case 0:
                    x = i;
                    y = j;
                    for (int ind = 0; ind < width; ind++) {
                        System.out.println(matrix[x][y++]);
                    }
                    j = y - 1;
                    i++;
                    high--;
                    direction = 1;
                    break;
                case 1:
                    y = j;
                    for (int ind = 0; ind < high; ind++) {
                        System.out.println(matrix[x++][y]);
                    }
                    i = x - 1;
                    y--;
                    width--;
                    direction = 3;
                    break;
                case 2:
                    x = i;
                    for (int ind = 0; ind < width; ind++) {
                        System.out.println(matrix[x][y--]);
                    }
                    j = y;
                    i++;
                    high--;
                    direction = 1;
                    break;
                case 3:
                    y = j;
                    for (int ind = 0; ind < high; ind++) {
                        System.out.println(matrix[x--][y]);
                    }
                    i = x;
                    y++;
                    width--;
                    direction = 0;
                    break;
            }

        }
    }
}
