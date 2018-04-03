package preparation;

import java.util.*;

public class FindAllSubarraysWithSum {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 4, -7, 3, 1, 3, 1, -4, -2, -2);
            printAllSubArrays(input, 3);

    }

    public static void printAllSubArrays(List<Integer> input, int expectedSum){
        Map<Integer, List<Integer>> sumsSofar = new HashMap<>();
        sumsSofar.put(0, new ArrayList<>(Arrays.asList(-1)));
        int sum = 0;
        for(int i = 0; i < input.size(); i++) {
            sum += input.get(i);
            if (sumsSofar.containsKey(sum - expectedSum)) {
                List<Integer> cachedSum = sumsSofar.get(sum - expectedSum);
                // Todo: print from index a to index b
                int j = i;
                cachedSum.forEach(item -> System.out.printf("[%d .. %d]\n", item + 1, j));

                // Todo: print value from index a to index b
//                for(int j = 0; j < cachedSum.size(); j++) {
//                    List<Integer> subarray = new ArrayList<>();
//                    for(int k = cachedSum.get(j) + 1; k <= i; k++) {
//                        subarray.add(input.get(k));
//                    }
//                    System.out.println(subarray);
//                }
            }
            if (!sumsSofar.containsKey(sum))
                sumsSofar.put(sum, new ArrayList<>());
            sumsSofar.get(sum).add(i);
        }
    }
}
