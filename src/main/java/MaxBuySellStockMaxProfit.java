import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxBuySellStockMaxProfit {

    public static void main(String[] args) {
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        List<BuySell> result = perform(price);
        System.out.println(result);
    }
    
    public static List<BuySell> perform(int[] price){
        List<BuySell> result = new ArrayList<>();
        int i = 0;
        while(i<price.length) {
            while(i<(price.length - 1) && price[i+1] < price[i]) {
                i++;
            }
            if (i == price.length - 1)
                return Collections.emptyList();
            int buy = i++;
            while(i<price.length && price[i] > price[i-1]) {
                i++;
            }
            int sell = i-1;
            result.add(new BuySell(buy,sell));
        }
        return result;
    }
    
    public static class BuySell{
        public BuySell(int buy, int sell) {
            this.buy = buy;
            this.sell = sell;
        }
        int buy;
        int sell;
        
        @Override
        public String toString() {
            return "[Buy on day :" + buy + " Sell on day :" + sell + "]";
        }
        
    }

}
