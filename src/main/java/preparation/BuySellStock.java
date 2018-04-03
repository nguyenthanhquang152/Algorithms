package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuySellStock {

    public static void main (String[] args) {
        Integer[] values = new Integer[]{
                0,2,4,1,6,5
        };
        System.out.println(Arrays.toString(maxOnceByTracingMinSofar(values)));
        System.out.println(Arrays.toString(maxOnceByTracingMaxSofar(values)));
        Arrays.asList(maxTwice(values)).forEach(row -> System.out.println(Arrays.toString(row)));

    }

    private static Integer[][] maxTwice(Integer[] values){
        List<Integer[]> firstDayBuySells = new ArrayList<>();
        Integer[] buySell = new Integer[]{0,0,Integer.MIN_VALUE};// 0: buyIndex, 1: sellIndex
        int minInxSofar = 0;
        for(int sellIndex = 0; sellIndex < values.length; sellIndex++){
            if(values[sellIndex] < values[minInxSofar]) minInxSofar = sellIndex;
            if(values[sellIndex] - values[minInxSofar] > buySell[2]){
                buySell[0] = minInxSofar;
                buySell[1] = sellIndex;
                buySell[2] = values[sellIndex] - values[minInxSofar];
            }
            firstDayBuySells.add(new Integer[]{buySell[0], buySell[1], buySell[2]});
        }

        List<Integer[]> secondDayBuySells = new ArrayList<>();
        buySell = new Integer[]{values.length - 1,values.length - 1, Integer.MIN_VALUE};
        int maxInxSofar = values.length - 1;
        for(int buyIndex = values.length - 1; buyIndex >= 0; buyIndex--){
            if(values[buyIndex] > values[maxInxSofar]) maxInxSofar = buyIndex;
            if(values[maxInxSofar] - values[buyIndex] > buySell[2]){
                buySell[0] = buyIndex;
                buySell[1] = maxInxSofar;
                buySell[2] = values[maxInxSofar] - values[buyIndex];
            }
            secondDayBuySells.add(0, new Integer[]{buySell[0], buySell[1], buySell[2]});
        }
        int length = values.length;
        Integer[][] result = new Integer[2][3];
        int maxProfitSofar = Integer.MIN_VALUE;
        for(int i=0; i<length - 1; i++){
            if(firstDayBuySells.get(i)[2] + secondDayBuySells.get(i+1)[2] > maxProfitSofar) {
                result = new Integer[][]{
                    firstDayBuySells.get(i), secondDayBuySells.get(i+1)
                };
                maxProfitSofar = firstDayBuySells.get(i)[2] + secondDayBuySells.get(i+1)[2];
            }
        }
        return result;
    }

    private static Integer[] maxOnceByTracingMaxSofar(Integer[] values){
        Integer[] buySell = new Integer[]{values.length - 1, values.length - 1};// 0: buyIndex, 1: sellIndex
        int maxProfitSofar = Integer.MIN_VALUE;
        int maxInxSofar = values.length - 1;
        for(int buyIndex = values.length - 1; buyIndex >= 0; buyIndex--){
            if(values[buyIndex] > values[maxInxSofar]) maxInxSofar = buyIndex;
            if(values[maxInxSofar] - values[buyIndex] > maxProfitSofar) {
                maxProfitSofar = values[maxInxSofar] - values[buyIndex];
                buySell[0] = buyIndex;
                buySell[1] = maxInxSofar;
            }
        }
        return buySell;
    }

    private static Integer[] maxOnceByTracingMinSofar(Integer[] values){
        Integer[] buySell = new Integer[]{0,0};// 0: buyIndex, 1: sellIndex
        int maxProfitSofar = Integer.MIN_VALUE;
        int minInxSofar = 0;
        for(int sellIndex = 0; sellIndex < values.length; sellIndex++){
            if(values[sellIndex] < values[minInxSofar]) minInxSofar = sellIndex;
            if(values[sellIndex] - values[minInxSofar] > maxProfitSofar){
                maxProfitSofar = values[sellIndex] - values[minInxSofar];
                buySell[0] = minInxSofar;
                buySell[1] = sellIndex;
            }
        }
        return buySell;
    }
}
