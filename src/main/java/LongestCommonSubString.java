import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println(dp("abcd", "aebd"));
        System.out.println(recurse("abcd", "aebd"));
    }

    public static int recurse(String s1, String s2){
        if(s1 == null || s1.isEmpty()) return 0;
        if(s2 == null || s2.isEmpty()) return 0;
        if(s1.charAt(0) == s2.charAt(0)) return 1 + recurse(s1.substring(1), s2.substring(1));
        return Integer.max(recurse(s1.substring(1), s2), recurse(s1, s2.substring(1)));
    }

    public static int dp(String s1, String s2){
        // cache has s2.length() + 1 rows, s1.length() + 1 columns
        List<List<Integer>> cache = new ArrayList<>(s2.length() + 1);
        for(int i = 0; i<=s2.length(); i++){
            cache.add(new ArrayList<>(Collections.nCopies(s1.length() + 1, 0)));
        }
        for(int i = 1; i<=s2.length(); i++){
            List<Integer> currentRow = cache.get(i);
            for(int j = 1; j <= s1.length(); j++){
                if(s2.charAt(i - 1) == s1.charAt(j - 1)){
                    currentRow.set(j, 1 + cache.get(i - 1).get(j - 1));
                } else {
                    currentRow.set(j, Integer.max(cache.get(i - 1).get(j), cache.get(i).get(j - 1)));
                }
            }
        }
        return cache.get(s2.length()).get(s1.length());
    }
}
