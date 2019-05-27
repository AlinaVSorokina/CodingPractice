package preparation;

/**
 * Created by alina on 27.05.19.
 */
public class Day113 {
    public static void main(String[] args) {
        String str = "word1 word2 word3 word4 word5";
        System.out.print(reverse(str));
    }

    public static String reverse(String str) {
        String[] words = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int j = words.length - 1; j >= 0; j--) {
            builder.append(words[j]);
            builder.append(" ");
        }
        builder.replace(builder.length() - 1, builder.length(), "" );
        return builder.toString();
    }
}
