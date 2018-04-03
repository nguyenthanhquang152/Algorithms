package preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequences {

    public static void main(String[] args) {
        System.out.println(lcs("abcd", "aebd"));
        System.out.println(lcsDP("abcd", "aebd"));
    }

    public static int lcs(String s1, String s2){
        return perform(s1, s2, 0, 0);
    }

    public static int perform(String s1, String s2, int idx1, int idx2){
        if(idx1 == s1.length() || idx2 == s2.length()) return 0;
        if(s1.charAt(idx1) == s2.charAt(idx2)) return 1 + perform(s1, s2, idx1 + 1, idx2 +1);
        else return Integer.max(perform(s1, s2, idx1 + 1, idx2), perform(s1, s2, idx1, idx2 + 1));
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
        List<List<Integer>> cache = new ArrayList<>(s1.length() + 1);
        for(int i = 0; i<=s1.length(); i++){
            cache.add(new ArrayList<>(Collections.nCopies(s2.length() + 1, 0)));
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    cache.get(i).set(j, 1 + cache.get(i - 1).get(j - 1));
                } else {
                    int topLCS = cache.get(i - 1).get(j);
                    int leftLCS = cache.get(i).get(j - 1);
                    cache.get(i).set(j, Integer.max(topLCS, leftLCS));
                }
            }
        }
        System.out.println(cache);

        StringBuilder builder = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                builder.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if(cache.get(i - 1).get(j) > cache.get(i).get(j - 1)){
                i--;
            } else {
                j--;
            }
        }
        System.out.println(builder.reverse().toString());
        return cache.get(s1.length()).get(s2.length());
    }
}
