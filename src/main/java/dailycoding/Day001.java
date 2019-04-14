package dailycoding;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
public class Day001 {
    public static void main(String[] args) {
        int[] input = {
                10, 15, 3, 7
        };
        int sum = 18;
        System.out.println(hasPairWithSum(input, sum));
    }

    public static boolean hasPairWithSum(int[] input, int sum) {

        Set<Integer> missingNumbers = new HashSet<>();
        for(int number : input){
            if(missingNumbers.contains(number)){
                return true;
            } else {
                missingNumbers.add(sum - number);
            }
        }
        return false;
    }
}
