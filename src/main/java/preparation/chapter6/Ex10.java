package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<Integer> permutation = nextPermutation(Arrays.asList(6,2,1,5,4,3,0));
        System.out.println(permutation);

    }

    public static List<Integer> nextPermutation(List<Integer> input){
        List<Integer> permutation = new ArrayList<>(input);
        int k = permutation.size() - 2;// record the last P[k]<P[k+1]
        while(k >= 0 && permutation.get(k) >= permutation.get(k + 1)){
            k--;
        }
        // return empty list if input is the largest permutation.
        if(k<0) return Collections.emptyList();
        // Swap p[k] with p[l] where p[l] the minimal element after p[k] that is greater than p[k].
        boolean isSwapped = false;
        for(int l=permutation.size() - 1; l>k && !isSwapped; l--){
            if(permutation.get(l) > permutation.get(k)){
                Collections.swap(permutation, k, l);
                isSwapped = true;
            }
        }
        // Reverse the sublist after k. Why?
        // Because the sublist from k+1 to the end of permutation is in decreasing order,
        // we just reverse that sublist to get to sorted one.
        Collections.reverse(permutation.subList(k+1, permutation.size()));

        return permutation;
    }
}
