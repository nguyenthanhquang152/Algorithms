import java.util.Arrays;

public class Ex2 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minimumReplace(
                new String[] {
                        "ab",
                        "aab",
                        "abb",
                        "abab",
                        "abaaba",
                        "aaaaabbbbaaaa"
                }
                )));
    }
    
    public static int[] minimumReplace(String[] words) {
        int[] result = new int[words.length];
        for(int wordIndex=0; wordIndex<words.length; wordIndex++) {
            String word = words[wordIndex];
            int nReplace = 0;
            int nSame = 1;
            int pivotChar = word.charAt(0);
            // find the sub string with same pivotChar.
            // if the length of that sub string is n
            // then minimum number of times to modify that substring is n/2.
            for(int i=1; i<word.length(); i++) {
                if(word.charAt(i) == pivotChar) {
                    nSame++;
                } else {
                    pivotChar = word.charAt(i);
                    nReplace += (nSame)/2;
                    nSame=1;
                }
            }
            nReplace += (nSame)/2;
            result[wordIndex] = nReplace;
        }
        return result;
    }

}
