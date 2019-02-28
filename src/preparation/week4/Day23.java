package preparation.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 * If there is no possible path, then return null. You can move up, left, down, and right.
 * You cannot move through walls. You cannot wrap around the edges of the board.
 *
 */
public class Day23 {
    public static void main(String[] args) {
        boolean[][] labyrinth = new boolean[4][4];

        labyrinth[0][0] = false;
        labyrinth[0][1] = false;
        labyrinth[0][2] = false;
        labyrinth[0][3] = false;

        labyrinth[1][0] = true;
        labyrinth[1][1] = true;
        labyrinth[1][2] = false;
        labyrinth[1][3] = true;

        labyrinth[2][0] = false;
        labyrinth[2][1] = false;
        labyrinth[2][2] = false;
        labyrinth[2][3] = false;

        labyrinth[3][0] = false;
        labyrinth[3][1] = false;
        labyrinth[3][2] = false;
        labyrinth[3][3] = false;

        Day23.Point start = new Day23.Point();
        start.x = 3;
        start.y = 0;

        Day23.Point end = new Day23.Point();
        end.x = 0;
        end.y = 0;

        day23(labyrinth, start, end);
    }

    public static int day23(boolean[][] labyrinth, Point start, Point end){
        Queue<Point> pointQueue = new LinkedList<>();
        start.step = 0;
        pointQueue.add(start);
        int endStep = -1;
        while (!pointQueue.isEmpty() && endStep < 0) {
            Point current = pointQueue.poll();
            if (current.equals(end)) endStep = current.step;
            List<Point> next = getNext(current, labyrinth, current.step);
            for (Point p : next) {
                pointQueue.add(p);
            }
            labyrinth[current.x][current.y] = true;
        }
        return endStep;
    }

    public static List<Point> getNext(Point point, boolean[][] labyrinth, int step) {
        step++;
        int n = labyrinth.length;
        int m = labyrinth[0].length;
        List<Point> points = new ArrayList<>();

        int x = point.x - 1;
        int y = point.y;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x + 1;
        y = point.y;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x;
        y = point.y - 1;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        x = point.x;
        y = point.y + 1;
        if (x >= 0 && x < n && y >= 0 && y < m && !labyrinth[x][y]) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.step = step;
            points.add(p);
        }

        return points;
    }

    private static class Point {
        int x;
        int y;
        int step;

        boolean equals(Point p) {
            if (x == p.x && y == p.y) return true;
            return false;
        }

    }
}
