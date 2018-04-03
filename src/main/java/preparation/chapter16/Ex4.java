package preparation.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<List<Integer>> result = powerSet(Arrays.asList(0,1,2));
        System.out.println(result);
        List<List<Integer>> optimizedResult = generatePowerSet(Arrays.asList(0,1,2));
        System.out.println(optimizedResult);
    }

    public static List<List<Integer>> powerSet(List<Integer> input){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        helper(input, 0, result);
        return result;
    }

    public static void helper(List<Integer> input, int idx, List<List<Integer>> result){
        if(idx < input.size()){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> curSet: result){
                List<Integer> copiedCur = new ArrayList<>(curSet);
                copiedCur.add(input.get(idx));
                temp.add(copiedCur);
            }
            if(!temp.isEmpty()) result.addAll(temp);
            helper(input, idx + 1, result);
        }
    }

    public static List<List<Integer>> generatePowerSet(List<Integer> input){
        double LOG_2 = Math.log(2);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < (1 << input.size()); i++){
            int bitArray = i;
            List<Integer> subset = new ArrayList<>();
            while(bitArray != 0){
                int idx = (int)(Math.log(bitArray & ~(bitArray - 1)) / LOG_2);
                subset.add(input.get(idx));
                bitArray &= bitArray - 1;
            }
            result.add(subset);
        }
        return result;
    }
}
