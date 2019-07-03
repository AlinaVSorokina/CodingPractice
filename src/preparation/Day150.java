package preparation;

import java.util.*;

/**
 * Created by alina on 02.07.19.
 */
public class Day150 {
    public static void main(String[] args) {
        Point[] list = {new Point(0,0), new Point(5,4), new Point(3,1)};
        Point zero = new Point(1,2);
        int k = 2;

        Arrays.sort(list, new DistComparator(zero));
        for (int i = 0; i < k; i++) {
            System.out.println(list[i]);
        }
    }

    private static class DistComparator implements Comparator<Point> {
        private Point zero;

        DistComparator(Point zero) {
            this.zero = zero;
        }

        @Override
        public int compare(Point point1, Point point2) {
            Integer dist1 = (point1.x - zero.x) * (point1.x - zero.x) +
                    (point1.y - zero.y) * (point1.y - zero.y);
            Integer dist2 = (point2.x - zero.x) * (point2.x - zero.x) +
                    (point2.y - zero.y) * (point2.y - zero.y);
            return dist1.compareTo(dist2);
        }
    }

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
