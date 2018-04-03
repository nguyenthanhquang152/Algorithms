package preparation.chapter13;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        String input = "deified";
        Map<Character,Integer> occurrences = new HashMap<>();
        for(int i=0; i<input.length(); i++){
            char curChar = input.charAt(i);
            if(!occurrences.containsKey(curChar)) occurrences.put(curChar, 0);
            occurrences.put(curChar, occurrences.get(curChar) + 1);
        }
        int oddOccurences = 0;
        for(Map.Entry<Character, Integer> entry : occurrences.entrySet()){
            if(entry.getValue() % 2 == 1) oddOccurences++;
        }
        if(oddOccurences > 1) System.out.println("Cannot have a palindrome permutation.");
        else System.out.println("Yes, it is.");
    }
}
