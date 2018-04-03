package preparation.chapter12;

import java.util.Arrays;
import java.util.List;

public class Ex9 {
    public static void main(String[] args) {
        List<Integer> full = Arrays.asList(0,1,2,3,4,5);
        List<Integer> dup = Arrays.asList(0,1,2,3,4,5,3);
        int xf = full.get(0), xd = dup.get(0);
        for(int i = 1; i<full.size(); i++) {
            xf = xf ^ full.get(i);
        }

        for(int i = 1; i<dup.size(); i++) {
            xd = xd ^ dup.get(i);
        }
        System.out.println(xd ^ xf);
    }
}
