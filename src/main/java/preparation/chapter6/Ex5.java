package preparation.chapter6;

import java.util.Arrays;

public class Ex5 {
    public static void main(String[] args) {
        int[] numbers = new int[]{
                2,2,3,5,5,7,11,11,11,13,13
        };

        removeDuplicates(numbers);
        numbers = new int[]{
                1,5,2,5,3,5,4
        };
        removeAllByKey(numbers,5);
    }

    private static void removeAllByKey(int[] numbers, int key){
        int distinctIndex = 0;
        for(int i=0; i<numbers.length; i++){
            while(i<numbers.length && numbers[i] == key){
                i++;
            }
            if(i<numbers.length) {
                int temp = numbers[i];
                numbers[i] = numbers[distinctIndex];
                numbers[distinctIndex] = temp;
                distinctIndex++;
            }
        }
        for(int i = distinctIndex; i<numbers.length; i++){
            numbers[i] = 0;
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void removeDuplicates(int[] numbers) {
        int curVal = Integer.MIN_VALUE;
        int distinctIndex = 0;
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i] != curVal){
                curVal = numbers[i];
                numbers[distinctIndex] = numbers[i];
                distinctIndex++;
            }
        }
        for(int i = distinctIndex; i<numbers.length; i++){
            numbers[i] = 0;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
