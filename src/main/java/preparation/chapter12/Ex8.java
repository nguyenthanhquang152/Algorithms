package preparation.chapter12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Ex8 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8);
        if((input.size() & 1) == 1){
            System.out.println(findKthLargest(input, (input.size() + 1)/2));
        } else {
            System.out.println(findKthLargest(input, (input.size() + 2)/2));
        }
    }

    public static int findKthLargest(List<Integer> input, int k){
        int left = 0, right = input.size() - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int pivot = partition(input, mid, 0, right);
            if(pivot == k - 1) return input.get(pivot);
            else if(pivot > k - 1) right = pivot - 1;
            else left = pivot + 1;
        }
        throw new NoSuchElementException("No k-th largest element in input");
    }

    private static int partition(List<Integer> input, int pivotIdx, int left, int right){
        int pivotValue = input.get(pivotIdx);
        int newPivotIdx = left + 1;
        Collections.swap(input, pivotIdx, left);
        while(newPivotIdx <= right){
            if(Integer.compare(input.get(newPivotIdx), pivotValue) > 0) {
                newPivotIdx++;
            } else {
                Collections.swap(input, newPivotIdx, right--);
            }
        }
        Collections.swap(input, newPivotIdx - 1, left);
        return newPivotIdx - 1;
    }
}
