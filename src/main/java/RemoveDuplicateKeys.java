import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateKeys {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,3,5,7,5,11,11,13,11,11);
        System.out.println(perform(input, 11));
        System.out.println(input);

    }
    
    public static int perform(List<Integer> input, int key) {
        if(input.isEmpty()) return 0;
        int lastIndex = input.size()-1;
        int nextValid = 0;
        for(int i=0; i<=lastIndex; i++) {
            if(input.get(i) != key && input.get(i) > 0) {
               input.set(nextValid, input.get(i));
               if(nextValid != i) {
                   input.set(i, 0);
               }
               nextValid++;
            } else {
                input.set(i, 0);
            }
        }
        return input.size() - nextValid;
    }

}
