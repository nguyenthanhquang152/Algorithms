import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizedDoupleBuyAndSellStocksByForwardAndBackwardLooping {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(12,11,13,9,12,8,14,13,15);
        perform(input).forEach(buySellStock -> System.out.println(buySellStock));
    }
    
    public static List<List<Integer>> perform(List<Integer> input) {
        Integer maxProfitSoFar = 0;
        Integer minPriceSoFar = Integer.MAX_VALUE;
        Integer minPriceIndexSoFar = -1;
        Integer buyIndex = 0;
        Integer sellIndex = 0;
        ArrayList<List<Integer>> firstBuySell = new ArrayList<>();
        // loop forward through input to get the max profit for each day price to the min price so far.
        for(int i=0; i<input.size(); i++) {
            if(input.get(i) < minPriceSoFar) {
                minPriceSoFar = input.get(i);
                minPriceIndexSoFar = i;
            }
            int curMaxProfit = input.get(i) - minPriceSoFar;
            if(curMaxProfit > maxProfitSoFar) {
                maxProfitSoFar = curMaxProfit;
                sellIndex = i;
                buyIndex = minPriceIndexSoFar;
            }
            firstBuySell.add(new ArrayList<>(Arrays.asList(buyIndex, sellIndex, maxProfitSoFar)));
        }
        firstBuySell.forEach(buySellStock -> System.out.println(buySellStock));
        
        System.out.println("------------------------------");
        
        maxProfitSoFar = 0;
        Integer maxPriceSoFar = Integer.MIN_VALUE;
        buyIndex = input.size() - 1;
        sellIndex = input.size() - 1;
        Integer maxPriceIndexSoFar = -1;
        ArrayList<List<Integer>> secondBuySell = new ArrayList<>();
        // loop backward through input to get the max profit for each day price and to the max price so far.
        for(int i=input.size() - 1; i>=0; i--) {
            if(input.get(i) > maxPriceSoFar) {
                maxPriceSoFar = input.get(i);
                maxPriceIndexSoFar = i;
            }
            int curMaxProfit = maxPriceSoFar - input.get(i);
            if(curMaxProfit > maxProfitSoFar) {
                maxProfitSoFar = curMaxProfit;
                sellIndex = maxPriceIndexSoFar;
                buyIndex = i;
            }
            secondBuySell.add(0, new ArrayList<>(Arrays.asList(buyIndex, sellIndex, maxProfitSoFar)));
        }
        secondBuySell.forEach(buySellStock -> System.out.println(buySellStock));
        
        System.out.println("------------------------------");
        
        maxProfitSoFar = 0;
        // combine firstBuySell and secondBuySell
        List<List<Integer>> result = new ArrayList<>();

        if(result.isEmpty()) {
            result.add(Arrays.asList(-1, -1, 0));
            result.add(Arrays.asList(input.size() - 1, input.size() - 1, 0));
        }
        for(int i= (input.size() - 1); i>0; i--) {
            Integer curMaxProfit = firstBuySell.get(i - 1).get(2) + secondBuySell.get(i).get(2);
            if(curMaxProfit > maxProfitSoFar) {
                maxProfitSoFar = curMaxProfit;
                result.set(0, firstBuySell.get(i - 1));
                result.set(1, secondBuySell.get(i));
            }
        }
        return result;
        
    }

}
