package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfWaysToMoveFromTopLeftToBottomRight {
    public static void main(String[] args) {
        System.out.println(perform(6));
    }

    public static int perform(int n){
        List<List<Integer>> result = new ArrayList<>(n);
        for(int i = 0; i <= n; i++){
            if(i == 0) result.add(new ArrayList<>(Collections.nCopies(n, 1)));
            else {
                result.add(new ArrayList<>(Collections.nCopies(n, 0)));
                result.get(i).set(0, 1);
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                int top = result.get(i - 1).get(j);
                int left = result.get(i).get(j - 1);
                result.get(i).set(j, top + left);
            }
        }
        return result.get(n - 1).get(n - 1);
    }
}
