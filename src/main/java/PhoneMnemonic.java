import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonic {
    public static String[] mapping = new String[] {
            "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    };

    public static void main(String[] args) {
        String number = "23";
        List<String> result = perform(number);
        result.forEach(value -> System.out.println(value));
    }
    
    public static List<String> perform(String number) {
        char[] accumulatedChars = new char[number.length()];
        List<String> accumulatedStrings = new ArrayList<>();
        performHelper(number, 0, accumulatedChars, accumulatedStrings);
        return accumulatedStrings;
        
    }
    
    public static void performHelper(String number, int digitIndex
            , char[] accumulatedChars, List<String> accumulatedStrings) {
        if(digitIndex == number.length()) {
            accumulatedStrings.add(new String(accumulatedChars));
        } else {
            String mappedValue = mapping[number.charAt(digitIndex) - '0'];
            for(int i=0; i<mappedValue.length(); i++) {
                accumulatedChars[digitIndex] = mappedValue.charAt(i);
                performHelper(number, digitIndex + 1, accumulatedChars, accumulatedStrings);
            }
        }
    }

}
