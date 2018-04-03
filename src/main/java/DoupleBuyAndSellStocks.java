import java.util.Arrays;
import java.util.List;

public class DoupleBuyAndSellStocks {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(310, 319, 314, 320, 312, 315);
        List<Integer> bestProfitBuySell = perform(input);
        System.out.println(bestProfitBuySell);
        // find the max profit in leftInput
        List<Integer> leftInput = input.subList(0, bestProfitBuySell.get(0));
        System.out.println(leftInput);
        List<Integer> leftBestProfitBuySell = perform(leftInput);
        System.out.println(leftBestProfitBuySell);
        // find the max profit in rightInput
        List<Integer> rightInput = input.subList(bestProfitBuySell.get(1)+1, input.size());
        System.out.println(rightInput);
        List<Integer> rightBestProfitBuySell = perform(rightInput);
        // add offset to rightBestProfit
        rightBestProfitBuySell.set(0, rightBestProfitBuySell.get(0) + bestProfitBuySell.get(1) + 1);
        rightBestProfitBuySell.set(1, rightBestProfitBuySell.get(1) + bestProfitBuySell.get(1) + 1);
        System.out.println(rightBestProfitBuySell);
        
        // compare profits of left and right subarrays
        List<List<Integer>> result = leftBestProfitBuySell.get(2) > rightBestProfitBuySell.get(2) ?
                Arrays.asList(leftBestProfitBuySell, bestProfitBuySell) :
                    Arrays.asList(bestProfitBuySell, rightBestProfitBuySell);
                
        result.forEach(buySell -> System.out.println(buySell));
        System.out.println(result.get(0).get(2) + result.get(1).get(2));
        
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
