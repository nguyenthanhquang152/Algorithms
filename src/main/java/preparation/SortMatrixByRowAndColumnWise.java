package preparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMatrixByRowAndColumnWise {
    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(12, 7, 1, 8),
                Arrays.asList(20, 9, 11, 2),
                Arrays.asList(15, 4, 5, 13),
                Arrays.asList(3, 18, 10, 6)
        );
        sort(matrix);
        System.out.println(matrix);
    }

    public static void sort(List<List<Integer>> matrix){
        // sort all rows
        sortRows(matrix);
        // transpose matrix
        transpose(matrix);
        // sort all transposed matrix
        sortRows(matrix);
        // re-transpose matrix
        transpose(matrix);
    }

    private static void transpose(List<List<Integer>> matrix){
        for(int row = 0; row < matrix.size(); row++){
            for(int col = row + 1; col < matrix.size(); col++){
                int temp = matrix.get(row).get(col);
                matrix.get(row).set(col, matrix.get(col).get(row));
                matrix.get(col).set(row, temp);
            }
        }
    }

    private static void sortRows(List<List<Integer>> matrix){
        for(List<Integer> row : matrix){
            Collections.sort(row);
        }
    }
}
