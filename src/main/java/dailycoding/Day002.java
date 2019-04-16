package dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day002 {
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(productListExcludeIndex(input));
        System.out.println(productListExcludeIndexNonDiv(input));

    }

    public static List<Integer> productListExcludeIndex(List<Integer> input){
        if(input == null || input.size() == 0) {
            return Collections.emptyList();
        }
        Integer totalProduct = input.stream().reduce(1, (Integer a, Integer b) -> a * b);
        return input.stream().map(value -> totalProduct / value).collect(Collectors.toList());

    }

    public static List<Integer> productListExcludeIndexNonDiv(List<Integer> input){
        if(input == null || input.size() == 0){
            return Collections.emptyList();
        }
        int size = input.size();
        List<Integer> leftProductsWithoutCurrentIndex = new ArrayList<>(Collections.nCopies(size, 1));
        List<Integer> rightProductsWithoutCurrentIndex = new ArrayList<>(Collections.nCopies(size, 1));
        Integer leftSumSofar = 1;
        Integer rightSumSofar = 1;
        for(int i=1; i<size; i++){
            leftSumSofar = input.get(i - 1) * leftProductsWithoutCurrentIndex.get(i - 1);
            leftProductsWithoutCurrentIndex.set(i, leftSumSofar);
            rightSumSofar = input.get(size - i) * rightProductsWithoutCurrentIndex.get(size - i);
            rightProductsWithoutCurrentIndex.set(size - i - 1, rightSumSofar);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<size; i++){
            result.add(leftProductsWithoutCurrentIndex.get(i) * rightProductsWithoutCurrentIndex.get(i));
        }
        return result;

    }
}
