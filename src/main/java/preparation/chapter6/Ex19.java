package preparation.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Ex19 {
    public static void main(String[] args) {
        int rows = 5;
        List<List<Integer>> result = new ArrayList<>(rows);
        for(int i=0; i<rows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i) row.add(1);
                else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        System.out.println(result);
    }
}
