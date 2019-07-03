package preparation;

/**
 * Created by alina on 26.06.19.
 */
public class Day144 {
    public static void main(String[] args) {
        int[] input = {4, 1, 3, 5, 6};
        int index = 4;
        System.out.print(getLarger(input, index));
    }

    public static Integer getLarger(int[] input, int index) {
        int sign = 1;
        int step = 1;
        int checked = 0;
        while (checked < input.length - 1) {
            int currentIndex = index + step * sign;
            if (currentIndex < input.length -1 && currentIndex >= 0) {
                if (input[currentIndex] > input[index]) return currentIndex;
                checked++;
            }
            sign = -1 * sign;
            if (sign > 0) step++;
        }
        return null;
    }
}
