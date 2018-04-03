import java.util.Arrays;

public class SplitEvenOddIndices {
    public static void perform(int[] input) {
        if(input.length < 2) return;
        int nextEven = 0;
        int nextOdd = input.length - 1;
        while(nextEven < nextOdd) {
            if((input[nextEven]&1) == 0) { // even index
                nextEven++;
            } else { // odd index
                int temp = input[nextOdd];
                input[nextOdd] = input[nextEven];
                input[nextEven] = temp;
                nextOdd--;
            }
            
        }
    }
    
    public static void main(String[] args) {
        int[] input = new int[] {101,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(input));
        perform(input);
        System.out.println(Arrays.toString(input));
    }
}
