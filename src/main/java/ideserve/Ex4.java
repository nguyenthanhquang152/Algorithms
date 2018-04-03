package ideserve;

/**
 * Longest Palindromic Substring O(N) Manacher's Algorithm
 *
 * 1.0 : Dynamic Programming version using historical calculations.
 * 1.1 : Dynamic Programming version => find longest palindrome substrings having event/odds size.
 */
public class Ex4 {
    private static int[] dpsolution10(String input) {
        int[] indicies = new int[]{0,0};
        int length = input.length();
        boolean[][] table = new boolean[length][length];
        // Base case 1: all substrings having single character are palindrome.
        // Base case 2: One substring is palindrome iff it's first and second characters are identical.
        table[0][0] = true;
        for(int i=1; i<length; i++) {
            table[i][i] = true;
            if(input.charAt(i - 1) == input.charAt(i)){
                table[i-1][i] = true;
                if(indicies[1] - indicies[0] < 1)
                    indicies = new int[]{i-1, i};
            }
        }

        // Normal case: substring length is greater than 2.
        for(int slen=3; slen<=length; slen++){
            for(int startIndex=0; startIndex <= length - slen; startIndex++){
                int endIndex = startIndex + slen - 1;
                if(table[startIndex + 1][endIndex - 1] && input.charAt(startIndex) == input.charAt(endIndex)){
                    table[startIndex][endIndex] = true;
                    if(indicies[1] - indicies[0] < slen){
                        indicies = new int[]{startIndex, endIndex};
                    }
                }
            }
        }

        return indicies;
    }

    private static int[] dpsolution11(String input){
        int length = input.length();
        int low, high;
        int start = 0, end = 0;
        // Choose a pivot element then expand the substring to both sides.
        for(int i=1; i<length; i++){
            // Case even size substring
            low = i-1;
            high = i;
            // keep expanding substrings to both sides until it is not palindrome anymore.
            while(low >= 0 && high < length && input.charAt(low) == input.charAt(high)){
                if(high - low > end - start){
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
            // Case odd size substring
            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < length && input.charAt(low) == input.charAt(high)){
                if(high - low > end - start){
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }
        return new int[]{start, end};
    }


    public static void main(String[] args) {
        String input = "abcdcba";
        int[] range10 = dpsolution10(input);
        System.out.println(input.substring(range10[0], range10[1] + 1));
        int[] range11 = dpsolution11(input);
        System.out.println(input.substring(range11[0], range11[1] + 1));
    }
}
