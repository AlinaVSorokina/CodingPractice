package preparation.week5;

public class Day35 {
    public static void main(String[] args) {
        char[] in = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        char[] res = order(in);
        System.out.println();
    }

    public static char[] order(char[] in) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (char c : in) {
            switch (c) {
                case 'R' : r++; break;
                case 'G' : g++; break;
                case 'B' : b++;
            }
        }
        for (int i = 0; i < r; i++) in[i] = 'R';
        for (int i = r; i < r + g; i++) in[i] = 'G';
        for (int i = r + g; i < r + g + b; i++) in[i] = 'B';

        return in;
    }
}
