package preparation.chapter13;

import java.util.*;

public class Ex10 {
    public static void main(String[] args) {
        Set<Integer> data = new HashSet<>(Arrays.asList(3,-2,7,9,8,1,2,0,-1,5,8));
        System.out.println(findLargestRange(data));

    }

    public static List<Integer> findLargestRange(Set<Integer> data){
        Set<Integer> copied = new HashSet<>(data);
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));
        for(Integer item : data){
            if(copied.contains(item)){
                Integer upper = item;
                Integer lower = item;

                copied.remove(item);

                Integer pivot = item;
                while(copied.contains(++pivot)){
                    copied.remove(pivot);
                }
                if(pivot - 1 != item) upper = pivot - 1;

                pivot = item;
                while(copied.contains(--pivot)){
                    copied.remove(pivot);
                }
                if(pivot + 1 != item) lower = pivot + 1;
                if(upper - lower > result.get(1) - result.get(0)){
                    result.set(0, lower);
                    result.set(1, upper);
                }
            }
        }
        return result;
    }
}
