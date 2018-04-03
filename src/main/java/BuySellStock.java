import java.util.Arrays;
import java.util.List;

public class BuySellStock {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250);
        System.out.println(perform(input));
    }
    
    public static List<Integer> perform(List<Integer> input) {
        Integer maxProfitSoFar = 0;
        Integer minPriceSoFar = Integer.MAX_VALUE;
        Integer buyIndex = -1;
        Integer sellIndex = -1;
        Integer minPriceIndexSoFar = -1;
        
        for(int i=0; i<input.size(); i++) {
            int curMinPrice = Integer.min(minPriceSoFar, input.get(i));
            if(curMinPrice < minPriceSoFar){
                minPriceIndexSoFar = i;
                minPriceSoFar = input.get(i);
            }
            int curMaxProfit = Integer.max(maxProfitSoFar, input.get(i) - minPriceSoFar);
            if(curMaxProfit > maxProfitSoFar) {
                maxProfitSoFar = curMaxProfit;
                sellIndex = i;
                buyIndex = minPriceIndexSoFar;
            }
        }
        
        return Arrays.asList(buyIndex, sellIndex, maxProfitSoFar);
    }
}
