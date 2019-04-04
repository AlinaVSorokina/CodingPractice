package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write an algorithm to justify text. Given a sequence of words and an integer line length k,
 * return a list of strings which represents each line, fully justified.
 * More specifically, you should have as many words as possible in each line.
 * There should be at least one space between each word. Pad extra spaces when necessary
 * so that each line has exactly length k. Spaces should be distributed as equally as possible,
 * with the extra spaces, if any, distributed starting from the left.
 * If you can only fit one word on a line, then you should pad the right-hand side with spaces.
 * Each word is guaranteed not to be longer than k.
 */
public class Day28 {

    public static void main(String[] args) {
        String[] words =  {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int k = 20;
        List<String> res = getStrings(words, k);
        res.forEach(System.out::println);
    }

    public static List<String> getStrings(String[] words, int k) {
        List<String> strings = new ArrayList<>();
        List<String> selected = new ArrayList<>();
        int stringLength = 0;

        for (int j = 0; j <= words.length; j++) {
            int emptySpace = k - stringLength;

            if (j == words.length) {
                String string = buildString(emptySpace, selected);
                strings.add(string);
                return strings;
            }

            int toPlace = selected.size() == 0 ? words[j].length() : words[j].length() + 1;
            if (emptySpace >= toPlace) {
                selected.add(words[j]);
                stringLength += toPlace;
            } else {
                j--;
                String string = buildString(emptySpace, selected);
                strings.add(string);
                stringLength = 0;
                selected = new ArrayList<>();
            }
        }

        return strings;
    }

    public static String buildString(int extraSpaces, List<String> selected) {
        StringBuilder builder = new StringBuilder();
        int spaceCount = selected.size() - 1;

        int amount1 = 1;
        int amount2 = 1;
        int div = 0;
        if (spaceCount == 0) {
            amount1 = extraSpaces;
        } else if (extraSpaces < spaceCount) {
            amount1 += 1;
            div = extraSpaces - 1;
        } else {
            amount2 += extraSpaces / spaceCount;
            div = extraSpaces % spaceCount > 0 ? extraSpaces % spaceCount - 1 : spaceCount - 1;
            amount1 = div == spaceCount - 1 ? amount2 : amount2 + 1;
        }

        char[] charArray = new char[amount1];
        Arrays.fill(charArray, ' ');
        String spaces1 = new String(charArray);

        charArray = new char[amount2];
        Arrays.fill(charArray, ' ');
        String spaces2 = new String(charArray);


        for (int i = 0; i < selected.size(); i++) {
            builder.append(selected.get(i));
            if (i < selected.size() - 1 || selected.size() == 1) {
                String space = i <= div ? spaces1 : spaces2;
                builder.append(space);
            }
        }
        return builder.toString();
    }
}
