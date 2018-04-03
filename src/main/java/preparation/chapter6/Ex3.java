package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>(Arrays.asList(-1,8,7));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(-1,2,3));
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        boolean sign = num1.get(0) * num2.get(0) < 0;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));
        for(int i = num1.size() - 1; i>=0; i--){
            for(int j = num2.size() - 1; j>=0; j--){
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }
        int firstZeros = 0;
        while(result.get(firstZeros) == 0 && firstZeros < result.size()){
            firstZeros++;
        }
        result = result.subList(firstZeros, result.size());
        if(sign) result.set(0, -result.get(0));
        System.out.println(result);
    }
}
