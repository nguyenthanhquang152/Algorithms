import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleBuySellStockSplitToSubArrays {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(310, 319, 314, 320, 312, 315);
        List<List<Integer>> buySellTwice = new ArrayList<>();
        for(int i=1; i<input.size() - 2; i++) {
            List<Integer> leftInput = input.subList(0, i+1);
            List<Integer> rightInput = input.subList(i+1, input.size());
            List<Integer> leftResult = perform(leftInput);
            List<Integer> rightResult = perform(rightInput);
            rightResult.set(0, rightResult.get(0) + i + 1);
            rightResult.set(1, rightResult.get(1) + i + 1);
            if(buySellTwice.isEmpty() ){
                buySellTwice.add(leftResult);
                buySellTwice.add(rightResult);
            }
            if(buySellTwice.get(0).get(2) + buySellTwice.get(1).get(2) < leftResult.get(2) + rightResult.get(2)){
                      buySellTwice.set(0, leftResult);
                      buySellTwice.set(1, rightResult);
            }
        }
        buySellTwice.forEach(buySell -> System.out.println(buySell));
    }
    
    public static List<Integer> perform(List<Integer> input) {
        if(input.size() < 2) return Arrays.asList(-1,-1,0);
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
