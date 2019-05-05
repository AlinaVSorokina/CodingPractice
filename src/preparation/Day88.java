package preparation;
/*
Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.
 */

public class Day88 {
    public static void main(String[] args) {

    }

    public static int getResult(int dividend, int divisor) {
        int d1 = dividend > 0 ? 1 : -1;
        int d2 = divisor > 0 ? 1 : -1;

        int res = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            res++;
        }
        return 0;
    }
}
