package preparation.chapter12;

import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        long num = 300;
        System.out.println(nextLowestSquareRoot(num));
        System.out.println(nextGreatestSquareRoot(num));
        List<Integer> input = Arrays.asList(0,0,0,1,1,1,2,2);
        System.out.println();
        findDistincts(input);
        System.out.println();
        findDuplicates(input);
    }

    public static long nextLowestSquareRoot(long num){
        return nextLowestSquareRootHelper(num, 0, num);
    }

    public static long nextLowestSquareRootHelper(long num, long left, long right) {
        if(left > right) return left - 1;
        long mid = left + (right - left) / 2;
        long midPowerTwo = mid * mid;
        if (midPowerTwo <= num) return nextLowestSquareRootHelper(num, mid + 1, right);
        else return nextLowestSquareRootHelper(num, left, mid - 1);
    }

    public static long nextGreatestSquareRoot(long num){
        return nextGreatestSquareRootHelper(num, 0, num);
    }

    public static long nextGreatestSquareRootHelper(long num, long left, long right) {
        if(left > right) return right + 1;
        long mid = left + (right - left)/2;
        long midPowerTwo = mid * mid;
        if(midPowerTwo >= num) return nextGreatestSquareRootHelper(num, left, mid - 1);
        else return nextGreatestSquareRootHelper(num, mid + 1, right);
    }

    public static void findDistincts(List<Integer> input){
        int valueSofar = input.get(0);
        for(int i = 1; i <= input.size(); i++){
            if(i == input.size() || valueSofar != input.get(i)) {
                System.out.println(valueSofar);
                if(i < input.size()) valueSofar = input.get(i);
            }
        }
    }

    public static void findDuplicates(List<Integer> input){
        int valueSofar = input.get(0);
        for(int i = 1; i <= input.size(); i++){
            if(i == input.size() || valueSofar != input.get(i)) {
                if(i < input.size()) valueSofar = input.get(i);
            } else {
                System.out.println(input.get(i));
            }
        }
    }
}
