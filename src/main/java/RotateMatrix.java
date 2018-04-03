import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][] {
            new int[] {1,2,3,4},
            new int[] {5,6,7,8},
            new int[] {9,10,11,12},
            new int[] {13,14,15,16}
        };
        perform(input);
        Arrays.stream(input).forEach(row -> System.out.println(Arrays.toString(row)));
    }
    
    public static void perform(int[][] input) {
        int matrixSize = input.length - 1;
        for(int i=0; i<(input.length / 2); i++) {
            for(int j=0; j<matrixSize; j++) {
                int temp1 = input[matrixSize - j][i];
                int temp2 = input[matrixSize - i][matrixSize - j]; 
                int temp3 = input[j][matrixSize - i];
                int temp4 = input[i][j]; 
                input[i][j] = temp1;
                input[matrixSize - j][i] = temp2; 
                input[matrixSize - i][matrixSize - j] = temp3; 
                input[j][matrixSize - i] = temp4;
            }
        }
    }
}
