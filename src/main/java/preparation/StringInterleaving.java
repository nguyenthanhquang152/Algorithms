package preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringInterleaving {

    public static void main(String[] args) {
        System.out.println(isValid("bcc", "bbca", "bbcbcac"));
        System.out.println(isValidDP("bcc", "bbca", "bbcbcac"));
        System.out.println(isValidOptimizedDP("bcc", "bbca", "bbcbcac"));
    }

    public static boolean isValidOptimizedDP(String a, String b, String c){
        int lengthA = a == null ? 0 : a.length();
        int lengthB = b == null ? 0 : b.length();
        int sumOfFirstStringLengths = lengthA + lengthB;
        int lengthC = c == null ? 0 : c.length();
        if(sumOfFirstStringLengths == 0 && lengthC == 0) return true;
        if(sumOfFirstStringLengths == lengthC) {
            List<Boolean> cache = new ArrayList<>(Collections.nCopies(b.length() + 1, false));
            // set data for case a's length is zero
            cache.set(0, true);
            for(int i = 1; i <= b.length(); i++){
                if(c.charAt(i - 1) == b.charAt(i - 1)){
                    cache.set(i, cache.get(i - 1));
                } else {
                    cache.set(i, false);
                }
            }
            // set data for case a's length is not zero
            for(int i = 1; i <= a.length(); i++){
                for(int j = 0; j <= b.length(); j++) {
                    if (j == 0) {
                        if (c.charAt(i - 1) != a.charAt(i - 1)) {
                            cache.set(0, false);
                        }
                    } else {
                        Character cC = c.charAt(i + j - 1);
                        Character cA = a.charAt(i - 1);
                        Character cB = b.charAt(j - 1);
                        boolean first = false;
                        boolean second = false;
                        if(cC == cA) first = cache.get(j);
                        if(cC == cB) second = cache.get(j - 1);
                        cache.set(j, first || second);
                    }
                }
            }
            return cache.get(b.length());
        } else return false;
    }

    public static boolean isValidDP(String a, String b, String c){
        int lengthA = a == null ? 0 : a.length();
        int lengthB = b == null ? 0 : b.length();
        int sumOfFirstStringLengths = lengthA + lengthB;
        int lengthC = c == null ? 0 : c.length();
        if(sumOfFirstStringLengths == 0 && lengthC == 0) return true;
        if(sumOfFirstStringLengths == lengthC) {
            // b is column, a is row
            // Sample data:
            // _ _ b b c a
            // _
            // b
            // c
            // c
            List<List<Boolean>> cache = new ArrayList<>(a.length() + 1);
            for (int i = 0; i <= a.length(); i++) {
                cache.add(new ArrayList<>(Collections.nCopies(b.length() + 1, false)));
            }
            // set data for cache[0][0] is true
            cache.get(0).set(0, true);

            // set data for first row
            for (int i = 1; i <= b.length(); i++) {
                if (b.charAt(i - 1) == c.charAt(i - 1)) {
                    cache.get(0).set(i, cache.get(0).get(i - 1));
                } else {
                    cache.get(0).set(i, false);
                }
            }

            // set data for first column
            for (int i = 1; i <= a.length(); i++) {
                if (a.charAt(i - 1) == c.charAt(i - 1)) {
                    cache.get(i).set(0, cache.get(i - 1).get(0));
                } else {
                    cache.get(i).set(0, false);
                }
            }
            // set data for the rest cells
            for (int i = 1; i <= a.length(); i++) {
                List<Boolean> currentRow = cache.get(i);
                for (int j = 1; j <= b.length(); j++) {
                    Character cC = c.charAt(i + j - 1);
                    Character cA = a.charAt(i - 1);
                    Character cB = b.charAt(j - 1);
                    boolean first = false;
                    boolean second = false;
                    if (cA == cC) first = cache.get(i - 1).get(j);
                    if (cB == cC) second = cache.get(i).get(j - 1);
                    currentRow.set(j, first || second);
                }
            }
            return cache.get(a.length()).get(b.length());
        } else return false;
    }

    public static boolean isValid(String a, String b, String c){
        int lengthA = a == null ? 0 : a.length();
        int lengthB = b == null ? 0 : b.length();
        int sumOfFirstStringLengths = lengthA + lengthB;
        int lengthC = c == null ? 0 : c.length();
        if(sumOfFirstStringLengths == 0 && lengthC == 0) return true;
        if(sumOfFirstStringLengths == lengthC) {
            Character cA = a.length() == 0 ? null : a.charAt(0);
            Character cB = b.length() == 0 ? null : b.charAt(0);
            Character cC = c.charAt(0);
            if(cA != null && cA == cC && cB != null && cB == cC) {
                return isValid(a.substring(1), b, c.substring(1)) || isValid(a, b.substring(1), c.substring(1));
            } else if(cA != null && cA == cC){
                return isValid(a.substring(1), b, c.substring(1));
            } else if(cB != null && cB == cC){
                return isValid(a, b.substring(1), c.substring(1));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
