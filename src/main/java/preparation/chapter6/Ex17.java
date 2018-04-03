package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex17 {
    public static void main(String[] args) {
        List<List<Integer>> board = Arrays.asList(
                Arrays.asList(1,2,3,4)//1
                , Arrays.asList(5,6,7,8)//2
                , Arrays.asList(9,10,11,12)//3
                , Arrays.asList(13,14,15,16)//4
        );
        printSpiralOrder(board);

        board = Arrays.asList(
                Arrays.asList(1,2,3,4,5)//1
                , Arrays.asList(6,7,8,9,10)//2
                , Arrays.asList(11,12,13,14,15)//3
                , Arrays.asList(16,17,18,19,20)//4
                , Arrays.asList(21,22,23,24,25)//4
        );
        printSpiralOrder(board);
    }

    public static void printSpiralOrder(List<List<Integer>> board){
        List<Integer> spiralOrdering = new ArrayList<>();
        for(int offset = 0; offset < Math.ceil(0.5 * board.size()); offset++){
            goThroughOuter(board, offset, spiralOrdering);
        }
        System.out.println(spiralOrdering);
    }

    public static void goThroughOuter(List<List<Integer>> board, int offset, List<Integer> spiralOrdering){
        // if we at the central element, just get it.
        if(offset == board.size() - 1 - offset){
            spiralOrdering.add(board.get(offset).get(offset));
            return;
        }
        // top row
        for(int i=offset; i<board.size() - offset - 1; i++){
            spiralOrdering.add(board.get(offset).get(i));
        }
        // rightmost column
        for(int i=offset; i<board.size() - offset - 1; i++){
            spiralOrdering.add(board.get(i).get(board.size() - offset - 1));
        }
        // bottom row
        for(int i=board.size() - offset - 1; i>offset; i--){
            spiralOrdering.add(board.get(board.size() - offset - 1).get(i));
        }
        // leftmost column
        for(int i=board.size() - offset - 1; i>offset; i--){
            spiralOrdering.add(board.get(i).get(offset));
        }
    }

}
