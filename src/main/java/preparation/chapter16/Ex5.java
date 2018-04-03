package preparation.chapter16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex5 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pickKfromN(int k, int n){
        if(k > n) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    public static void helper(int k, int n, int offset
            , List<Integer> partialCombination, List<List<Integer>> result){
        if(partialCombination.size() == k){
            result.add(new ArrayList<>(partialCombination));
        } else {
            final int numOfRemainings = k - partialCombination.size();
            for(int i = offset; i <= n && numOfRemainings <= n - i + 1; i++){
                partialCombination.add(i);
                helper(k, n, i + 1, partialCombination, result);
                partialCombination.remove(partialCombination.size() - 1);
            }
        }
    }
}
