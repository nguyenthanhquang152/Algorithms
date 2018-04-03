package preparation.chapter12;

import java.util.Arrays;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
        System.out.println(binarySearch(input, 243));
        Integer a = 128;
        Integer b = 128;
        System.out.println(b == a);
    }

    public static int binarySearch(List<Integer> input, int k){
        int left = 0;
        int right = input.size() - 1;
        int initalIndex = -1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(input.get(mid) == k) {
                initalIndex = mid;
                right = mid - 1;
            }
            else if(input.get(mid) > k) right = mid - 1;
            else left = mid + 1;
        }
        return initalIndex;
    }
}
