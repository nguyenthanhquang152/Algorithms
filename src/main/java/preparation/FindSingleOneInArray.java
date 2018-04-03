package preparation;

import java.util.*;

public class FindSingleOneInArray {
    public static void main(String[] args) {
        Integer[] input = new Integer[] {
                4,3,1,3,2,1,2,5,6,6,4,7,5
        };
        System.out.println(actionWithHashMap(input));
        System.out.println(actionWithSet(input));
        System.out.println(actionWithXOR(input));

    }

    private static int actionWithHashMap(Integer[] input) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int item : input){
            if(visited.get(item) == null){
                visited.put(item, 1);
            } else {
                visited.put(item, 2);
            }
        }
        Integer[] sums = visited.entrySet().stream()
                .map(entry -> new Integer[]{entry.getKey(), entry.getValue()})
                .reduce(new Integer[] {0,0}, (a, b) -> {
            a[0] = a[0] + b[0];
            a[1] = a[1] + (b[0] * b[1]);
//            System.out.println(b[0] + " - " + b[1] + " : " + Arrays.toString(a));
            return a;
        });
        return sums[0] * 2 - sums[1];
    }

    private static int actionWithSet(Integer[] input) {
        List<Integer> items =  Arrays.asList(input);
        Set<Integer> distincts = new HashSet<>(items);
        Integer sumOfDistincts = distincts.stream().reduce(0, Integer::sum);
        Integer sumOfItems = items.stream().reduce(0, Integer::sum);
        return sumOfDistincts * 2 - sumOfItems;
    }

    private static int actionWithXOR(Integer[] input){
        return Arrays.asList(input).stream().reduce(0, (a, b) -> a ^ b);
    }
}
