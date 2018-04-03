package preparation.chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
        System.out.println(search(input));
    }

    public static int search(List<Integer> input){
        int left = 0;
        int right = input.size() - 1;
        List<Integer> processed = new ArrayList<>(input.size());
        for(int i=0; i<input.size(); i++){
            processed.add(input.get(i) - i);
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            if(processed.get(mid) ==  0) return mid;
            else if(processed.get(mid) < 0) {
                    left = mid + 1;
            }
            else {
                    right = mid - 1;
            }
        }
        return -1;
    }
}
