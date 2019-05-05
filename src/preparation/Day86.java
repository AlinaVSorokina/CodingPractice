package preparation;

import java.util.LinkedList;
import java.util.Stack;

public class Day86 {
    public static void main(String[] args) {
        int res = getNumber(")(");
        System.out.println(res);
    }

    private static int getNumber(String line) {
        char[] pars = line.toCharArray();
        Stack<Character> stack = new Stack<>();

        int res = 0;
        for (Character par : pars) {
            if (par.equals(')')) {
                if (stack.isEmpty()) {
                    res++;
                } else {
                    stack.pop();
                }
            } else {
                stack.add(par);
            }
        }
        res = res + stack.size();
        return res;
    }
}
