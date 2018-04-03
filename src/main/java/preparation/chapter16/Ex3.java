package preparation.chapter16;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        Deque<List<Integer>> result = listPermutations(Arrays.asList(2,3,5));
        System.out.println(result);
        List<List<Integer>> optimizedResult = optimizedListPermutations(Arrays.asList(2,3,5));
        System.out.println(optimizedResult);
    }

    public static Deque<List<Integer>> listPermutations(List<Integer> input){
        Deque<List<Integer>> result = new LinkedList<>();
        result.addFirst(new ArrayList<>());
        helper(input, 0, result);
        return result;
    }

    public static void helper(List<Integer> input, int idx, Deque<List<Integer>> result){

        if(idx < input.size()){
            Deque<List<Integer>> temp = new LinkedList<>();
            while(!result.isEmpty()){
                List<Integer> currentAcc = result.removeFirst();
                for(int i = 0; i<=idx; i++){
                    List<Integer> copied = new ArrayList<>(currentAcc);
                    copied.add(i, input.get(idx));
                    temp.addFirst(copied);
                }
            }
            result.addAll(temp);
            helper(input, idx + 1, result);
        }
    }

    public static List<List<Integer>> optimizedListPermutations(List<Integer> input){
        Collections.sort(input);
        List<List<Integer>> result = new LinkedList<>();
        do {
            result.add(input);
            input = preparation.chapter6.Ex10.nextPermutation(input);
        } while (!input.isEmpty());
        return result;
    }
}
