package ideserve;

/**
 * Find a peak element in an array(1-2 d)
 */
public class Ex3 {
    public static int solution1D(int[] array, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;
        int leftMid = (mid - 1) < 0 ? Integer.MIN_VALUE: array[mid - 1];
        int rightMid = (mid + 1) > (array.length - 1) ? Integer.MIN_VALUE: array[mid + 1];
        if(leftMid <= array[mid] && rightMid <= array[mid]) return mid;
        if(leftMid > array[mid]) return solution1D(array, start, mid - 1);
        else return solution1D(array, mid + 1, end);
    }

    public static int[] solution2D(int[][] matrix, int startCol, int endCol){
        int midCol = (startCol + endCol) / 2;
        int midRow = findMaxInCol(matrix, midCol);
        int leftMidRowVal = (midCol - 1) < 0 ? Integer.MIN_VALUE : matrix[midRow][midCol - 1];
        int rightMidRowVal = (midCol + 1) > (matrix.length - 1) ? Integer.MIN_VALUE : matrix[midRow][midCol + 1];
        if(leftMidRowVal <= matrix[midRow][midCol] && rightMidRowVal <= matrix[midRow][midCol])
            return new int[] {midRow, midCol};
        if(leftMidRowVal > matrix[midRow][midCol]) return solution2D(matrix, startCol, midCol - 1);
        else return solution2D(matrix, midCol + 1, endCol);
    }

    public static int[] linearSolution2D(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        int midCol = (startCol + endCol) / 2;
        int maxMidRow = findMaxInColByRangeRow(matrix, startRow, endRow, midCol);
        int midRow = (startRow + endRow) / 2;
        int maxMidCol = findMaxInRowByRangeCol(matrix, startCol, endCol, midRow);
        if(matrix[maxMidRow][midCol] > matrix[midRow][maxMidCol]) {
            int leftMidRowVal = (midCol - 1) < 0 ? Integer.MIN_VALUE : matrix[maxMidRow][midCol - 1];
            int rightMidRowVal = (midCol - 1) > (matrix.length - 1) ? Integer.MIN_VALUE : matrix[maxMidRow][midCol + 1];
            if (leftMidRowVal <= matrix[maxMidRow][midCol] && rightMidRowVal <= matrix[maxMidRow][midCol])
                return new int[]{maxMidRow, midCol};
            int[] rowRange = maxMidRow < midRow ? new int[]{startRow, midRow - 1} : new int[]{midRow + 1, endRow};
            if(leftMidRowVal > matrix[maxMidRow][midCol])
                return linearSolution2D(matrix, rowRange[0], rowRange[1], startCol, midCol - 1);
            else return linearSolution2D(matrix, rowRange[0], rowRange[1], midCol + 1 , endCol);
        } else {
            int leftMidColVal = (midRow - 1) < 0 ? Integer.MIN_VALUE : matrix[midRow - 1][maxMidCol];
            int rightMidColVal = (midRow + 1) > (matrix.length - 1) ? Integer.MIN_VALUE : matrix[midRow + 1][maxMidCol];
            if (leftMidColVal <= matrix[midRow][maxMidCol] && rightMidColVal <= matrix[midRow][maxMidCol])
                return new int[]{midRow, maxMidCol};
            int[] colRange = maxMidCol < midCol ? new int[]{startCol, midCol - 1} : new int[]{midCol + 1, endCol};
            if(leftMidColVal > matrix[midRow][maxMidCol])
                return linearSolution2D(matrix, startRow, midRow - 1, colRange[0], colRange[1]);
            else return linearSolution2D(matrix, midRow + 1, endRow, colRange[0], colRange[1]);
        }

    }

    private static int findMaxInColByRangeRow(int[][] matrix, int startRow, int endRow, int col){
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        for(int i = startRow; i <= endRow; i++){
            if(max < matrix[i][col]) {
                max = matrix[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }

    private static int findMaxInRowByRangeCol(int[][] matrix, int startCol, int endCol, int row){
        int max = Integer.MIN_VALUE;
        int maxCol = -1;
        for(int i = startCol; i <= endCol; i++){
            if(max < matrix[row][i]){
                max = matrix[row][i];
                maxCol = i;
            }
        }
        return maxCol;
    }

    private static int findMaxInCol(int[][] matrix, int col) {
        int length = matrix.length;
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        for(int i = 0; i < length; i++){
            if(max < matrix[i][col]) {
                max = matrix[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }

    public static void main(String[] arg){
        int[] array = new int[]{5, 10, 15, 25, 30, 45, 65, 50, 35, 1};
        System.out.println(solution1D(array, 0, array.length - 1));

        int[][] matrix = new int[][]{
                  {1, 2, 3, 4, 5}
                , {1, 9, 7, 5, 3}
                , {2, 3, 6, 5, 3}
                , {3, 2, 4, 8, 1}
                , {1, 9, 2, 3, 7}
        };
        int[] pos = solution2D(matrix, 0, matrix.length - 1);
        System.out.println(pos[0] + " " + pos[1]);
        System.out.println(matrix[pos[0]][pos[1]]);

        pos = linearSolution2D(matrix, 0, matrix.length - 1, 0, matrix.length - 1);
        System.out.println(pos[0] + " " + pos[1]);
        System.out.println(matrix[pos[0]][pos[1]]);
    }

}
