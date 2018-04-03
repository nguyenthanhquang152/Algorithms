package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex16 {
    public static void main(String[] args) {
        List<List<Integer>> board = Arrays.asList(
                  Arrays.asList(5,3,0,0,7,0,0,0,0)//1
                , Arrays.asList(6,0,0,1,9,5,0,0,0)//2
                , Arrays.asList(0,9,8,0,0,0,0,6,0)//3
                , Arrays.asList(8,0,0,0,6,0,0,0,3)//4
                , Arrays.asList(4,0,0,8,0,3,0,0,1)//5
                , Arrays.asList(7,0,0,0,2,0,0,0,6)//6
                , Arrays.asList(0,6,0,0,0,0,2,8,0)//7
                , Arrays.asList(0,0,0,4,1,9,0,0,5)//8
                , Arrays.asList(0,0,0,0,8,0,0,7,9)//9
        );
        System.out.println(isValidBoard(board));
    }

    public static boolean isValidBoard(List<List<Integer>> board){
        // Check row constraints
        for(int i=0; i<board.size(); i++){
            if(hasDuplicates(board, i, i + 1, 0, board.size() )) return false;
        }

        // Check column constraints
        for(int i=0; i<board.size(); i++){
            if(hasDuplicates(board,0, board.size(), i, i + 1)) return false;
        }

        // Check region constraints
        int regionSize = (int)Math.sqrt(board.size());
        for(int iRow = 0; iRow < regionSize; iRow++){
            for(int iCol = 0; iCol < regionSize; iCol++){
                if(hasDuplicates(board, iRow * regionSize, (iRow + 1) * regionSize
                , iCol * regionSize, (iCol + 1) * regionSize)) return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(List<List<Integer>> board
            , int startRow, int endRow
            , int startCol, int endCol){
        List<Boolean> tracked = new ArrayList<>(Collections.nCopies(board.size() + 1, false));
        for(int iRow = startRow; iRow < endRow; iRow++){
            for(int iCol = startCol; iCol < endCol; iCol++){
                if(board.get(iRow).get(iCol) != 0 && tracked.get(board.get(iRow).get(iCol))){
                    return true;
                }
                tracked.set(board.get(iRow).get(iCol), true);
            }
        }
        return false;
    }
}
