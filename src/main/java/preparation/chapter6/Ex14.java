package preparation.chapter6;

import java.util.*;

public class Ex14 {
    public static void main(String[] args) {
        List<Integer> input =  new ArrayList<>(100);
        for(int i=0; i<100; i++){
            input.add(i);
        }
        Random r = new Random();
        int k = 4;
        Map<Integer, Integer> processedIndicies = new HashMap<>();
        for(int i = 0; i < k; i++){
            Integer randomIndex = i + r.nextInt(input.size() - i);
            Integer elemAtI = processedIndicies.get(i);
            Integer elemAtRandom = processedIndicies.get(randomIndex);
            if(elemAtI == null && elemAtRandom == null){
                processedIndicies.put(i, randomIndex);
                processedIndicies.put(randomIndex, i);
            } else if(elemAtI == null && elemAtRandom != null){
                processedIndicies.put(i, elemAtRandom);
                processedIndicies.put(randomIndex, i);
            } else if(elemAtRandom == null && elemAtI != null){
                processedIndicies.put(randomIndex, elemAtI);
                processedIndicies.put(i, randomIndex);
            } else {
                processedIndicies.put(i, elemAtRandom);
                processedIndicies.put(randomIndex, elemAtI);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for(int i=0; i<k; i++){
            result.add(processedIndicies.get(i));
        }
        System.out.println(result);
    }
}
