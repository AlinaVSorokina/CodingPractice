package InterviewBook;

public class SearchAndSort {

    public static void main(String[] args) {
        System.out.println(5 ^ 7);

//        int[] a = {19, 20, 25, 1, 3, 4, 5, 7, 10, 14, 15, 16};
//        boolean res = task3(a, 77, 0, 11);
        String[] s = {"at","","","","ball","","","car","","","dad","",""};
        int res = task5(s, "cat");
        System.out.println(res);

    }

    private static boolean task3(int[] a, int n, int start, int end) {
        if (end < start) return false;
        int middle = start + (end - start) / 2;
        if (a[middle] == n) return true;
        boolean inLeft = pointIn(a, start, middle);
        boolean inRight = pointIn(a, middle + 1, end);
        if (inLeft) {
            if (a[middle + 1] <= n && a[end] >= n) {
                return task3(a, n, middle + 1, end);
            } else {
                return task3(a, n, start, middle);
            }
        } else if (inRight) {
            if (a[start] <= n && a[middle] >= n) {
                return task3(a, n, start, middle);
            } else {
                return task3(a, n, middle + 1, end);
            }
        } else {
            if (n <= a[middle] && n >= a[start]) return task3(a, n, start, middle);
            if (n <= a[end] && n >= a[middle + 1]) return task3(a, n, middle + 1, end);
            return false;
        }
    }

    private static boolean pointIn(int[] a, int start, int end){
        if (a[start] <= a[end]) return false;
        return true;
    }

    private static int task5(String[] s, String line) {
        return search(s, line, 0, s.length-1);
    }

    private static int search(String[] s, String n, int start, int end) {
        if (end < start) return -1;
        int middle = start + (end - start) / 2;
        String str = s[middle];
        if (str.isEmpty()) {
            while(str.isEmpty() && middle != end) {
                middle++;
                str = s[middle];
            }
        }
        if (middle == end) middle = end - 1;
        if (str.equals(n)) return middle;
        if (str.equals("") || n.compareTo(str) < 0) return search(s, n, start, middle);
        if (n.compareTo(str) > 0) return search(s, n, middle + 1, end);
        return -1;
    }
}

