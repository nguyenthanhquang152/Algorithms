package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(hasOrNot(Arrays.asList(3, 2, 7, 1), 6));
        System.out.println(hasOrNotDP(Arrays.asList(3, 2, 7, 1), 6));
    }
    public static boolean hasOrNot(List<Integer> input, int sum){
        return helper(input, sum, 0);
    }

    public static boolean helper(List<Integer> input, int sum, int idx){
        if(sum == 0) return true;
        if(idx == input.size()) return false;
        if(input.get(idx) > sum) return helper(input, sum, idx + 1);
        return helper(input, sum - input.get(idx), idx + 1) ||
                helper(input, sum, idx + 1);
    }

    public static boolean hasOrNotDP(List<Integer> input, int sum){
        List<List<Boolean>> cache = new ArrayList<>(input.size());
        for(int i=0; i<input.size(); i++){
            cache.add(new ArrayList<>(Collections.nCopies(sum + 1, false)));
        }
        for(int i=0; i<input.size(); i++){
            cache.get(i).set(0, true);
        }
        cache.get(0).set(3, true);
        System.out.println(cache.get(0));
        for(int i = 1; i < input.size(); i++){
            int val = input.get(i);
            for(int j = 1; j<=sum; j++){
                if(j >= val){
                    cache.get(i).set(j, cache.get(i - 1).get(j) || cache.get(i - 1).get(j - val));
                }
            }
            System.out.println(cache.get(i));
        }
        return cache.get(input.size() - 1).get(sum);
    }



}
