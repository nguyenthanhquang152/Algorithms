package preparation.chapter13;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex2 {
    public static void main(String[] args) {
        String letter = "sieukaka";
        String magazine = "ssiieeuukkaakkaa";
        System.out.println(isLetterConstructibleFromMagazine(letter, magazine));
        System.out.println(isLetterConstructibleFromMagazine(magazine, letter));
        new LinkedHashMap<>();
    }

    private static boolean isLetterConstructibleFromMagazine(String letter, String magazine){
        Map<Character, Integer> letterOccurrences = new HashMap<>();
        for(int i = 0; i<letter.length(); i++){
            char lChar = letter.charAt(i);
            if(!letterOccurrences.containsKey(lChar)) letterOccurrences.put(lChar, 1);
            else letterOccurrences.put(lChar, letterOccurrences.get(lChar) + 1);
        }
        for(int i=0; i<magazine.length(); i++){
            char mChar = magazine.charAt(i);
            if(letterOccurrences.containsKey(mChar)) {
                letterOccurrences.put(mChar, letterOccurrences.get(mChar) - 1);
                if(letterOccurrences.get(mChar).equals(0)){
                    letterOccurrences.remove(mChar);
                }
                if(letterOccurrences.isEmpty()) break;
            }
        }
        return letterOccurrences.isEmpty();
    }
}
