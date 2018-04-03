package preparation;


import java.util.*;

public class FindMissingAndDuplicateElements {
    public static void main(String[] args) {
        System.out.println(perform(Arrays.asList(1,2,3,4,5,6), Arrays.asList(5,2,3,4,5,6)));
    }

    public static Collection<Integer> perform(List<Integer> list1, List<Integer> list2){
        Integer xorList1 = list1.stream().reduce(0, (x, y) -> x ^ y);
        Integer xorList2 = list2.stream().reduce(0, (x, y) -> x ^ y);
        Set<Integer> set1 = new HashSet<>(list1);
        set1.removeAll(list2);
        Integer missing = set1.iterator().next();
        Integer duplicate = missing ^ xorList1 ^ xorList2;
        return Arrays.asList(missing, duplicate);
    }
}
