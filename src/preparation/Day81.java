package preparation;

import java.util.*;

/**
 * Created by alina on 05.05.19.
 */
public class Day81 {
    public static void main(String[] args) {

    }

    private static List<String> getWords(Map<Integer, List<String>> data, int[] number){
        Queue<String> words = new LinkedList<>();
        words.addAll(data.get(number[0]));
        int length = data.get(number[0]).size();
        for (int i = 1; i < number.length; i++) {
            for (int j = 1; j <= length; j++) {
                String pref = words.poll();
                for (String st : data.get(number[i])) {
                    words.add(pref + st);
                }
                j++;
            }
        }
        return new ArrayList<>(words);
    }
}
