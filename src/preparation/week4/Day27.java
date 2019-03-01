package preparation.week4;

import java.util.*;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

public class Day27 {
    public static void main(String[] args) {
        System.out.println(isBalanced("([])[]({})"));
        System.out.println(isBalanced("([)]"));
    }

    public static boolean isBalanced(String s) {
        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        char[] braces = s.toCharArray();
        Stack<Character> steps = new Stack<>();
        for (char brace : braces) {
            if (open.contains(brace)) {
                steps.add(brace);
            } else {
                if (steps.isEmpty()) return false;
                char openBrace = steps.pop();
                if (openBrace != pairs.get(brace)) return false;
            }
        }
        return true;
    }
}
