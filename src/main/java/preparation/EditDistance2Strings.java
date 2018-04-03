package preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditDistance2Strings {
    public static void main(String[] args) {
        System.out.println(editD("manchester city", "manchester united"));
        System.out.println(editDWithDP("manchester city", "manchester united"));
    }

    public static int editD(String s1, String s2){
        if(s1 == null || s1.isEmpty()) return s2 == null ? 0 : s2.length();
        if(s2 == null || s2.isEmpty()) return s1 == null ? 0 : s1.length();
        if(s1.charAt(0) == s2.charAt(0)) return editD(s1.substring(1), s2.substring(1));
        // delete first character of s1
        int deleteFirstCharFromS1 = editD(s1.substring(1), s2);
        int replaceFirstCharFromS1ByS2 = editD(s1.substring(1), s2.substring(1));
        int insertFirstCharFromS1ToS1 = editD(s1, s2.substring(1));
        return 1 + Math.min(Math.min(deleteFirstCharFromS1, replaceFirstCharFromS1ByS2), insertFirstCharFromS1ToS1);
    }

    public static int editDWithDP(String s1, String s2){
        // number of rows is s2.length(),  number of columns is s1.length()
        List<List<Integer>> cache = new ArrayList<>(s2.length() + 1);
        for(int i = 0; i<= s2.length(); i++) cache.add(new ArrayList<>(
                Collections.nCopies(s1.length() + 1 , 0)
        ));
        // setup initial values for first row
        for(int i = 0; i <= s1.length(); i++){
            cache.get(0).set(i, i);
        }
        // setup initial values for first column
        for(int i = 0; i <= s2.length(); i++){
            cache.get(i).set(0, i);
        }
        for(int i = 1; i <= s2.length(); i++){
            List<Integer> currentRow = cache.get(i);
            for(int j = 1; j < currentRow.size(); j++){
                if(s1.charAt(j - 1) == s2.charAt(i - 1)){
                    currentRow.set(j, cache.get(i - 1).get(j - 1));
                } else {
                    currentRow.set(j, 1 +
                            Integer.min(
                                    Integer.min(cache.get(i - 1).get(j), cache.get(i - 1).get(j - 1)),
                                    cache.get(i).get(j - 1)
                            )
                    );
                }
            }
        }
        return cache.get(s2.length()).get(s1.length());
    }
}
