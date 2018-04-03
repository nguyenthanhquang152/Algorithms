import java.util.HashMap;
import java.util.Map;

public class FindFirstNonRepeatedCharacter {

    public static void main(String[] args) {
        System.out.println(perform("AliveIsAwesome"));
        System.out.println(perform("LoveYourself"));
    }
    
    public static Character perform(String input) {
        Map<Character, Integer> visitedChars = new HashMap<Character, Integer>();
        for(int i=0; i<input.length(); i++) {
            char currChar = Character.toLowerCase(input.charAt(i));
            visitedChars.compute(currChar, (k, v) -> (v == null) ? 1 : (v+1));
        }
        for(int i=0; i<input.length(); i++) {
            char currChar = Character.toLowerCase(input.charAt(i));
            if(visitedChars.get(currChar) == 1) return currChar;
        }
        return null;
    }

}
