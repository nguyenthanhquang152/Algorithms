package preparation.chapter16;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        nonAttackingPlacements(5);
    }

    public static void nonAttackingPlacements(int nQueens){
        helper(nQueens, 0, new ArrayList<>(nQueens));
    }

    public static void helper(int nQueens, int row, List<Integer> colPlacements){
        if(nQueens == row) System.out.println(colPlacements);
        else {
            for(int i = 0; i < nQueens; i++){
                colPlacements.add(i);
                if(isValid(colPlacements)){
                    helper(nQueens, row + 1, colPlacements);
                }
                colPlacements.remove(colPlacements.size() - 1);
            }
        }
    }


    public static boolean isValid(List<Integer> colPlacements){
        int rowId = colPlacements.size() - 1;
        for(int i = 0; i < rowId; i++){
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
            if(diff == 0 || diff == rowId - i){
                return false;
            }
        }
        return true;
    }
}
