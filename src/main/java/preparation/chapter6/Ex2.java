package preparation.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,2,9));
        int temp = number.get(number.size() - 1) + 1;
        boolean carry = temp < 10 ? false : true;
        number.set((number.size() - 1), temp % 10);
        for(int i=number.size() - 2; i>=0 && carry; i--){
            temp = number.get(i) + 1;
            number.set(i, temp % 10);
            carry = temp < 10 ? false : true;
        }
        if(carry) number.add(0, 1);
        System.out.println(number);
    }
}
