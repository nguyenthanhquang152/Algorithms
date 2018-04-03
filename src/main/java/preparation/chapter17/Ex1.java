package preparation.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(numberOfCombinations(12, Arrays.asList(2,3,7)));
    }

    public static int numberOfCombinations(int input, List<Integer> units){
        List<Integer> cache = new ArrayList<>(Collections.nCopies(input + 1, 0));
        cache.set(0, 1);
        for(int unit : units){
            for(int i = 1; i < cache.size(); i++){
                if(i >= unit){
                    cache.set(i, cache.get(i) + cache.get(i - unit));
                }
            }
        }
        return cache.get(cache.size() - 1);
    }
}
