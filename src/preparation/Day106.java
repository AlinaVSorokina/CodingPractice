package preparation;

/**
 * Created by alina on 27.05.19.
 */
public class Day106 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 0};
        System.out.print(canReachEnd(arr));
    }

    public static boolean canReachEnd(int[] arr) {
        if (arr[arr.length - 1] != 0) return false;
        int sum = 0;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 0) return false;
            sum = sum + arr[i];
            i += arr[i];
        }
        return sum == arr.length - 1;
    }
}
