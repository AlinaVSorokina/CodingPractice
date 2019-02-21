package InterviewBook;

import java.util.*;

public class Dynamic {

    public static void main(String[] args) {

//        Set<Integer> set = new HashSet<>();
//        set.add(11);
//        set.add(21);
//        set.add(31);
//        set.add(41);
//        set.add(51);
//        set.add(61);
//        set.add(71);
//        set.add(81);
//
//        List<Set<Integer>> res = task4(set);
//        System.out.println();

//        System.out.println(task6("((()))"));
//        System.out.println(task6("(())()"));
//        System.out.println(task6("()()()"));
//        System.out.println(task6("(()())"));
//        System.out.println(task6("()())("));

        ArrayList<String> res = generateParens(3);
        System.out.println();

    }


    public static void addParen(ArrayList<String> list, int leftRem,int rightRem, char[] str, int count) {

        if (leftRem < 0 || rightRem < leftRem) return; // invalid state
        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }
    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    private static int task6(String str) {
        char[] ch = str.toCharArray();
        int open = 0;
        int close = 0;
        int pair = 0;
        for (int i = 0; i < ch.length; i++){
            if (ch[i]=='(') open++;
            if (ch[i] == ')') close++;
            if (close >  open) return -1;
            if (open > 0 && close > 0) {
                pair = pair + close;
                open = open - close;
                close = 0;
            }
        }
        if (open > 0 || close > 0) return -1;
        return pair;
    }

    private static List<Set<Integer>> task4(Set<Integer> init) {
        List<Set<Integer>> res = new ArrayList<>(init.size());
        Iterator<Integer> iter = init.iterator();
        Set<Integer> currSet = new HashSet<>();
        while (iter.hasNext()) {
            Integer next = iter.next();
            Iterator<Set<Integer>> setIter = res.iterator();
            List<Set<Integer>> temp = new ArrayList<>();
            while (setIter.hasNext()) {
                Set<Integer> set = setIter.next();
                Set<Integer> newSet = new HashSet<>(set);
                newSet.add(next);
                temp.add(newSet);
            }
            currSet.add(next);
            temp.add(currSet);
            res.addAll(temp);
            currSet = new HashSet<>();
        }
        res.add(new HashSet<>());
        return res;
    }

    private static long task5(String str) {
        return getFactorial(str.length());
    }

    private static long getFactorial(int num) {
        long res = 1;
        for (int i = 1; i<= num; i++) {
            res = res * i;
        }
        return res;
    }
}
