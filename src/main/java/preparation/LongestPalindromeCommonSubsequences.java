package preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestPalindromeCommonSubsequences {
    public static void main(String[] args) {
        String text = "abbda";
        System.out.println(recursive(text, 0, text.length() - 1));
        System.out.println(dp(text));
    }

    public static int recursive(String text, int start, int end){
        if(start > end) return 0;
        if(start == end) return 1;
        if(text.charAt(start) == text.charAt(end)) return 2 + recursive(text, start + 1, end - 1);
        else return
                Integer.max(recursive(text, start + 1, end)
                        , recursive(text, start, end - 1));
    }

    public static int dp(String text){
        List<List<Integer>> cache = new ArrayList<>(text.length());

        int tLength = text.length();
        for(int i = 0; i < tLength; i++){
            List<Integer> row = new ArrayList<>(Collections.nCopies(text.length(), 0));
            row.set(i, 1);
            cache.add(row);
        }
        for(int subLength = 2; subLength <= tLength; subLength++){
            for(int start = 0; start < tLength - subLength + 1; start++){
                int end = subLength + start - 1;
                if(text.charAt(start) == text.charAt(end) && subLength == 2) cache.get(start).set(end, 2);
                else if(text.charAt(start) == text.charAt(end)) cache.get(start).set(end, 2 + cache.get(start + 1).get(end - 1));
                else cache.get(start).set(end
                            , Integer.max(cache.get(start + 1).get(end)
                                    , cache.get(start).get(end - 1)));
            }
        }
        System.out.println(cache);
        return cache.get(0).get(text.length() - 1);
    }
}
