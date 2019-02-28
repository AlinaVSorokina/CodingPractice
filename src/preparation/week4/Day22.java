package preparation.week4;

import javafx.util.Pair;

import java.util.*;

/**
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
//TODO not finished

public class Day22 {
    public static void main(String[] args) {
        String[] dic1 = {"the", "quick", "brown", "fox"};
        String[] dic2 = {"bed", "bath", "bedbath", "and", "beyond"};
        String str1 = "thequickbrownfox";
        List<List<String>> res1 = day22(dic1, str1);
        System.out.println("");
    }

    public static List<List<String>> day22(String[] dic, String line){
        TreeSet<String> dictionary = new TreeSet<>();
        for (String str : dic) dictionary.add(str);
        Queue<Pair<Integer,List<String>>> workQueue = new LinkedList<>();
        List<List<String>> results = new ArrayList<>();
        char[] letters = line.toCharArray();
        Pair<Integer, List<String>> pair = new Pair<>(0, new ArrayList<>());
        workQueue.add(pair);
        while (!workQueue.isEmpty()) {
            Pair<Integer, List<String>> current = workQueue.poll();
            if (current.getKey() >= line.length()) {
                results.add(current.getValue());
            }
            List<String> nextWords = getNextWords(letters, current.getKey(), dictionary);
            for (String word : nextWords) {
                if (line.substring(current.getKey()).startsWith(word)) {
                    List<String> newStr = new ArrayList<>();
                    newStr.addAll(current.getValue());
                    newStr.add(word);
                    workQueue.add(new Pair<>(current.getKey() + word.length(), newStr));
                }
            }
        }
        return results;
    }

    public static List<String> getNextWords(char[] letters, int index, TreeSet<String> dictionary) {
        StringBuilder word = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (int i = index; i < letters.length; i++) {
            word.append(letters[i]);
            if (dictionary.contains(word.toString())) {
                NavigableSet<String> ns = dictionary.tailSet(word.toString(), true);
                String w = null;
                while (!ns.isEmpty() && (w = ns.pollFirst()).contains(word.toString())){
                    words.add(w);
                }
                return words;
            }
        }
        return words;
    }
}
