import java.util.Arrays;

public class DutchFlagPartition {

    public static void main(String[] args) {
        int[] input = new int[] {0,1,2,0,2,1,1};
        System.out.println(Arrays.toString(input));
        performEPI(input, 6);
        System.out.println(Arrays.toString(input));
    }
    
    public static void perform(int[] input, int pivotIndex) {
        int nextEqualToPivotValue = 1;
        int nextLessThanPivotValue = 1;
        int nextGreaterThanPivotValue = input.length -1;
        int pivotValue = input[pivotIndex];
        // swap pivotIndex and first entry
        input[pivotIndex] = input[0];
        input[0] = pivotValue;
        while(nextEqualToPivotValue <= nextGreaterThanPivotValue) {
            while(nextEqualToPivotValue <= nextGreaterThanPivotValue && input[nextEqualToPivotValue] <= pivotValue) {
                if(input[nextEqualToPivotValue] < pivotValue) {
                    int temp = input[nextEqualToPivotValue];
                    input[nextEqualToPivotValue] = input[nextLessThanPivotValue];
                    input[nextLessThanPivotValue] = temp;
                    nextLessThanPivotValue++;
                }
                nextEqualToPivotValue++;
            }
            while(nextEqualToPivotValue <= nextGreaterThanPivotValue && input[nextGreaterThanPivotValue] > pivotValue) {
                nextGreaterThanPivotValue--;
            }
            if(nextEqualToPivotValue < nextGreaterThanPivotValue) {
                int temp = input[nextEqualToPivotValue];
                input[nextEqualToPivotValue] = input[nextGreaterThanPivotValue];
                input[nextGreaterThanPivotValue] = temp;
            }
        }
        int temp = input[0];
        input[0] = input[nextLessThanPivotValue - 1];
        input[nextLessThanPivotValue - 1] = temp;
    }
    
    public static void performEPI(int[] input, int pivotIndex) {
        int nextEqualToPivotValue = 0;
        int nextLessThanPivotValue = 0;
        int nextGreaterThanPivotValue = input.length - 1;
        int pivotValue = input[pivotIndex];
        while(nextEqualToPivotValue<=nextGreaterThanPivotValue) {
            if(input[nextEqualToPivotValue] == pivotValue) {
                nextEqualToPivotValue++;
            } else if(input[nextEqualToPivotValue] < pivotValue) {
                int temp = input[nextLessThanPivotValue];
                input[nextLessThanPivotValue] = input[nextEqualToPivotValue];
                input[nextEqualToPivotValue] = temp;
                nextEqualToPivotValue++;
                nextLessThanPivotValue++;
            } else {
                int temp = input[nextGreaterThanPivotValue];
                input[nextGreaterThanPivotValue] = input[nextEqualToPivotValue];
                input[nextEqualToPivotValue] = temp;
                nextGreaterThanPivotValue--;
            }
        }
    }

}
