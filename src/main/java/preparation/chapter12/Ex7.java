package preparation.chapter12;


import java.util.Arrays;
import java.util.List;

public class Ex7 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 2, 5, 1, 2, 6);
        System.out.println(find(input));

    }

    public static MinMax find(List<Integer> input){
        if(input.size() == 1) return new MinMax(input.get(0), input.get(0));
        MinMax valuesSofar = MinMax.minMax(input.get(0), input.get(1));
        int i = 2;
        while(input.size() - i >= 2){
            MinMax nextPair = MinMax.minMax(input.get(i), input.get(i+1));
            valuesSofar =
                    new MinMax(Integer.min(nextPair.min, valuesSofar.min),
                            Integer.max(nextPair.max, valuesSofar.max));
            i += 2;
        }
        if(i < input.size()){
            valuesSofar =
                    new MinMax(Integer.min(input.get(i), valuesSofar.min),
                            Integer.max(input.get(i), valuesSofar.max));
        }
        return valuesSofar;
    }

    public static class MinMax{
        Integer min;
        Integer max;

        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        public static MinMax minMax(Integer a, Integer b) {
            return Integer.compare(a, b) == 1 ? new MinMax(b, a) : new MinMax(a,b);
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}
