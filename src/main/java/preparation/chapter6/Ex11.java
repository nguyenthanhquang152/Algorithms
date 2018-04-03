package preparation.chapter6;

import java.util.*;

public class Ex11 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        // We need to random a single number to pick one index.
        // Exclude that index by swapping it to the head of the array
        int k = 4;
        int upperbound = input.size();
        Random r = new Random();
        for(int i = 0; i<k; i++){
            int randomizedIndex = r.nextInt(upperbound);
            System.out.println(randomizedIndex);
            Collections.swap(input, i, randomizedIndex + i);
            upperbound--;
        }
        System.out.println(input);
    }
}
