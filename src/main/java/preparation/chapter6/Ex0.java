package preparation.chapter6;

import java.util.Arrays;

public class Ex0 {
    // Separate even/odd numbers in an array
    public static void main(String[] args) {
        int[] numbers = new int[]{
//                1,2,3,4,5,6,7,8,9,0
                7, 5, 9, 3, 1, 0, 2, 8, 4, 6
        };
        int nextEven = 0;
        int nextOdd = numbers.length - 1;
        while(nextEven <= nextOdd){
            if(numbers[nextEven]%2 == 0){
                nextEven++;
            } else {
                numbers[nextEven] += numbers[nextOdd];
                numbers[nextOdd] = numbers[nextEven] - numbers[nextOdd];
                numbers[nextEven] = numbers[nextEven] - numbers[nextOdd];
                nextOdd--;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
