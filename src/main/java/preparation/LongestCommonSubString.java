package preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println(lcsDP("north manchester united", "south manchester city"));
    }

    public static int lcs(String s1, String s2){
        return perform(s1, s2, 0, 0);
    }

    public static int perform(String s1, String s2, int idx1, int idx2){
        if(idx1 == s1.length() || idx2 == s2.length()) return 0;
        else if(s1.charAt(idx1) == s2.charAt(idx2)) return 1 + perform(s1, s2, idx1 + 1, idx2 +1);
        else return 0;
    }

    public static int lcsDP(String s1, String s2){
        // s1 = "abcd"
        // s2 = "aebfcgd"
        // - - a e b f c g d
        // -
        // a
        // b
        // c
        // d
        int result = 0;
        List<List<Integer>> cache = new ArrayList<>(s1.length() + 1);
        for(int i = 0; i<=s1.length(); i++){
            cache.add(new ArrayList<>(Collections.nCopies(s2.length() + 1, 0)));
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    cache.get(i).set(j, 1 + cache.get(i - 1).get(j - 1));
                    result = Integer.max(result, cache.get(i).get(j));
                }
            }
        }
        return result;
    }
}
