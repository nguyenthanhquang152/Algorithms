package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CuttingRod {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(1,5,8,9,10,17,17,20);
        int rodLength = 8;
        System.out.println(cutRod(prices, rodLength));
        System.out.println(stupid(prices, rodLength));
    }

    public static int stupid(List<Integer> prices, int rodLength){
        if(rodLength <= 0) return 0;
        Integer maxProfix = Integer.MIN_VALUE;
        for(int i = 1; i <= rodLength; i++){
            maxProfix = Integer.max(maxProfix, prices.get(i - 1) + stupid(prices, rodLength - i));
        }
        return maxProfix;
    }

    public static int cutRod(List<Integer> prices, int rodLength){
        List<Integer> cache = new ArrayList<>(Collections.nCopies(rodLength + 1, 0));
        for(int priceIdx = 1; priceIdx < prices.size(); priceIdx++){
            int price = prices.get(priceIdx - 1);
            for(int i = priceIdx; i<=rodLength; i++){
                if(priceIdx == 0) System.out.print((i - priceIdx) + ":" + cache.get(i) + " - " + (cache.get(i - priceIdx) + price) + " - ");
                cache.set(i, Integer.max(cache.get(i), cache.get(i - priceIdx) + price));
                if(priceIdx == 0) System.out.println(cache.get(i));
            }
        }
        System.out.println(cache);
        return cache.get(rodLength);
    }
}
