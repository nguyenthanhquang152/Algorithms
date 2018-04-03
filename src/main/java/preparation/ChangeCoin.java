package preparation;

import java.util.*;

public class ChangeCoin {
    public static void main(String[] args) {
        System.out.println(numberOfChanges(Arrays.asList(3, 5, 10), 13));
        System.out.println(numberOfNonDistinctChanges(Arrays.asList(3, 5, 10), 13));
        List<Integer> denominations = Arrays.asList(1, 5, 10, 25, 50, 100);
        System.out.println(minOfNotes(denominations, 99));
        System.out.println(numberOfChanges(denominations, 100));
        System.out.println(numberOfChanges(denominations, denominations.size() - 1, 100, new HashMap<>()));
    }

    public static int minOfNotes(List<Integer> denominations, int money){
        List<Integer> minSoFar = new ArrayList<>(Collections.nCopies(money + 1, Integer.MAX_VALUE));
        minSoFar.set(0, 0);
        for(int i = 1; i <= money; i++){
            for(int denomination : denominations){
                int res = Integer.MAX_VALUE;
                if(i - denomination >= 0){
                    res = minSoFar.get(i - denomination);
                }

                if(res != Integer.MAX_VALUE){
                    minSoFar.set(i, Integer.min(res + 1, minSoFar.get(i)));
                }
            }
        }
        return minSoFar.get(money);
    }

    public static int numberOfChanges(List<Integer> denominations, int money){
        List<Integer> combinations = new ArrayList<>(Collections.nCopies(money + 1, 0));
        combinations.set(0, 1);
        for(int denomination : denominations){
            for(int i = 1; i < combinations.size(); i++){
                if(i >= denomination){
                    combinations.set(i, combinations.get(i) + combinations.get(i - denomination));
                }
            }
        }
        return combinations.get(money);
    }

    public static int numberOfNonDistinctChanges(List<Integer> denominations, int money){
        List<Integer> combinations = new ArrayList<>(Collections.nCopies(money + 1, 0));
        combinations.set(0, 1);
        for(int i = 1; i < combinations.size(); i++){
            for(int denomination: denominations){
                if(i >= denomination){
                    combinations.set(i, combinations.get(i) + combinations.get(i - denomination));
                }
            }
        }
        return combinations.get(money);
    }

    public static int numberOfChanges(List<Integer> denominations, int nFirstCoins, int money, Map<String, Integer> cache){
        if(money == 0) return 1;
        if(money < 0 || nFirstCoins < 0) return 0;

        String key = money + "-" + nFirstCoins;
        if(!cache.containsKey(key)){
            int includeCurrentCoin =
                    numberOfChanges(denominations, nFirstCoins, money - denominations.get(nFirstCoins), cache);
            int excludeCurrentCoint = numberOfChanges(denominations, nFirstCoins - 1, money, cache);
            cache.put(key, includeCurrentCoin + excludeCurrentCoint);
        }
        return cache.get(key);

    }
}
