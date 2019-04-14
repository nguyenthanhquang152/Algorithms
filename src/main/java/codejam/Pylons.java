package codejam;

import java.util.List;
import java.util.Scanner;

public class Pylons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTestcases =  Integer.parseInt(sc.nextLine());
        for(int i = 0; i < nTestcases; i++) {
            String[] rowColumn =  sc.nextLine().split(" ");
            int row = Integer.parseInt(rowColumn[0]);
            int column = Integer.parseInt(rowColumn[1]);
            process(i + 1, row, column);

        }
    }

    public static void process(int index, int row, int column) {
        if(row == 1 && column == 1){
            System.out.printf("Case #%d: %s\n", index, "POSSIBLE");
            System.out.printf("%d %d\n", row, column);
            return;
        }
        if(row <= 3 || column <= 3){
            System.out.printf("Case #%d: %s\n", index, "IMPOSSIBLE");
            return;
        }

        if(row % 2 == 1 && column % 2 == 1) {
            System.out.printf("Case #%d: %s\n", index, "IMPOSSIBLE");
            return;
        }

        // process valid cases
        // case 1: row is even and column is odd.
        if(row % 2 == 0) {
            System.out.printf("Case #%d: %s\n", index, "POSSIBLE");
            for (int nextPair = 0; nextPair < row; nextPair = nextPair + 2) {
                int nextRow = 1 + nextPair;
                int nextColumn = 1;
                int offsetColumn = column - 2;
                for (int iCell = 1; iCell <= (nextPair + 2) * column; iCell ++) {
                    System.out.printf("%d %d\n", nextRow, nextColumn);
                    if (nextRow % 2 == 1) {
                        nextRow++;
                    } else {
                        nextRow--;
                    }
                    nextColumn = (nextColumn + offsetColumn) > column ?
                            (nextColumn + offsetColumn) % column : (nextColumn + offsetColumn);

                }
            }
            return;
        }

        if(column % 2 == 0) {
            System.out.printf("Case #%d: %s\n", index, "POSSIBLE");
            for (int nextPair = 0; nextPair < column; nextPair = nextPair + 2) {
                int nextColumn = 1 + nextPair;
                int nextRow = 1;
                int offsetRow = row - 2;
                for (int iCell = 1; iCell <= (nextPair + 2) * row; iCell++) {
                    System.out.printf("%d %d\n", nextRow, nextColumn);
                    if(nextColumn % 2 == 1) {
                        nextColumn++;
                    } else {
                        nextColumn--;
                    }
                    nextRow = (nextRow + offsetRow) > row ? (nextRow + offsetRow) % row : (nextRow + offsetRow);
                }
            }
            return;
        }
    }
}
