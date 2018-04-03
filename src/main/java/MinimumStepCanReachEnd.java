import java.util.Arrays;
import java.util.List;

public class MinimumStepCanReachEnd {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3,3,1,0,2,0,1);
        System.out.println(perform(input));
    }
    
    public static int perform(List<Integer> input) {
        int furthestSoFar = 0;
        int lastIndex = input.size();
        int minSteps = 0;
        for(int i=0; i<=furthestSoFar && furthestSoFar<lastIndex; i++) {
            int maxFurthestSoFar = Math.max(furthestSoFar, i + input.get(i));
            System.out.println(i + " - "+ furthestSoFar + " - " + maxFurthestSoFar);
            if(maxFurthestSoFar > furthestSoFar) {
                minSteps++;
            }
            furthestSoFar = maxFurthestSoFar;
        }
        return furthestSoFar >= lastIndex? minSteps : -1;
    }
}
