package preparation.week5;

import java.util.Arrays;

/**
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * Implement run-length encoding and decoding.
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 * You can assume the string to be decoded is valid.
 */
public class Day29 {
    public static void main(String[] args) {
        String encoded = encode("AAAABBBCCDAAF");
        System.out.println(encoded);
        String decoded = decode(encoded);
        System.out.println(decoded);

    }

    public static String encode(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder encoded = new StringBuilder();
        char[] chars = s.toCharArray();
        int count = 1;
        char previous = chars[0];
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length) {
                encoded.append(count);
                encoded.append(previous);
                return encoded.toString();
            }
            if (chars[i] == previous) {
                count++;
            } else {
                encoded.append(count);
                encoded.append(previous);
                count = 0;
                previous = chars[i];
                i--;
            }
        }
        return encoded.toString();

    }

    public static String decode(String s) {
        if (s == null || s.isEmpty() || s.length() < 2 || s.length() % 2 != 0) return "";
        StringBuilder decoded = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            char[] letters = new char[Character.getNumericValue(chars[i])];
            Arrays.fill(letters, chars[i+1]);
            String substring = new String(letters);
            decoded.append(substring);
        }
        return decoded.toString();
    }
}
