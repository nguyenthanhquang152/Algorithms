package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> flags = new ArrayList<>(Arrays.asList(
                0,1,2,0,2,1,1
        ));
        for(int pivot =0; pivot < flags.size(); pivot++) {
            flags = new ArrayList<>(Arrays.asList(
                    0,1,2,0,2,1,1
            ));
            partition(flags, pivot);
        }
    }

    private static void partition(List<Integer> flags, int pivot) {
        int nextLessThanPivot = 0;
        int nextEqualToPivot = 0;
        int nextGreaterThanPivot = flags.size() - 1;
        int pivotValue = flags.get(pivot);
        while(nextEqualToPivot <= nextGreaterThanPivot){
            if(flags.get(nextEqualToPivot) == pivotValue){
                nextEqualToPivot ++;
            } else if(flags.get(nextEqualToPivot) < pivotValue){
                Collections.swap(flags, nextEqualToPivot, nextLessThanPivot);
                nextLessThanPivot ++;
                nextEqualToPivot ++;
            } else {
                Collections.swap(flags, nextEqualToPivot, nextGreaterThanPivot);
                nextGreaterThanPivot --;
            }
        }
        System.out.println(flags);
    }
}
