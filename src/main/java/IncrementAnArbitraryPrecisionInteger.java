import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementAnArbitraryPrecisionInteger {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,1,8));
        perform(input);
        System.out.println(input);
    }
    
    public static void perform(List<Integer> input){
        // add the last element
        int lastIndex = input.size() - 1;
        input.set(lastIndex, input.get(lastIndex) + 1);
        while(lastIndex > 0 && input.get(lastIndex) == 10) {
            input.set(lastIndex, 0);
            input.set(lastIndex-1, input.get(lastIndex-1) + 1);
            lastIndex--;
        }
        
        if(lastIndex == 0 && input.get(lastIndex) == 10) {
            input.set(lastIndex, 0);
            input.add(0, 1);
        }
    }

}
