package preparation.chapter12;

import java.util.Arrays;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(279, 368, 378, 478, 550, 631, 103, 203, 220, 234);
        System.out.println(minIndex(input, 0 , input.size() - 1));
        System.out.println(minIndex(input));
    }
    public static int minIndex(List<Integer> input){
        int left = 0, right = input.size() - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(input.get(mid) > input.get(right)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int minIndex(List<Integer> input, int left, int right){
        if(right - left == 1) return Integer.compare(input.get(right), input.get(left)) > 0 ? left : right;
        if(left == right) return left;
        int mid = left + (right - left)/2;
        int leftDif = input.get(mid -1) - input.get(mid);
        int rightDif = input.get(mid + 1)- input.get(mid);
        if(leftDif > 0 && rightDif > 0) return mid;
        if(leftDif < 0 && rightDif < 0) return leftDif < rightDif ? mid - 1 : mid + 1;
        int leftInx = minIndex(input, left, mid - 1);
        int rightInx = minIndex(input, mid + 1, right);
        return Integer.compare(input.get(leftInx), input.get(rightInx)) < 0 ? leftInx : rightInx;
    }
}
