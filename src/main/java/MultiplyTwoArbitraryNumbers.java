import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyTwoArbitraryNumbers {

    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>(Arrays.asList(1,0,0,0,0,0));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(1,0,0,0,0,0));
        List<Integer> result = perform(num1, num2);
        System.out.println(result);
    }
    
    public static List<Integer> perform(List<Integer> num1, List<Integer> num2) {
        int sign = Integer.compare(num1.get(0) * num2.get(0), 0);
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for(int i = num1.size() - 1; i >= 0; i--) {
            for(int j = num2.size() - 1; j >= 0; j--) {
                result.set(i + j + 1, 
                        result.get(i + j + 1) + num1.get(i) * num2.get(j) );
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }
        int numOfFirstZero = 0;
        while(numOfFirstZero < result.size() && result.get(numOfFirstZero) == 0) {
            numOfFirstZero++;
        }
        result = result.subList(numOfFirstZero, result.size());
        if(result.isEmpty()) return Arrays.asList(0);
        result.set(0, sign * result.get(0));
        return result;
    }
}
