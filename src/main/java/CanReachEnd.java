import java.util.Arrays;
import java.util.List;

public class CanReachEnd {

    public static void main(String[] args) {
//        List<Integer> input = Arrays.asList(3,3,1,0,2,0,1);
        List<Integer> input = Arrays.asList(3,2,0,0,2,0,1);
        System.out.println(perform(input));
    }
    
    public static boolean perform(List<Integer> input) {
        int furthestSoFar = 0;
        int lastIndex = input.size() - 1;
        for(int i = 0; i<=furthestSoFar && furthestSoFar<lastIndex; i++) {
            furthestSoFar = Math.max(furthestSoFar, i + input.get(i));
        }
        return (furthestSoFar >= lastIndex);
    }

}
