package preparation.chapter6;

import java.util.Arrays;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        List<Integer> locations = Arrays.asList(2,4,1,1,0, 2,3);
        int furthestLocation = 0;
        for(int i=0; i<=furthestLocation && furthestLocation<locations.size() - 1; i++){
            // get the furthest location so far
            furthestLocation = Math.max(i + locations.get(i) , furthestLocation);
        }
        if (furthestLocation >= locations.size() - 1 ) System.out.println("Can reach to the destination.");
        else System.out.println("You lost.");
        System.out.println(furthestLocation);
    }
}
