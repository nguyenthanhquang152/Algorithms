package preparation.chapter13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Ex9 {
    public static void main(String[] args) {
//        String input = "fsfetwenwe";
        String input = "abcabcdehfgh";
        System.out.println(longestSubArrayWithDistinctEntries(input));
    }

    public static class CharacterIndex{
        public char c;
        public int i;

        public CharacterIndex(char c, int i) {
            this.c = c;
            this.i = i;
        }

        @Override
        public String toString() {
            return "CharacterIndex{" +
                    "c=" + c +
                    ", i=" + i +
                    '}';
        }
    }

    private static Ex7.StartEndIndices longestSubArrayWithDistinctEntries(String input){
        Map<Character, Integer> mostOccurrences = new HashMap<>();
        Ex7.StartEndIndices result = new Ex7.StartEndIndices(-1, -1);
        int distanceSofar = 0;
        int left = 0, right = 0;
        for(right = 0; right < input.length(); right++){
            char c = input.charAt(right);
            Integer idx = mostOccurrences.put(c, right);
            if(idx != null){
                if(idx >= left) {
                    if (right - left > distanceSofar) {
                        result.start = left;
                        result.end = right - 1;
                        distanceSofar = right - left;
                    }
                    left = idx + 1;
                }
            }
        }
        if(right - left > distanceSofar){
            result.start = left;
            result.end = right - 1;
            distanceSofar = right - left - 1;
        }
        return result;
    }
}
