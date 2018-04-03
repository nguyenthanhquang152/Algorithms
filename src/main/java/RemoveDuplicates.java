import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,3,5,5,7,11,11,11,13);
        System.out.println(perform(input));
        System.out.println(input);
    }
     public static int perform(List<Integer> input) {
         if(input.isEmpty()) return 0;
         int lastIndex = input.size() - 1;
         int curDupValue = input.get(0);
         int nextValid = 1;
         for(int i=1; i<=lastIndex; i++) {
             if(input.get(i) != curDupValue && input.get(i) > 0 ) {
                 curDupValue = input.get(i);
                 input.set(nextValid, curDupValue);
                 if(i != nextValid) {
                     input.set(i, 0);
                 }
                 nextValid++;
             } else {
                 input.set(i, 0);
             }
         }
         return nextValid;
     }
}
