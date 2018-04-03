package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapSack {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(2,3,4,5);
        List<Integer> values = Arrays.asList(3,4,5,6);
        System.out.println(withoutDP(5, 4, weights, values));
        System.out.println(withDP(5, weights, values));
    }

    public static int withoutDP(int maxWeight, int n, List<Integer> weights, List<Integer> values){
        // Cannot get any thing else
        if(n <= 0 || maxWeight <= 0) return 0;
        // get rid of whatever is overweight.
        if(weights.get(n - 1) > maxWeight)  return withoutDP(maxWeight, n - 1, weights, values);
        // compare the cases with/without item
        return Integer.max(values.get(n - 1) + withoutDP(maxWeight - weights.get(n - 1), n - 1, weights, values)
        , withoutDP(maxWeight, n - 1, weights, values));
    }

    public static int withDP(int maxWeight, List<Integer> weights, List<Integer> values){
        List<List<Integer>> cache = new ArrayList<>(weights.size() + 1);
        for(int i = 0; i <= weights.size(); i++){
            cache.add(new ArrayList<>(Collections.nCopies(maxWeight + 1, 0)));
        }
        for(int i = 1; i <= weights.size(); i++) {
            int weight = weights.get(i - 1);
            int value = values.get(i - 1);
            for (int j = 1; j <= maxWeight; j++) {
                if(j >= weight){
                    cache.get(i).set(j, Integer.max(cache.get(i - 1).get(j), cache.get(i - 1).get(j - weight) + value));
                } else {
                    cache.get(i).set(j, cache.get(i - 1).get(j));
                }
            }
        }
        System.out.println(cache);
        return cache.get(weights.size()).get(maxWeight);
    }
}
