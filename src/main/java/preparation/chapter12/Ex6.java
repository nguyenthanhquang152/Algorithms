package preparation.chapter12;

import java.util.Arrays;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(-1, 2, 4, 4, 6),
                Arrays.asList(1, 5, 5, 9, 21),
                Arrays.asList(3, 6, 6, 9, 22),
                Arrays.asList(3, 6, 8, 10, 24),
                Arrays.asList(6, 8, 9, 12, 25),
                Arrays.asList(8, 10, 12, 13, 40)
        );
        System.out.println(find(matrix, 40 ));
    }

    public static List<Integer> find(List<List<Integer>> m, int k){
        int nextRow = 0, nextCol = m.get(0).size() - 1;
        while(nextRow < m.size() && nextCol >= 0){
            if(m.get(nextRow).get(nextCol) == k) return Arrays.asList(nextRow, nextCol);
            else if(m.get(nextRow).get(nextCol) > k) nextCol--;
            else nextRow++;
        }
        return Arrays.asList(-1, -1);
    }
}
