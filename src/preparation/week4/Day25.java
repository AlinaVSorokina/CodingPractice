package preparation.week4;

/**
 * Implement regular expression matching with the following special characters:
 *  . (period) which matches any single character
 * (asterisk) which matches zero or more of the preceding element
 * That is, implement a function that takes in a string and a valid regular
 * expression and returns whether or not the string matches the regular expression.
 */
public class Day25 {
    public static void main(String[] args) {
        String r = "ra.";
        String s = "ray";
        String s1 = "raymond";

        String r1 = ".*at";
        String s2 = "chat";
        String s3 = "chats";

//        System.out.println(matches(s, r));
//        System.out.println(matches(s1, r));
//        System.out.println(matches(s2, r1));
        System.out.println(matches(s3, r1));
    }

    public static boolean matches(String s, String r) {
        if(r.isEmpty()) return s.isEmpty();

        if (r.length() == 1 || r.charAt(1) != '*'){
            if (matchesFirstChar(s, r)) {
                return matches(s.substring(1),r.substring(1));
            } else {
                return false;
            }
        } else{
            if (matches(s, r.substring(2))){
                return true;
            }
            int i = 0;
            while (matchesFirstChar(s.substring(i),r)) {
                if (matches(s.substring(i + 1),r.substring(2))) return true;
                i++;
            }
        }
        return false;
    }

    public static boolean matchesFirstChar(String s, String r) {
        if (s.isEmpty() && !r.isEmpty()) return false;
        return s.charAt(0) == r.charAt(0) ||
                (r.charAt(0) == '.' && s.length() > 0);
    }
}
